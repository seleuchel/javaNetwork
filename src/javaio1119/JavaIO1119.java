package javaio1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//EX 1 : Time client
import java.net.*;
import java.text.*;
import java.util.Date;
import java.io.*;

//EX 1. Time client
//public class JavaIO1119 {
//  
//  private static final String HOSTNAME = "time.nist.gov";
//
//  public static void main(String[] args) throws IOException, ParseException {
//    Date d = JavaIO1119.getDateFromNetwork();
//    System.out.println("It is " + d);
//  }
//  
//  public static Date getDateFromNetwork() throws IOException, ParseException {
//    // The time protocol sets the epoch at 1900,
//    // the Java Date class at 1970. This number 
//    // converts between them.
//    
//    long differenceBetweenEpochs = 2208988800L;
//    
//    // If you'd rather not use the magic number, uncomment 
//    // the following section which calculates it directly.
//    /*    
//    TimeZone gmt = TimeZone.getTimeZone("GMT");
//    Calendar epoch1900 = Calendar.getInstance(gmt);
//    epoch1900.set(1900, 01, 01, 00, 00, 00);
//    long epoch1900ms = epoch1900.getTime().getTime();
//    Calendar epoch1970 = Calendar.getInstance(gmt);
//    epoch1970.set(1970, 01, 01, 00, 00, 00);
//    long epoch1970ms = epoch1970.getTime().getTime();
//    
//    long differenceInMS = epoch1970ms - epoch1900ms;
//    long differenceBetweenEpochs = differenceInMS/1000;
//    */    
//    
//    Socket socket = null;
//    try {
//      socket = new Socket(HOSTNAME, 37);
//      socket.setSoTimeout(15000);
//
//      InputStream raw = socket.getInputStream();
//      
//      long secondsSince1900 = 0;
//      for (int i = 0; i < 4; i++) {
//        secondsSince1900 = (secondsSince1900 << 8) | raw.read();
//      }
//
//      long secondsSince1970 
//                = secondsSince1900 - differenceBetweenEpochs;       
//      long msSince1970 = secondsSince1970 * 1000;
//      Date time = new Date(msSince1970);
//      
//      return time;
//    } finally {
//      try {
//        if (socket != null) socket.close(); 
//      }
//      catch (IOException ex) {}
//    }
//  }
//}
//ephoch : 70년. 


//EX 1 : Time server
//public class JavaIO1119 {
//
//	public final static int PORT = 37;
//
//	public static void main(String[] args) {
//		// The time protocol sets the epoch at 1900,
//		// the Date class at 1970. This number
//		// converts between them.
//		long differenceBetweenEpochs = 2208988800L;// #70년을 나타내는 수 #자바 값으로 하려면 70년을 더해야 함
//		// 4개 바이트의 정수로 보낸다.
//
//		try (ServerSocket server = new ServerSocket(PORT)) {
//			while (true) {
//				try (Socket connection = server.accept()) {
//					OutputStream out = connection.getOutputStream();
//					Date now = new Date();
//					long msSince1970 = now.getTime();
//					long secondsSince1970 = msSince1970 / 1000;
//					long secondsSince1900 = secondsSince1970 + differenceBetweenEpochs;
//					byte[] time = new byte[4];
//					time[0] = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
//					time[1] = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
//					time[2] = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
//					time[3] = (byte) (secondsSince1900 & 0x00000000000000FFL);
//					out.write(time);
//					out.flush();
//				} catch (IOException ex) {
//					System.err.println(ex.getMessage());
//				}
//			}
//		} catch (IOException ex) {
//			System.err.println(ex);
//		}
//	}
//}

//>>> 어플리케이션
//EX 1 : Dictionary Server
//예제 8-4: English-to-Latin 변환기
//어플리케이션 프로토콜로 짜진 프로그램
//public class JavaIO1119 {
//
//	  public static final String SERVER = "dict.org";
//	  public static final int PORT = 2628;
//	  public static final int TIMEOUT = 15000;
//	  
//	  public static void main(String[] args) {
//
//	    Socket socket = null;
//	    try {
//	      socket = new Socket(SERVER, PORT);
//	      System.out.println(socket);
//	      //try to connect server
//	      //if you pass this sentense, your socket connection is successed!
//	      socket.setSoTimeout(TIMEOUT);
//	      OutputStream out = socket.getOutputStream();
//	      Writer writer = new OutputStreamWriter(out, "UTF-8");
//	      writer = new BufferedWriter(writer);
//	      InputStream in = socket.getInputStream();
//	      BufferedReader reader = new BufferedReader(
//	          new InputStreamReader(in, "UTF-8"));
//	      
//	      for (String word : args) {
//	        define(word, writer, reader);
//	      }
//	      
//	      writer.write("quit\r\n");
//	      writer.flush();
//	    } catch (IOException ex) {
//	      System.err.println(ex);
//	    } finally { // dispose
//	      if (socket != null) {
//	        try {
//	          socket.close();
//	        } catch (IOException ex) {
//	          // ignore
//	        }
//	      }
//	    }
//	  }
//
//	  static void define(String word, Writer writer, BufferedReader reader)
//	      throws IOException, UnsupportedEncodingException {
//	    writer.write("DEFINE fd-eng-lat " + word + "\r\n");
//	    writer.flush();
//
//	    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//	      if (line.startsWith("250 ")) { // OK
//	        return;
//	      } else if (line.startsWith("552 ")) { // no match
//	        System.out.println("No definition found for " + word);
//	        return;
//	      }
//	      else if (line.matches("\\d\\d\\d .*")) continue;
//	      else if (line.trim().equals(".")) continue;
//	      else System.out.println(line);
//	    }
//	  } 
//	}
//

// EX 2
// close half socker 

//EX 3
//예제 8-5: LowPortScanner 포트 스캐닝
//public class JavaIO1119 {
//
//	  public static void main(String[] args) {
//	    
//	    String host = args.length > 0 ? args[0] : "localhost";
//
//	    for (int i = 1; i < 1024; i++) {
//	      try {
//	        Socket s = new Socket(host, i);
//	        
//	        System.out.print(s.getInetAddress());
//	        System.out.print(s.getRemoteSocketAddress());
//	        System.out.println("There is a server on port " + i + " of " 
//	         + host);
//	        s.close();
//	      } catch (UnknownHostException ex) {
//	        System.err.println(ex);
//	        break;
//	      } catch (IOException ex) {
//	        // must not be a server on this port
//	      }
//	    }
//	  }
//	}

//EX 3
//public class JavaIO1119 {
//	public static void main(String[] args) {
//		String hostname = "localhost";
//		PrintWriter networkOut = null;
//		BufferedReader networkIn = null;
//		try {
//			Socket server = new Socket(hostname, 7);
//			networkIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
//			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
//			networkOut = new PrintWriter(server.getOutputStream());
//			System.out.println(
//					"Connected to echo server " + server.getInetAddress() + "의 Port " + server.getPort() + "에 서비스 요청");
//
//			while (true) {
//				System.out.println("서버로 보낼 문장을 입력하시오(.은 종료)");
//				String theLine = userIn.readLine();
//				if (theLine.equals("."))
//					break;
//				networkOut.println(theLine);
//				networkOut.flush();
//				System.out.println(networkIn.readLine());
//			}
//		} // end try
//		catch (IOException e) {
//			System.err.println(e);
//		} finally {
//			try {
//				System.out.println("클라이언트가 입출력 스트림을 닫습니다.");
//				if (networkIn != null)
//					networkIn.close();
//				if (networkOut != null)
//					networkOut.close();
//			} catch (IOException e) {
//			}
//		}
//	} // end main
//} // end EchoClient
