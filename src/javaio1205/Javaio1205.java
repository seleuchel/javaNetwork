package javaio1205;
//
//
//import java.net.*;
//import java.util.Date;
//import java.util.logging.*;
//import java.io.*;
//
//public class Javaio1205 {
//
//  private final static int PORT = 13;
//  private final static Logger audit = Logger.getLogger("requests");
//  private final static Logger errors = Logger.getLogger("errors");
//
//  public static void main(String[] args) {
//    try (DatagramSocket socket = new DatagramSocket(PORT)) {
//      while (true) {
//        try {
//          DatagramPacket request = new DatagramPacket(new byte[1024], 0, 1024);
//          socket.receive(request);
//          
//          String daytime = new Date().toString();
//          byte[] data = daytime.getBytes("US-ASCII");
//          DatagramPacket response = new DatagramPacket(data, data.length, 
//              request.getAddress(), request.getPort());
//          socket.send(response);
//          audit.info(daytime + " " + request.getAddress());
//        } catch (IOException | RuntimeException ex) {
//          errors.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//      }
//    } catch (IOException ex) {
//      errors.log(Level.SEVERE, ex.getMessage(), ex);
//    }
//  } 
//}
//
//
////���Ű� �۽�. 
////���� ���� ���۸� �ִ��� �ǰ�,
////���� ���� �ּҿ� ��Ʈ�� ������ ��.
////��� ���ص� ����� �־ ��� �� ���� Ȯ���� �� ����.
//
////UDP discard server
////	public class Javaio1205 {
////
////	  public final static int PORT = 9;
////
////	  public static void main(String[] args) {
////
////	    String hostname = args.length > 0 ?  args[0] : "localhost";
////	    
////	    try (DatagramSocket theSocket = new DatagramSocket()) {
////	      InetAddress server = InetAddress.getByName(hostname);
////	      BufferedReader userInput 
////	          = new BufferedReader(new InputStreamReader(System.in));
////	      while (true) {
////	        String theLine = userInput.readLine();
////	        if (theLine.equals(".")) break;
////	        byte[] data = theLine.getBytes();
////	        DatagramPacket theOutput = new DatagramPacket(data, data.length, server, PORT);
////	        theSocket.send(theOutput);
////	      } // end while
////	    } catch (IOException ex) {
////	      System.err.println(ex);
////	    }
////	  }
////	}
//
////���� page 88
////import java.io.*;
////import java.net.*;
////import java.util.logging.*;
////
////public abstract class Javaio1205 implements Runnable {
////
////	private final int bufferSize; // in bytes
////	private final int port;
////	private final Logger logger = Logger.getLogger(Javaio1205.class.getCanonicalName());
////	private volatile boolean isShutDown = false;
////
////	public Javaio1205(int port, int bufferSize) {
////		this.bufferSize = bufferSize;
////		this.port = port;
////	}
////
////	public Javaio1205(int port) {
////		this(port, 8192);
////	}
////
////	@Override
////	public void run() {
////		byte[] buffer = new byte[bufferSize];
////		try (DatagramSocket socket = new DatagramSocket(port)) {
////			socket.setSoTimeout(10000); // check every 10 seconds for shutdown
////			while (true) {
////				if (isShutDown)
////					return;
////				DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
////				try {
////					socket.receive(incoming);
////					this.respond(socket, incoming);
////				} catch (SocketTimeoutException ex) {
////					if (isShutDown)
////						return;
////				} catch (IOException ex) {
////					logger.log(Level.WARNING, ex.getMessage(), ex);
////				}
////			} // end while
////		} catch (SocketException ex) {
////			logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
////		}
////	}
////
////	public abstract void respond(DatagramSocket socket, DatagramPacket request) throws IOException;
////
////	public void shutDown() {
////		this.isShutDown = true;
////	}
////
////}
//
////UDP server
////import java.io.*;
////import java.net.*;
////import java.util.logging.*;
////
////public abstract class Javaio1205 implements Runnable {
////
////  private final int bufferSize; // in bytes
////  private final int port;
////  private final Logger logger = Logger.getLogger(Javaio1205.class.getCanonicalName());
////  private volatile boolean isShutDown = false;
////   
////  public Javaio1205(int port, int bufferSize) {
////    this.bufferSize = bufferSize;
////    this.port = port;
////  }
////  
////  public Javaio1205(int port) {
////    this(port, 8192);
////  }
////  
////  @Override
////  public void run() {
////    byte[] buffer = new byte[bufferSize];
////    try (DatagramSocket socket = new DatagramSocket(port)) {
////      socket.setSoTimeout(10000); // check every 10 seconds for shutdown
////      while (true) {
////        if (isShutDown) return;
////        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
////        try {
////          socket.receive(incoming);
////          this.respond(socket, incoming);
////        } catch (SocketTimeoutException ex) {
////          if (isShutDown) return;
////        } catch (IOException ex) {
////          logger.log(Level.WARNING, ex.getMessage(), ex);
////        }      
////      } // end while
////    } catch (SocketException ex) {
////      logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
////    }
////  } 
////  
////  public abstract void respond(DatagramSocket socket, DatagramPacket request)
////      throws IOException;
////  
////  public void shutDown() {
////    this.isShutDown = true;
////  }
////
////}
//
////UDP trash server - advanced
////import java.net.DatagramPacket;
////import java.net.DatagramSocket;
////
////
////import java.io.*;
////import java.net.*;
////import java.util.logging.*;
////
////import java.net.*;
////
////class UDPFastDiscardServer extends UDPServer {
////
////  public final static int DEFAULT_PORT = 9;
////  
////  public UDPFastDiscardServer() {
////    super(DEFAULT_PORT);
////  }
////  
////  public static void main(String[] args) {
////    UDPServer server = new UDPFastDiscardServer();
////    Thread t = new Thread(server);
////    t.start();
////  }
////
////  public void respond(DatagramSocket socket, DatagramPacket request) {
////  }
////}
////
////
////abstract class UDPServer implements Runnable {
////
////  private final int bufferSize; // in bytes
////  private final int port;
////  private final Logger logger = Logger.getLogger(UDPServer.class.getCanonicalName());
////  private volatile boolean isShutDown = false;
////   
////  public UDPServer(int port, int bufferSize) {
////    this.bufferSize = bufferSize;
////    this.port = port;
////  }
////  
////  public UDPServer(int port) {
////    this(port, 8192);
////  }
////  
////  @Override
////  public void run() {
////    byte[] buffer = new byte[bufferSize];
////    try (DatagramSocket socket = new DatagramSocket(port)) {
////      socket.setSoTimeout(10000); // check every 10 seconds for shutdown
////      while (true) {
////        if (isShutDown) return;
////        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
////        try {
////          socket.receive(incoming);
////          this.respond(socket, incoming);
////        } catch (SocketTimeoutException ex) {
////          if (isShutDown) return;
////        } catch (IOException ex) {
////          logger.log(Level.WARNING, ex.getMessage(), ex);
////        }      
////      } // end while
////    } catch (SocketException ex) {
////      logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
////    }
////  } 
////  
////  public abstract void respond(DatagramSocket socket, DatagramPacket request)
////      throws IOException;
////  
////  public void shutDown() {
////    this.isShutDown = true;
////  }
////
////}
////
////
////
////public class Javaio1205 extends UDPServer {
////
////  public final static int DEFAULT_PORT = 9;
////  
////  public Javaio1205() {
////    super(DEFAULT_PORT);
////  }
////  
////  public static void main(String[] args) {
////    UDPServer server = new UDPFastDiscardServer();
////    Thread t = new Thread(server);
////    t.start();
////  }
////
////  public void respond(DatagramSocket socket, DatagramPacket request) {
////  }
////}
////
////
//////����
//////client : udp poke
//////server : udp server
////
//////�ϳ��� ���, �ϳ��� ���������� �ؼ� (composision) �� �̿��Ͽ�
//////����� time �����
//////time protocol
//////UDP SERVER �� �� �Ű澲�� ���� ��.
//
//
//
////UDP DAY TIME SERVER  ECHO SERVER
//
//
////(����) Ȯ�� 10%�� ������ ���Ƿ� ����ϴ� UPD ECHO ����



//UDP - server for poke time ////////////////for ����
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.logging.*;

 abstract class UDPServer implements Runnable {

  private final int bufferSize; // in bytes
  private final int port;
  private final Logger logger = Logger.getLogger(UDPServer.class.getCanonicalName());
  private volatile boolean isShutDown = false;
   
  public UDPServer(int port, int bufferSize) {
    this.bufferSize = bufferSize;
    this.port = port;
  }
  
  public UDPServer(int port) {
    this(port, 8192);
  }
  
  @Override
  public void run() {
    byte[] buffer = new byte[bufferSize];
    try (DatagramSocket socket = new DatagramSocket(port)) {
      socket.setSoTimeout(10000); // check every 10 seconds for shutdown
      while (true) {
        if (isShutDown) return;
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        try {
          socket.receive(incoming);
          this.respond(socket, incoming);
        } catch (SocketTimeoutException ex) {
          if (isShutDown) return;
        } catch (IOException ex) {
          logger.log(Level.WARNING, ex.getMessage(), ex);
        }      
      } // end while
    } catch (SocketException ex) {
      logger.log(Level.SEVERE, "Could not bind to port: " + port, ex);
    }
  } 
  
  public abstract void respond(DatagramSocket socket, DatagramPacket request)
      throws IOException;
  
  public void shutDown() {
    this.isShutDown = true;
  }

}

 public class Javaio1205 extends UDPServer {

   public final static int DEFAULT_PORT = 13;

   public Javaio1205() throws SocketException {
     super(DEFAULT_PORT); 
   }

   public void respond(DatagramSocket ds, DatagramPacket packet) {

     try {
       Date now = new Date();
///
       long differenceBetweenEpochs = 2208988800L;

       long msSince1970 = now.getTime();
       long secondsSince1970 = msSince1970/1000;
       long secondsSince1900 = secondsSince1970 
           + differenceBetweenEpochs;
       byte[] time = new byte[4];
       time[0] 
           = (byte) ((secondsSince1900 & 0x00000000FF000000L) >> 24);
       time[1] 
           = (byte) ((secondsSince1900 & 0x0000000000FF0000L) >> 16);
       time[2] 
           = (byte) ((secondsSince1900 & 0x000000000000FF00L) >> 8);
       time[3] = (byte) (secondsSince1900 & 0x00000000000000FFL);
///

       byte[] data = time;
       DatagramPacket outgoing = new DatagramPacket(data, 
        data.length, packet.getAddress(), packet.getPort());
       ds.send(outgoing);
     }
     catch (IOException e) {
       System.err.println(e);
     }
     
   }

   public static void main(String[] args) {
  
    try {
      Javaio1205 server = new Javaio1205();
      new Thread(server).start();
    }
    catch (SocketException e) {
      System.err.println(e);
    }
  
   }

 }
