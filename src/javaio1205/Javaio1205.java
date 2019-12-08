package javaio1205;

//수신과 송신. 
//받을 때는 버퍼만 있느면 되고,
//보낼 때는 주소와 포트만 있으면 됨.
//명시 안해도 헤더에 있어서 어디서 온 지는 확인할 수 있음.

//UDP discard server
//	public class Javaio1205 {
//
//	  public final static int PORT = 9;
//
//	  public static void main(String[] args) {
//
//	    String hostname = args.length > 0 ?  args[0] : "localhost";
//	    
//	    try (DatagramSocket theSocket = new DatagramSocket()) {
//	      InetAddress server = InetAddress.getByName(hostname);
//	      BufferedReader userInput 
//	          = new BufferedReader(new InputStreamReader(System.in));
//	      while (true) {
//	        String theLine = userInput.readLine();
//	        if (theLine.equals(".")) break;
//	        byte[] data = theLine.getBytes();
//	        DatagramPacket theOutput = new DatagramPacket(data, data.length, server, PORT);
//	        theSocket.send(theOutput);
//	      } // end while
//	    } catch (IOException ex) {
//	      System.err.println(ex);
//	    }
//	  }
//	}

//예제 page 88
//import java.io.*;
//import java.net.*;
//import java.util.logging.*;
//
//public abstract class Javaio1205 implements Runnable {
//
//	private final int bufferSize; // in bytes
//	private final int port;
//	private final Logger logger = Logger.getLogger(Javaio1205.class.getCanonicalName());
//	private volatile boolean isShutDown = false;
//
//	public Javaio1205(int port, int bufferSize) {
//		this.bufferSize = bufferSize;
//		this.port = port;
//	}
//
//	public Javaio1205(int port) {
//		this(port, 8192);
//	}
//
//	@Override
//	public void run() {
//		byte[] buffer = new byte[bufferSize];
//		try (DatagramSocket socket = new DatagramSocket(port)) {
//			socket.setSoTimeout(10000); // check every 10 seconds for shutdown
//			while (true) {
//				if (isShutDown)
//					return;
//				DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
//				try {
//					socket.receive(incoming);
//					this.respond(socket, incoming);
//				} catch (SocketTimeoutException ex) {
//					if (isShutDown)
//						return;
//				} catch (IOException ex) {
//					logger.log(Level.WARNING, ex.getMessage(), ex);
//				}
//			} // end while
//		} catch (SocketException ex) {
//			logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
//		}
//	}
//
//	public abstract void respond(DatagramSocket socket, DatagramPacket request) throws IOException;
//
//	public void shutDown() {
//		this.isShutDown = true;
//	}
//
//}

//UDP server
//import java.io.*;
//import java.net.*;
//import java.util.logging.*;
//
//public abstract class Javaio1205 implements Runnable {
//
//  private final int bufferSize; // in bytes
//  private final int port;
//  private final Logger logger = Logger.getLogger(Javaio1205.class.getCanonicalName());
//  private volatile boolean isShutDown = false;
//   
//  public Javaio1205(int port, int bufferSize) {
//    this.bufferSize = bufferSize;
//    this.port = port;
//  }
//  
//  public Javaio1205(int port) {
//    this(port, 8192);
//  }
//  
//  @Override
//  public void run() {
//    byte[] buffer = new byte[bufferSize];
//    try (DatagramSocket socket = new DatagramSocket(port)) {
//      socket.setSoTimeout(10000); // check every 10 seconds for shutdown
//      while (true) {
//        if (isShutDown) return;
//        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
//        try {
//          socket.receive(incoming);
//          this.respond(socket, incoming);
//        } catch (SocketTimeoutException ex) {
//          if (isShutDown) return;
//        } catch (IOException ex) {
//          logger.log(Level.WARNING, ex.getMessage(), ex);
//        }      
//      } // end while
//    } catch (SocketException ex) {
//      logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
//    }
//  } 
//  
//  public abstract void respond(DatagramSocket socket, DatagramPacket request)
//      throws IOException;
//  
//  public void shutDown() {
//    this.isShutDown = true;
//  }
//
//}

//UDP trash server - advanced
import java.net.DatagramPacket;
import java.net.DatagramSocket;


import java.io.*;
import java.net.*;
import java.util.logging.*;

import java.net.*;
//
//class UDPFastDiscardServer extends UDPServer {
//
//  public final static int DEFAULT_PORT = 9;
//  
//  public UDPFastDiscardServer() {
//    super(DEFAULT_PORT);
//  }
//  
//  public static void main(String[] args) {
//    UDPServer server = new UDPFastDiscardServer();
//    Thread t = new Thread(server);
//    t.start();
//  }
//
//  public void respond(DatagramSocket socket, DatagramPacket request) {
//  }
//}
//
//
//abstract class UDPServer implements Runnable {
//
//  private final int bufferSize; // in bytes
//  private final int port;
//  private final Logger logger = Logger.getLogger(UDPServer.class.getCanonicalName());
//  private volatile boolean isShutDown = false;
//   
//  public UDPServer(int port, int bufferSize) {
//    this.bufferSize = bufferSize;
//    this.port = port;
//  }
//  
//  public UDPServer(int port) {
//    this(port, 8192);
//  }
//  
//  @Override
//  public void run() {
//    byte[] buffer = new byte[bufferSize];
//    try (DatagramSocket socket = new DatagramSocket(port)) {
//      socket.setSoTimeout(10000); // check every 10 seconds for shutdown
//      while (true) {
//        if (isShutDown) return;
//        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
//        try {
//          socket.receive(incoming);
//          this.respond(socket, incoming);
//        } catch (SocketTimeoutException ex) {
//          if (isShutDown) return;
//        } catch (IOException ex) {
//          logger.log(Level.WARNING, ex.getMessage(), ex);
//        }      
//      } // end while
//    } catch (SocketException ex) {
//      logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
//    }
//  } 
//  
//  public abstract void respond(DatagramSocket socket, DatagramPacket request)
//      throws IOException;
//  
//  public void shutDown() {
//    this.isShutDown = true;
//  }
//
//}
//
//
//
//public class Javaio1205 extends UDPServer {
//
//  public final static int DEFAULT_PORT = 9;
//  
//  public Javaio1205() {
//    super(DEFAULT_PORT);
//  }
//  
//  public static void main(String[] args) {
//    UDPServer server = new UDPFastDiscardServer();
//    Thread t = new Thread(server);
//    t.start();
//  }
//
//  public void respond(DatagramSocket socket, DatagramPacket request) {
//  }
//}
//
//
////과제
////client : udp poke
////server : udp server
//
////하나는 상속, 하나는 참조변수로 해서 (composision) 을 이용하여
////요것의 time 만들기
////time protocol
////UDP SERVER 만 잘 신경쓰면 좋을 듯.



//UDP DAY TIME SERVER  ECHO SERVER


//(참고) 확인 10%의 응답을 고의로 폐기하는 UPD ECHO 서버