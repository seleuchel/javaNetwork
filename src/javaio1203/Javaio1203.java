package javaio1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

//time out
/*
 * TCP는 서비스를 정확하게 제공을 해줌
 * 소켓에서 가장 중요한 것이 서버 타임아웃
 * P.46
 * InterruptedIOException, SocketTimeoutException을 많이 사용
 * 
 * 어플리케이션마다 명령어가 다르다.
 * single-file Server
 * 
 */

//예제1///////////////////////////////////////////////
//
//import java.io.*;
//import java.net.*;
//import java.nio.charset.Charset;
//import java.nio.file.*;
//import java.util.concurrent.*;
//import java.util.logging.*;
//
//public class Javaio1203 {
//
//	private static final Logger logger = Logger.getLogger("SingleFileHTTPServer"); //이거는 뭐하는 거지
//
//	private final byte[] content;
//	private final byte[] header;
//	private final int port;
//	private final String encoding;
//
//	public Javaio1203(String data, String encoding, String mimeType, int port)
//			throws UnsupportedEncodingException {
//		this(data.getBytes(encoding), encoding, mimeType, port);
//	}
//
//	public Javaio1203(byte[] data, String encoding, String mimeType, int port) {
//		this.content = data;
//		this.port = port;
//		this.encoding = encoding;
//		String header = "HTTP/1.0 200 OK\r\n" + "Server: OneFile 2.0\r\n" + "Content-length: " + this.content.length
//				+ "\r\n" + "Content-type: " + mimeType + "; charset=" + encoding + "\r\n\r\n";
//		this.header = header.getBytes(Charset.forName("US-ASCII"));
//	}
//
//	public void start() {
//		ExecutorService pool = Executors.newFixedThreadPool(100);
//		try (ServerSocket server = new ServerSocket(this.port)) {
//			logger.info("Accepting connections on port " + server.getLocalPort());
//			logger.info("Data to be sent:");
//			logger.info(new String(this.content, encoding));
//
//			while (true) {
//				try {
//					Socket connection = server.accept();
//					pool.submit(new HTTPHandler(connection));
//				} catch (IOException ex) {
//					logger.log(Level.WARNING, "Exception accepting connection", ex);
//				} catch (RuntimeException ex) {
//					logger.log(Level.SEVERE, "Unexpected error", ex);
//				}
//			}
//		} catch (IOException ex) {
//			logger.log(Level.SEVERE, "Could not start server", ex);
//		}
//	}
//
//	private class HTTPHandler implements Callable<Void> {
//		private final Socket connection;
//
//		HTTPHandler(Socket connection) {
//			this.connection = connection;
//		}
//
//		@Override
//		public Void call() throws IOException {
//			try {
//				OutputStream out = new BufferedOutputStream(connection.getOutputStream());
//				InputStream in = new BufferedInputStream(connection.getInputStream());
//				// read the first line only; that's all we need
//				StringBuilder request = new StringBuilder(80);
//				while (true) {
//					int c = in.read();
//					if (c == '\r' || c == '\n' || c == -1)
//						break;
//					request.append((char) c);
//				}
//				// If this is HTTP/1.0 or later send a MIME header
//				if (request.toString().indexOf("HTTP/") != -1) {
//					out.write(header);
//				}
//				out.write(content);
//				out.flush();
//			} catch (IOException ex) {
//				logger.log(Level.WARNING, "Error writing to client", ex);
//			} finally {
//				connection.close();
//			}
//			return null;
//		}
//	}
//
//	public static void main(String[] args) {
//
//		// set the port to listen on
//		int port;
//		try {
//			port = Integer.parseInt(args[1]);
//			if (port < 1 || port > 65535)
//				port = 80;
//		} catch (RuntimeException ex) {
//			port = 80;
//		}
//
//		String encoding = "UTF-8";
//		if (args.length > 2)
//			encoding = args[2];
//
//		try {
//			Path path = Paths.get(args[0]);
//			byte[] data = Files.readAllBytes(path);
//
//			String contentType = URLConnection.getFileNameMap().getContentTypeFor(args[0]);
//			Javaio1203 server = new Javaio1203(data, encoding, contentType, port);
//			server.start();
//
//		} catch (ArrayIndexOutOfBoundsException ex) {
//			System.out.println("Usage: java SingleFileHTTPServer filename port encoding");
//		} catch (IOException ex) {
//			logger.severe(ex.getMessage());
//		}
//	}
//}
///////////////////////////////////////////////////////////////

//예제2/////////////////////////////////////////////////////////
//import java.io.BufferedInputStream;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.Reader;
//import java.io.Writer;
//import java.net.BindException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Javaio1203 { //redirect
//
//	private static final Logger logger = Logger.getLogger("Redirector");
//
//	private final int port;
//	private final String newSite;
//
//	public Javaio1203(String newSite, int port) {
//		this.port = port;
//		this.newSite = newSite;
//	}
//
//	public void start() {
//		try (ServerSocket server = new ServerSocket(port)) {
//			logger.info("Redirecting connections on port " + server.getLocalPort() + " to " + newSite);
//
//			while (true) {
//				try {
//					Socket s = server.accept();
//					Thread t = new RedirectThread(s);
//					t.start();
//				} catch (IOException ex) {
//					logger.warning("Exception accepting connection");
//				} catch (RuntimeException ex) {
//					logger.log(Level.SEVERE, "Unexpected error", ex);
//				}
//			}
//		} catch (BindException ex) {
//			logger.log(Level.SEVERE, "Could not start server.", ex);
//		} catch (IOException ex) {
//			logger.log(Level.SEVERE, "Error opening server socket", ex);
//		}
//	}
//
//	private class RedirectThread extends Thread {
//
//		private final Socket connection;
//
//		RedirectThread(Socket s) {
//			this.connection = s;
//		}
//
//		public void run() {
//			try {
//				Writer out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "US-ASCII"));
//				Reader in = new InputStreamReader(new BufferedInputStream(connection.getInputStream()));
//
//				// 첫 줄만 읽는다
//				StringBuilder request = new StringBuilder(80);
//				while (true) {
//					int c = in.read();
//					if (c == '\r' || c == '\n' || c == -1)
//						break;
//					request.append((char) c);
//				}
//
//				String get = request.toString();
//				String[] pieces = get.split("\\w*");
//				String theFile = pieces[1];
//
//				// HTTP/1.0 이후 버전이면 MIME header 전송
//				if (get.indexOf("HTTP") != -1) {
//					out.write("HTTP/1.0 302 FOUND\r\n");
//					Date now = new Date();
//					out.write("Date: " + now + "\r\n");
//					out.write("Server: Redirector 1.1\r\n");
//					out.write("Location: " + newSite + theFile + "\r\n");
//					out.write("Content-type: text/html\r\n\r\n");
//					out.flush();
//				}
//				// Not all browsers support redirection so we need to
//				// produce HTML that says where the document has moved to.
//				out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
//				out.write("<BODY><H1>Document moved</H1>\r\n");
//				out.write("The document " + theFile + " has moved to\r\n<A HREF=\"" + newSite + theFile + "\">"
//						+ newSite + theFile + "</A>.\r\n Please update your bookmarks<P>");
//				out.write("</BODY></HTML>\r\n");
//				out.flush();
//				logger.log(Level.INFO, "Redirected " + connection.getRemoteSocketAddress());
//			} catch (IOException ex) {
//				logger.log(Level.WARNING, "Error talking to " + connection.getRemoteSocketAddress(), ex);
//			} finally {
//				try {
//					connection.close();
//				} catch (IOException ex) {
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//
//		int thePort;
//		String theSite;
//
//		try {
//			theSite = args[0];
//			// url 맨 뒤의 slash 제거
//			if (theSite.endsWith("/")) {
//				theSite = theSite.substring(0, theSite.length() - 1);
//			}
//		} catch (RuntimeException ex) {
//			System.out.println("Usage: java Redirector http://NEWSITE/ port");
//			return;
//		}
//
//		try {
//			thePort = Integer.parseInt(args[1]);
//		} catch (RuntimeException ex) {
//			thePort = 80;
//		}
//
//		Javaio1203 redirector = new Javaio1203(theSite, thePort);
//		redirector.start();
//	}
//}
///////////////////////////////////////////////////////////////////////////////

//채팅 과제 
/*
 * 지금까지의 채팅은 보내고 받는 것을 했음. 모든 사람이 대화를 할 수 있게 함. 서버가 있고 클라가 5명 들어옴. 그랬을 때, AB 끼리
 * 대화하는 것이 아니라 모든 클라가 메시지를 서버에게만 보내고 서버는 그 모든 응답을 클라에게 브로드캐스트 함. 이런 식으로 동작하도록
 * 코드를 만들어라.
 * 
 * 클라는 자신이 CONNECT 아마 GUI 화면이 있어야 함. TEXT FILED 엣 김 이라는 이름.
 * 
 * 자기잔싱의 이름을 CONNECTION -> 서버는 A 님이 입장하셨습니다 라고 응답하여야 함. 서버는 모든 클라와의 소켓을 VECTOR에
 * 저장
 * 
 * 어느 곳에 클라가 문장을 보내더라도 서버는 브로드캐스트 해 주어야 함.
 * 
 * 당연히 탈퇴 처리도 있어야 하고 - 서버의 벡터에서 지워져야 한다. //채팅 프로그램을 만들어야함. GUI 내와 내용은 TEXT AREA,
 * 이름 입력은 TEXT FIELD
 * 
 * 과제는 기말고사 끝나고 1주일 정도 시간을 준다고 함.
 */
//
//예제 3////
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.SocketException;
//
////import com.macfaq.io.SafeBufferedReader; // from Chapter 4
//public class Javaio1203 {
//	
//	public static void main(String[] args) {
//		int port;
//		try {
//			port = Integer.parseInt(args[0]);
//		} catch (Exception ex) {
//			port = 0;
//		}
//		try {
//			ServerSocket server = new ServerSocket(port, 1);
//			System.out.println("Listening for connections on port " + server.getLocalPort());
//			while (true) {
//				Socket connection = server.accept();
//				try {
//					System.out.println("Connection established with " + connection);
//					Thread input = new InputThread(connection.getInputStream());
//					input.start();
//					Thread output = new OutputThread(connection.getOutputStream());
//					output.start();
//// wait for output and input to finish 
//					try {
//						input.join();
//						output.join();
//					} catch (InterruptedException ex) {
//					}
//				} catch (IOException ex) {
//					System.err.println(ex);
//				} finally {
//					try {
//						if (connection != null)
//							connection.close();
//					} catch (IOException ex) {
//					}
//				}
//			}
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}
//}
//
//class InputThread extends Thread {
//	InputStream in;
//
//	public InputThread(InputStream in) {
//		this.in = in;
//	}
//
//	public void run() {
//		try {
//			int i = in.read();
//			while (i != -1) {
//				System.out.write(i);
//				i = in.read();
//			}
//		} catch (SocketException ex) {
//			// output thread closed the socket
//		} catch (IOException ex) {
//			System.err.println(ex);
//		}
//		try {
//			in.close();
//		} catch (IOException ex) {
//		}
//	}
//}
//
//class OutputThread extends Thread {
//	private Writer out;
//
//	public OutputThread(OutputStream out) {
//		this.out = new OutputStreamWriter(out);
//	}
//
//	public void run() {
//		String line;
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			line = in.readLine();
//			while (!(line.equals("."))) {
//				out.write(line + "\r\n");
//				out.flush();
//				line = in.readLine();
//			}
//		} catch (IOException ex) {
//		}
//		try {
//			out.close();
//		} catch (IOException ex) {
//		}
//	}
//}

/////////////// udp
/*
 * 연결이 없으므로 데이터를 보낼 때 마다 
 * 매번 주소와 포트를 사용해서 보낸다.
 * unreliable : 100% 정확히 서비스 하지 않음.
 * 신뢰는 할 수 있는 프로토콜임!
 * 
 * 
 * 
 */


//예제1 server
import java.net.*;
import java.util.Date;
import java.util.logging.*;
import java.io.*;

public class Javaio1203 {

  private final static int PORT = 13;
  private final static Logger audit = Logger.getLogger("requests");
  private final static Logger errors = Logger.getLogger("errors");

  public static void main(String[] args) {
    try (DatagramSocket socket = new DatagramSocket(PORT)) {
      while (true) {
        try {
          DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);
          socket.receive(request);
          
          String daytime = new Date().toString();
          byte[] data = daytime.getBytes("US-ASCII");
          DatagramPacket response = new DatagramPacket(data, data.length, 
              request.getAddress(), request.getPort());
          socket.send(response);
          audit.info(daytime + " " + request.getAddress());
        } catch (IOException | RuntimeException ex) {
          errors.log(Level.SEVERE, ex.getMessage(), ex);
        }
      }
    } catch (IOException ex) {
      errors.log(Level.SEVERE, ex.getMessage(), ex);
    }
  } 
}


//reliable 프로토콜 사용한 것처림 수행.

