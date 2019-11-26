package javaio1126;
////
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.io.PrintWriter;
////import java.net.InetSocketAddress;
////import java.net.ServerSocket;
////import java.net.Socket;
////import java.nio.ByteBuffer;
////import java.nio.channels.SelectionKey;
////import java.nio.channels.Selector;
////import java.nio.channels.ServerSocketChannel;
////import java.nio.channels.SocketChannel;
////import java.util.Iterator;
////import java.util.Set;
////
////public class JAVAIO1126 {
//////1. THREAD의 DAYTIME SERVER
//////
//////	public final static int PORT = 13;
//////
//////	public static void main(String[] args) {
//////		try (ServerSocket server = new ServerSocket(PORT)) {
//////			while (true) {
//////				try {
//////					Socket connection = server.accept();
//////					Thread task = new DaytimeThread(connection);
//////					task.start();
//////				} catch (IOException ex) {
//////				}
//////			}
//////		} catch (IOException ex) {
//////			System.err.println("Couldn't start server");
//////		}
//////	}
//////
//////	private static class DaytimeThread extends Thread {
//////
//////		private Socket connection;
//////
//////		DaytimeThread(Socket connection) {
//////			this.connection = connection;
//////		}
//////
//////		public void run() {
//////			try {
//////				Writer out = new OutputStreamWriter(connection.getOutputStream());
//////				Date now = new Date();
//////				out.write(now.toString() + "\r\n");
//////				out.flush();
//////			} catch (IOException ex) {
//////				System.err.println(ex);
//////			} finally {
//////				try {
//////					connection.close();
//////				} catch (IOException e) {
//////					// ignore;
//////				}
//////			}
//////		}
////
//////	}
////
////	// client
////
////	//// client 1
////////		public static void main(String[] args) {
////	////
////////			String hostname = args.length > 0 ? args[0] : "localhost";
////////			Socket socket = null;
////////			try {
////////				socket = new Socket(hostname, 13);
////////				socket.setSoTimeout(15000);
////////				InputStream in = socket.getInputStream();
////////				InputStreamReader reader = new InputStreamReader(in, "ASCII");
////////				StringBuilder time = new StringBuilder();
////////				for (int c = reader.read(); c != -1; c = reader.read()) {
////////					time.append((char) c);
////////				}
////////				System.out.println(time);
////////			} catch (IOException ex) {
////////				System.err.println(ex);
////////			} finally {
////////				if (socket != null) {
////////					try {
////////						socket.close();
////////					} catch (IOException ex) {
////////						// ignore
////////					}
////////				}
////////			}
////////		}
////	// import java.io.IOException;
////	// import java.io.OutputStream;
////	// import java.net.ServerSocket;
////	// import java.net.Socket;
////	// import java.util.Date;
//////		 
//////		public class DaytimeClient {
//////		 
//////		  public final static int PORT = 37;
////	//
//////		  public static void main(String[] args) {    
////	//
//////		   // The time protocol sets the epoch at 1900,
//////		   // the Date class at 1970. This number 
//////		   // converts between them.
//////			  
//////			  
//////			  // this is server version - ~ echo server까지. 정리하기 + ppt 위주
//////		   long differenceBetweenEpochs = 2208988800L;
//////		    
//////		   try (ServerSocket server = new ServerSocket(PORT)) {
//////		     while (true) {
//////		       try (Socket connection = server.accept()) {
//////		         OutputStream out = connection.getOutputStream();
//////		         Date now = new Date();
//////		         long msSince1970 = now.getTime();
//////		         long secondsSince1970 = msSince1970/1000;
//////		         long secondsSince1900 = secondsSince1970 
//////		             + differenceBetweenEpochs;
//////		         byte[] time = new byte[4];
//////		         time[0] 
//////		             = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
//////		         time[1] 
//////		             = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
//////		         time[2] 
//////		             = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
//////		         time[3] = (byte) (secondsSince1900 & 0x00000000000000FFL);
//////		         out.write(time);
//////		         out.flush();      
//////		       } catch (IOException ex) {
//////		         System.err.println(ex.getMessage());
//////		       }
//////		     }
//////		   } catch (IOException ex) {
//////		     System.err.println(ex);
//////		   }
//////		  }
//////		}
////	//
////	//
////
////	// public class DaytimeClient {
//////		public static void main(String[] args) {
//////			try {
//////				ServerSocket server = new ServerSocket(7);
//////				System.out.println("접속을 기다립니다.");
//////				Socket sock = server.accept();
//////				System.out.println(sock.getInetAddress() + " " + sock.getPort() + " 로 부터 접속 요청");
//////				OutputStream out = sock.getOutputStream();
//////				InputStream in = sock.getInputStream();
//////				PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
//////				BufferedReader br = new BufferedReader(new InputStreamReader(in));
//////				String line = null;
//////				while ((line = br.readLine()) != null) {
//////					System.out.println("클라이언트로 부터 전송 받은 문자열 : " + line);
//////					pw.println(line);
//////					pw.flush();
//////				}
//////				pw.close();
//////				br.close();
//////				sock.close();
//////			} catch (Exception e) {
//////				System.out.println(e);
//////			}
//////		} // main
////	// }
//////
//////	import java.net.*;
//////	import java.text.*;
//////	import java.util.Date;
//////	import java.io.*;
//////
//////	public class DaytimeClient {
//////	  
//////	  private static final String HOSTNAME = "168.131.154.35";
//////	  private static final int PORT = 13;
//////
//////	  public static void main(String[] args) throws IOException, ParseException {
//////		 
//////	    Date d = DaytimeClient.getDateFromNetwork();
//////	    System.out.println("It is " + d);
//////	  }
//////	  
//////	  public static Date getDateFromNetwork() throws IOException, ParseException {
//////
//////	    long differenceBetweenEpochs = 2208988800L;
//////	    
//////	    Socket socket = null;
//////	    try {
//////	    InetAddress fi = InetAddress.getByName(HOSTNAME);
//////	      socket = new Socket(HOSTNAME, PORT, fi, 0);
//////	      socket.setSoTimeout(15000);
//////
//////	      InputStream raw = socket.getInputStream();
//////	      
//////	      long secondsSince1900 = 0;
//////	      for (int i = 0; i < 4; i++) {
//////	        secondsSince1900 = (secondsSince1900 << 8) | raw.read();
//////	      }
//////
//////	      long secondsSince1970 
//////	                = secondsSince1900 - differenceBetweenEpochs;       
//////	      long msSince1970 = secondsSince1970 * 1000;
//////	      Date time = new Date(msSince1970);
//////	      
//////	      return time;
//////	    } finally {
//////	      try {
//////	        if (socket != null) socket.close(); 
//////	      }
//////	      catch (IOException ex) {}
//////	    }
//////	  }
//////	}
//////}
////
////	
////	//3. echo server
////	public static int DEFAULT_PORT = 7;
////
////	public static void main(String[] args) {
////
////		int port;
////		try {
////			port = Integer.parseInt(args[0]);
////		} catch (RuntimeException ex) {
////			port = DEFAULT_PORT;
////		}
////		System.out.println("Listening for connections on port " + port);
////
////		ServerSocketChannel serverChannel;
////		Selector selector;
////		try {
////			serverChannel = ServerSocketChannel.open();
////			ServerSocket ss = serverChannel.socket();
////			InetSocketAddress address = new InetSocketAddress(port);
////			ss.bind(address);
////			serverChannel.configureBlocking(false);
////			selector = Selector.open();
////			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
////		} catch (IOException ex) {
////			ex.printStackTrace();
////			return;
////		}
////		while (true) {
////			try {
////				selector.select();
////			} catch (IOException ex) {
////				ex.printStackTrace();
////				break;
////			}
////
////			Set<SelectionKey> readyKeys = selector.selectedKeys();
////			Iterator<SelectionKey> iterator = readyKeys.iterator();
////			while (iterator.hasNext()) {
////				SelectionKey key = iterator.next();
////				iterator.remove();
////				try {
////					if (key.isAcceptable()) {
////						ServerSocketChannel server = (ServerSocketChannel) key.channel();
////						SocketChannel client = server.accept();
////						System.out.println("Accepted connection from " + client);
////						client.configureBlocking(false);
////						SelectionKey clientKey = client.register(selector,
////								SelectionKey.OP_WRITE | SelectionKey.OP_READ);
////						ByteBuffer buffer = ByteBuffer.allocate(100);
////						clientKey.attach(buffer);
////					}
////					if (key.isReadable()) {
////						SocketChannel client = (SocketChannel) key.channel();
////						ByteBuffer output = (ByteBuffer) key.attachment();
////						client.read(output);
////					}
////					if (key.isWritable()) {
////						SocketChannel client = (SocketChannel) key.channel();
////						ByteBuffer output = (ByteBuffer) key.attachment();
////						output.flip();
////						client.write(output);
////						output.compact();
////					}
////				} catch (IOException ex) {
////					key.cancel();
////					try {
////						key.channel().close();
////					} catch (IOException cex) {
////					}
////				}
////			}
////		}
////	}
/////*
//// * //3. echo client
////	
////	public static void main(String[] args) {
////		String hostname = "localhost";
////		if (args.length > 0) {
////			hostname = args[0];
////		}
////		PrintWriter networkOut = null;
////		BufferedReader networkIn = null;
////		try {
////			Socket theSocket = new Socket(hostname, 7);
////			networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
////			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
////			networkOut = new PrintWriter(theSocket.getOutputStream());
////			System.out.println("Connected to echo server");
////
////			while (true) {
////				String theLine = userIn.readLine();
////				if (theLine.equals("."))
////					break;
////				networkOut.println(theLine);
////				networkOut.flush();
////				System.out.println(networkIn.readLine());
////			}
////		} // end try
////		catch (IOException ex) {
////			System.err.println(ex);
////		} finally {
////			try {
////				if (networkIn != null)
////					networkIn.close();
////				if (networkOut != null)
////					networkOut.close();
////			} catch (IOException ex) {
////			}
////		}
////	} // end main
////} // end EchoClient
////
//// */
////}
//
//import java.io.*;
//import java.net.*;
//
//public class JAVAIO1126 {
//	public static void main(String[] args) {
//		try {
//			ServerSocket server = new ServerSocket(7);
//			System.out.println("접속을 기다립니다.");
//			Socket sock = server.accept();
//			System.out.println(sock.getInetAddress() + " " + sock.getPort() + " 로 부터 접속 요청");
//			OutputStream out = sock.getOutputStream();
//			InputStream in = sock.getInputStream();
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				System.out.println("클라이언트로 부터 전송 받은 문자열 : " + line);
//				pw.println(line);
//				pw.flush();
//			}
//			pw.close();
//			br.close();
//			sock.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	} // main
//}

import java.net.*;
import java.io.*;
import java.util.Date;

public class JAVAIO1126 {

	public final static int PORT = 13;

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				try {
					Socket connection = server.accept();
					Thread task = new DaytimeThread(connection);
					task.start();
				} catch (IOException ex) {
				}
			}
		} catch (IOException ex) {
			System.err.println("Couldn't start server");
		}
	}

	private static class DaytimeThread extends Thread {
		// 스레드가 일을 하도록 바꾸어야 한다.
		private Socket connection;

		DaytimeThread(Socket connection) {
			this.connection = connection;
		}

		public void run() {
			try {
				Writer out = new OutputStreamWriter(connection.getOutputStream());
				Date now = new Date();
				out.write(now.toString() + "\r\n");
				out.flush();
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				try {
					connection.close();
				} catch (IOException e) {
					// ignore;
				}
			}
		}
	}
}
