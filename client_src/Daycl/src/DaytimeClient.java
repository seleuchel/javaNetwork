//////
////////import java.io.BufferedReader;
////////import java.io.InputStream;
////////import java.io.InputStreamReader;
////////import java.io.OutputStream;
////////import java.io.OutputStreamWriter;
////////import java.io.PrintWriter;
////////import java.net.ServerSocket;
////////import java.net.Socket;
////////
//////////// client 1
////////////	public static void main(String[] args) {
////////////
////////////		String hostname = args.length > 0 ? args[0] : "localhost";
////////////		Socket socket = null;
////////////		try {
////////////			socket = new Socket(hostname, 13);
////////////			socket.setSoTimeout(15000);
////////////			InputStream in = socket.getInputStream();
////////////			InputStreamReader reader = new InputStreamReader(in, "ASCII");
////////////			StringBuilder time = new StringBuilder();
////////////			for (int c = reader.read(); c != -1; c = reader.read()) {
////////////				time.append((char) c);
////////////			}
////////////			System.out.println(time);
////////////		} catch (IOException ex) {
////////////			System.err.println(ex);
////////////		} finally {
////////////			if (socket != null) {
////////////				try {
////////////					socket.close();
////////////				} catch (IOException ex) {
////////////					// ignore
////////////				}
////////////			}
////////////		}
////////////	}
//////////import java.io.IOException;
//////////import java.io.OutputStream;
//////////import java.net.ServerSocket;
//////////import java.net.Socket;
//////////import java.util.Date;
//////////	 
//////////	public class DaytimeClient {
//////////	 
//////////	  public final static int PORT = 37;
//////////
//////////	  public static void main(String[] args) {    
//////////
//////////	   // The time protocol sets the epoch at 1900,
//////////	   // the Date class at 1970. This number 
//////////	   // converts between them.
//////////		  
//////////		  
//////////		  // this is server version - ~ echo server까지. 정리하기 + ppt 위주
//////////	   long differenceBetweenEpochs = 2208988800L;
//////////	    
//////////	   try (ServerSocket server = new ServerSocket(PORT)) {
//////////	     while (true) {
//////////	       try (Socket connection = server.accept()) {
//////////	         OutputStream out = connection.getOutputStream();
//////////	         Date now = new Date();
//////////	         long msSince1970 = now.getTime();
//////////	         long secondsSince1970 = msSince1970/1000;
//////////	         long secondsSince1900 = secondsSince1970 
//////////	             + differenceBetweenEpochs;
//////////	         byte[] time = new byte[4];
//////////	         time[0] 
//////////	             = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
//////////	         time[1] 
//////////	             = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
//////////	         time[2] 
//////////	             = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
//////////	         time[3] = (byte) (secondsSince1900 & 0x00000000000000FFL);
//////////	         out.write(time);
//////////	         out.flush();      
//////////	       } catch (IOException ex) {
//////////	         System.err.println(ex.getMessage());
//////////	       }
//////////	     }
//////////	   } catch (IOException ex) {
//////////	     System.err.println(ex);
//////////	   }
//////////	  }
//////////	}
//////////
//////////
////////
//////////public class DaytimeClient {
//////////	public static void main(String[] args) {
//////////		try {
//////////			ServerSocket server = new ServerSocket(7);
//////////			System.out.println("접속을 기다립니다.");
//////////			Socket sock = server.accept();
//////////			System.out.println(sock.getInetAddress() + " " + sock.getPort() + " 로 부터 접속 요청");
//////////			OutputStream out = sock.getOutputStream();
//////////			InputStream in = sock.getInputStream();
//////////			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
//////////			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//////////			String line = null;
//////////			while ((line = br.readLine()) != null) {
//////////				System.out.println("클라이언트로 부터 전송 받은 문자열 : " + line);
//////////				pw.println(line);
//////////				pw.flush();
//////////			}
//////////			pw.close();
//////////			br.close();
//////////			sock.close();
//////////		} catch (Exception e) {
//////////			System.out.println(e);
//////////		}
//////////	} // main
//////////}
////////
////////import java.net.*;
////////import java.text.*;
////////import java.util.Date;
////////import java.io.*;
////////
////////public class DaytimeClient {
//////////  
//////////  private static final String HOSTNAME = "168.131.154.35";
//////////  private static final int PORT = 13;
//////////
//////////  public static void main(String[] args) throws IOException, ParseException {
//////////	 
//////////    Date d = DaytimeClient.getDateFromNetwork();
//////////    System.out.println("It is " + d);
//////////  }
//////////  
//////////  public static Date getDateFromNetwork() throws IOException, ParseException {
//////////
//////////    long differenceBetweenEpochs = 2208988800L;
//////////    
//////////    Socket socket = null;
//////////    try {
//////////    InetAddress fi = InetAddress.getByName(HOSTNAME);
//////////      socket = new Socket(HOSTNAME, PORT, fi, 0);
//////////      socket.setSoTimeout(15000);
//////////
//////////      InputStream raw = socket.getInputStream();
//////////      
//////////      long secondsSince1900 = 0;
//////////      for (int i = 0; i < 4; i++) {
//////////        secondsSince1900 = (secondsSince1900 << 8) | raw.read();
//////////      }
//////////
//////////      long secondsSince1970 
//////////                = secondsSince1900 - differenceBetweenEpochs;       
//////////      long msSince1970 = secondsSince1970 * 1000;
//////////      Date time = new Date(msSince1970);
//////////      
//////////      return time;
//////////    } finally {
//////////      try {
//////////        if (socket != null) socket.close(); 
//////////      }
//////////      catch (IOException ex) {}
//////////    }
//////////  }
////////
////////	
////////	//3. echo client
////////	public static void main(String[] args) {
////////		String hostname = "localhost";
////////		if (args.length > 0) {
////////			hostname = args[0];
////////		}
////////		PrintWriter networkOut = null;
////////		BufferedReader networkIn = null;
////////		Socket theSocket;
////////		BufferedReader userIn;
////////		try {
////////			theSocket = new Socket(hostname, 7);
////////			networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
////////			userIn = new BufferedReader(new InputStreamReader(System.in));
////////			networkOut = new PrintWriter(theSocket.getOutputStream());
////////			System.out.println("Connected to echo server");
////////
////////			while (true) {
////////				String theLine = userIn.readLine();
////////				if (theLine.equals("."))
////////					break;
////////				networkOut.println(theLine);
////////				networkOut.flush();
////////				System.out.println(networkIn.readLine());
////////			}
////////		 // end try
////////			String l = networkIn.readLine();
////////		System.out.println(l);
////////	}catch (IOException ex) {
////////			System.err.println(ex);
////////		} finally {
////////			try {
////////				if (networkIn != null)
////////					networkIn.close();
////////				if (networkOut != null)
////////					networkOut.close();
////////			} catch (IOException ex) {
////////			}
////////		}
////////	} // end main
////////} // end EchoClient
//////
//////import java.io.BufferedReader;
//////import java.io.IOException;
//////import java.io.InputStreamReader;
//////import java.io.PrintWriter;
//////import java.net.Socket;
//////
//////public class DaytimeClient {
//////	public static void main(String[] args) {
//////		String hostname = "localhost";
//////		PrintWriter networkOut = null;
//////		BufferedReader networkIn = null;
//////		try {
//////			Socket server = new Socket(hostname,13);
//////			networkIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
//////			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
//////			networkOut = new PrintWriter(server.getOutputStream());
//////			System.out.println(
//////					"Connected to echo server " + server.getInetAddress() + "의 Port " + server.getPort() + "에 서비스 요청");
//////
//////			while (true) {
//////				System.out.println("서버로 보낼 문장을 입력하시오(.은 종료)");
//////				String theLine = userIn.readLine();
//////				if (theLine.equals("."))
//////					break;
//////				networkOut.println(theLine);
//////				networkOut.flush();
//////				System.out.println(networkIn.readLine());
//////			}
//////			System.out.println(networkIn.readLine());
//////		} // end try
//////		catch (IOException e) {
//////			System.err.println(e);
//////		} finally {
//////			try {
//////				System.out.println("클라이언트가 입출력 스트림을 닫습니다.");
//////				if (networkIn != null)
//////					networkIn.close();
//////				if (networkOut != null)
//////					networkOut.close();
//////			} catch (IOException e) {
//////			}
//////		}
//////	} // end main
//////} // end EchoClient
////
//////1203-udp3
////
//////public class DaytimeClient {
////
//////  private final static int PORT = 13;
//////  private static final String HOSTNAME = "localhost";
//////
//////  public static void main(String[] args) {
//////    try (DatagramSocket socket = new DatagramSocket(0)) {
//////      socket.setSoTimeout(10000); //10초를 기다리면  socket.receive에서 10초동안 기다림!!
//////      InetAddress host = InetAddress.getByName(HOSTNAME);
//////      DatagramPacket request = new DatagramPacket(new byte[1], 1, host , PORT);
//////      DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
//////      socket.send(request);
//////      socket.receive(response);
//////      String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
//////      System.out.println(result);
//////    } catch (IOException ex) {
//////      ex.printStackTrace(); //10초를 못 기다리면 여기로 떨어진다.
//////    }
//////  } 
////
//////UDP cli 
//////public class DaytimeClient {
//////
//////	public final static int PORT = 9;
//////	public final static int MAX_PACKET_SIZE = 65507;
//////
//////	public static void main(String[] args) {
//////
//////		byte[] buffer = new byte[MAX_PACKET_SIZE];
//////
//////		try (DatagramSocket server = new DatagramSocket(PORT)) {
//////			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//////			while (true) {
//////				try {
//////					server.receive(packet);
//////					String s = new String(packet.getData(), 0, packet.getLength(), "8859_1");
//////					System.out.println(packet.getAddress() + " at port " + packet.getPort() + " says " + s);
//////					// reset the length for the next packet
//////					packet.setLength(buffer.length);
//////				} catch (IOException ex) {
//////					System.err.println(ex);
//////				}
//////			} // end while
//////		} catch (SocketException ex) {
//////			System.err.println(ex);
//////		}
//////	}
//////}
////
//////UDP time client 1205
////
//////
//////class UDPPoke {
//////
//////  private int             bufferSize; // in bytes
//////  private DatagramSocket socket;
//////  private DatagramPacket outgoing;
//////   
//////  public UDPPoke(InetAddress host, int port, int bufferSize, 
//////   int timeout) throws SocketException {
//////
//////    outgoing = new DatagramPacket(new byte[1], 1, host, port);
//////    this.bufferSize = bufferSize;
//////    socket = new DatagramSocket(0);
//////    socket.connect(host, port); // requires Java 2
//////    socket.setSoTimeout(timeout);
//////
//////  }
//////  
//////  public UDPPoke(InetAddress host, int port, int bufferSize) throws SocketException {
//////    this(host, port, bufferSize, 30000);
//////  }
//////  
//////  public UDPPoke(InetAddress host, int port) throws SocketException {
//////    this(host, port, 8192, 30000);
//////  }
//////  
//////  public byte[] poke() throws IOException {
//////  
//////    byte[] response = null;
//////    try {
//////      socket .send(outgoing);
//////      DatagramPacket incoming 
//////       = new DatagramPacket(new byte[bufferSize], bufferSize);
//////      // 다음 라인은 응답을 받을 때까지 중단됨
//////      socket .receive(incoming);
//////      int numBytes = incoming.getLength();
//////      response = new byte[numBytes];
//////      System.arraycopy(incoming.getData(), 0, response, 0, numBytes); 
//////    }
//////    catch (InterruptedIOException ex) {
//////             // 
//////    } 
//////
//////    // null이 리턴될 수 있음에 유의
//////    return response;  
//////  }
////// public static void main(String[] args) {
//////
//////    InetAddress host;
//////    int port = 0;
//////
//////    try {
//////      host = InetAddress.getByName(args[0]); 
//////      port = Integer.parseInt(args[1]);
//////      if (port < 1 || port > 65535) throw new Exception();
//////    }
//////    catch (Exception ex) {
//////      System.out.println("Usage: java UDPPoke host port");
//////      return;
//////    }
//////
//////    try {
//////      UDPPoke poker = new UDPPoke(host, port);
//////      byte[] response = poker.poke();
//////      if (response == null) {
//////      System.out.println("No response within allotted time");
//////      return;
//////      }
//////      String result = "";
//////      try {
//////        result = new String(response, "UTF-8");
//////      }
//////      catch (UnsupportedEncodingException e) {
//////      // try a different encoding
//////      result = new String(response, "8859_1");
//////      }
//////      System.out.println(result);
//////    }
//////    catch (Exception ex) {
//////      System.err.println(ex);
//////      ex.printStackTrace();
//////    }
//////
//////  }  // end main
//////
//////}
//////
//////
//////
//////
//////
//////
//////public class DaytimeClient {
//////  
//////  public final static int PORT = 37;
//////  public final static String DEFAULT_HOST = "time.nist.gov";
//////  
//////  public static void main(String[] args) throws IOException {
//////    
//////    InetAddress host;
//////    try {
//////      if (args.length > 0) {
//////        host = InetAddress.getByName(args[0]);
//////      } else {
//////        host = InetAddress.getByName(DEFAULT_HOST);
//////      } 
//////    } catch (RuntimeException | UnknownHostException ex) {
//////      System.out.println("Usage: java UDPTimeClient [host]");
//////      return;
//////    }
//////
//////    //? UDPPoke 어디있음?
//////    UDPPoke poker = new UDPPoke(host, PORT);
//////    byte[] response = poker.poke();
//////    if (response == null) {
//////      System.out.println("No response within allotted time");
//////      return;
//////    } else if (response.length != 4) {
//////      System.out.println("Unrecognized response format");
//////      return;         
//////    }
//////    
//////    // Time 프로토콜은 1900년 기준
//////    // Java의 Date 클래스는 1970년 기준
//////    // 다음 값은 이들 사이의 시간 차   
//////    long differenceBetweenEpochs = 2208988800L;
//////
//////    long secondsSince1900 = 0;
//////    for (int i = 0; i < 4; i++) {
//////      secondsSince1900 
//////          = (secondsSince1900 << 8) | (response[i] & 0x000000FF);
//////    }
//////
//////    long secondsSince1970 
//////        = secondsSince1900 - differenceBetweenEpochs;       
//////    long msSince1970 = secondsSince1970 * 1000;
//////    Date time = new Date(msSince1970);
//////    
//////    System.out.println(time);
//////  } 
//////}
//////
////
////import java.net.InetAddress;
////import java.net.UnknownHostException;
////import java.util.Date;
////
////import java.net.*;
////import java.io.*;
////import java.io.*;
////import java.net.*;
////
////public class DaytimeClient {
////
////  private final static int PORT = 13;
////  private static final String HOSTNAME = "localhost";
////
////  public static void main(String[] args) {
////    try (DatagramSocket socket = new DatagramSocket(0)) {
////      socket.setSoTimeout(10000);
////      InetAddress host = InetAddress.getByName(HOSTNAME);
////      DatagramPacket request = new DatagramPacket(new byte[1], 1, host , PORT);
////      DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
////      socket.send(request);
////      socket.receive(response);
////      String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
////      System.out.println(result);
////    } catch (IOException ex) {
////      ex.printStackTrace();
////    }
////  } 
////}
////
////
//
//
////UDP-client (Poke)
//
////UDP - Poke //////////////////////////for 과제
//
//import java.io.*;
//import java.net.*;
//import java.util.Date;
//
//class UDPPoke {
//
//  private int             bufferSize; // in bytes
//  private DatagramSocket socket;
//  private DatagramPacket outgoing;
//   
//  public UDPPoke(InetAddress host, int port, int bufferSize, 
//   int timeout) throws SocketException {
//
//    outgoing = new DatagramPacket(new byte[1], 1, host, port);
//    this.bufferSize = bufferSize;
//    socket = new DatagramSocket(0);
//    socket.connect(host, port); // requires Java 2
//    socket.setSoTimeout(timeout);
//
//  }
//  
//  public UDPPoke(InetAddress host, int port, int bufferSize) throws SocketException {
//    this(host, port, bufferSize, 30000);
//  }
//  
//  public UDPPoke(InetAddress host, int port) throws SocketException {
//    this(host, port, 8192, 30000);
//  }
//  
//  public byte[] poke() throws IOException {
//  
//    byte[] response = null;
//    try {
//      socket .send(outgoing);
//      DatagramPacket incoming 
//       = new DatagramPacket(new byte[bufferSize], bufferSize);
//      // 다음 라인은 응답을 받을 때까지 중단됨
//      socket.receive(incoming);
//      int numBytes = incoming.getLength();
//      response = new byte[numBytes];
//      System.arraycopy(incoming.getData(), 0, response, 0, numBytes); 
//    }
//    catch (InterruptedIOException ex) {
//             // 
//    } 
//
//    // null이 리턴될 수 있음에 유의
//    return response;  
//  }
//}
//
//
//public class DaytimeClient {
//  
//  public final static int PORT = 13;
//  public final static String DEFAULT_HOST = "localhost";
//  
//  public static void main(String[] args) throws IOException {
//    
//    InetAddress host;
//    try {
//      if (args.length > 0) {
//        host = InetAddress.getByName(args[0]);
//      } else {
//        host = InetAddress.getByName(DEFAULT_HOST);
//      } 
//    } catch (RuntimeException | UnknownHostException ex) {
//      System.out.println("Usage: java UDPTimeClient [host]");
//      return;
//    }
//
//    UDPPoke poker = new UDPPoke(host, PORT);
//    byte[] response = poker.poke();
//    if (response == null) {
//      System.out.println("No response within allotted time");
//      return;
//    } else if (response.length != 4) {
//    	String s = response.toString();
//    	
//      System.out.println("Unrecognized response format");
//      return;         
//    }
//    
//    // Time 프로토콜은 1900년 기준
//    // Java의 Date 클래스는 1970년 기준
//    // 다음 값은 이들 사이의 시간 차   
//    long differenceBetweenEpochs = 2208988800L;
//    long secondsSince1900 = 0;
//    for (int i = 0; i < 4; i++) {
//      secondsSince1900 
//          = (secondsSince1900 << 8) | (response[i] & 0x000000FF);
//    }
//
//    long secondsSince1970 
//        = secondsSince1900 - differenceBetweenEpochs;       
//    long msSince1970 = secondsSince1970 * 1000;
//    Date time = new Date(msSince1970);
//    
//    System.out.println(time);
//  } 
//}
//


//multicast 1210
//import java.io.*;
//import java.net.*; 
//
//public class DaytimeClient { 
//  MulticastSocket receiver = null; 
//  DatagramPacket packet = null;
//  InetAddress multicastGroup = null;
//  int port = 20001; 
//  String address = "237.100.100.1";
//  byte[] b = new byte[100]; 
//
//  public DaytimeClient () {
//     try { 
//        receiver = new MulticastSocket(port); 
//        multicastGroup = InetAddress.getByName(address); 
//        packet = new DatagramPacket(b, b.length); 
//        receiver.joinGroup(multicastGroup); 
//        for (int i=0; i<3; i++) { 
//           receiver.receive(packet); 
//           String notice = new String(packet.getData()); 
//           System.out.println(notice);
//        } 
//        receiver.leaveGroup(multicastGroup); 
//        receiver.close(); 
//     } catch (IOException e) { 
//        e.printStackTrace(); 
//     }  
//  } 
//
//   public static void main(String[] args) throws IOException { 
//     new DaytimeClient();
//   }
//}


//multi sender - 1210

import java.io.*;
import java.net.*;  
import java.util.Date;

public class DaytimeClient {         

   public static void main(String[] args) { 

      InetAddress ia = null;
      int port = 0;
      byte ttl = (byte) 1;
      // command line에서 주소 읽어 들임
      try {
         ia = InetAddress.getByName(args[0]);
         port = Integer.parseInt(args[1]);
         if (args.length > 2) ttl = (byte) Integer.parseInt(args[2]);
      } catch (NumberFormatException | IndexOutOfBoundsException
        | UnknownHostException ex)  {
         System.err.println(ex);
         System.err.println(
                 "Usage: java MulticastSender multicast_address port ttl");
         System.exit(1);
      }


      try (MulticastSocket ms = new MulticastSocket()) {
         ms.setTimeToLive(ttl);
         ms.joinGroup(ia);
         for (int i = 1; i < 10; i++) {
            byte[] data = (i + " " + new Date() + " 멀티캐스트 데이터\r\n").getBytes("UTF-8");
            DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
            ms.send(dp);
         }
         ms.leaveGroup(ia);
      } catch (SocketException ex) {
            System.err.println(ex);
      } catch (IOException ex) {
            System.err.println(ex);
      }  
   }
}   


