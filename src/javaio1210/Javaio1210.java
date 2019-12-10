package javaio1210;

import java.io.*; 
import java.net.*; 


//multicast - server 
//public class Javaio1210 extends Thread { 
//  DatagramSocket socket = null; 
//  DatagramPacket packet = null;
//  InetAddress multicastGroup = null;
//  int port = 20001; 
//  String address = "237.100.100.1";
//  boolean onAir = true; 
//
//  public Javaio1210() throws IOException { 
//    super("멀티캐스트 방송국"); 
//    socket = new DatagramSocket(); 
//  } 
//
//  public void run() { 
//    byte[] b = new byte[100]; 
//    while (onAir) { 
//      try { 
//        b = "이 자료는 멀티캐스트 방송국에서 보내고 있습니다".getBytes(); // 메시지를 바이트 배열로 변환
//        multicastGroup = InetAddress.getByName(address); 
//        packet = new DatagramPacket(b, b.length, multicastGroup, port); 
//        socket.send(packet);
//        try { 
//          sleep(500);
//          System.out.println("방송 중입니다.");
//        } catch (InterruptedException e) { } 
//      } catch (IOException e) { 
//          e.printStackTrace(); 
//      }  
//    } // end while 
//    socket.close(); 
//  } 
//
//  public static void main(String[] args) throws java.io.IOException { 
//    new Javaio1210().start(); 
//  } 
//}

//sniffer
import java.io.*;
import java.net.*;

public class Javaio1210 {

  public static void main(String[] args) {
  
    InetAddress group = null;
    int port = 0;
  
    // read the address from the command line
    try {
      group = InetAddress.getByName(args[0]);
      port = Integer.parseInt(args[1]);
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException
        | UnknownHostException ex) {
      System.err.println(
          "Usage: java MulticastSniffer multicast_address port");
      System.exit(1);
    }
  
    MulticastSocket ms = null;
    try {
      ms = new MulticastSocket(port);
      ms.joinGroup(group);
      
      
      while (true) {
    byte[] buffer = new byte[8192];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ms.receive(dp);
        String s = new String(dp.getData(), "UTF-8");
        System.out.println(s);
      }
    } catch (IOException ex) {
      System.err.println(ex);
    } finally {
      if (ms != null) {
        try {
          ms.leaveGroup(group);
          ms.close();
        } catch (IOException ex) {} 
      }
    } 
  }
}

//multicast 1210
//import java.io.*;
//import java.net.*; 
//
//public class DaytimeClient { 
//MulticastSocket receiver = null; 
//DatagramPacket packet = null;
//InetAddress multicastGroup = null;
//int port = 20001; 
//String address = "237.100.100.1";
//byte[] b = new byte[100]; 
//
//public DaytimeClient () {
//   try { 
//      receiver = new MulticastSocket(port); 
//      multicastGroup = InetAddress.getByName(address); 
//      packet = new DatagramPacket(b, b.length); 
//      receiver.joinGroup(multicastGroup); 
//      for (int i=0; i<3; i++) { 
//         receiver.receive(packet); 
//         String notice = new String(packet.getData()); 
//         System.out.println(notice);
//      } 
//      receiver.leaveGroup(multicastGroup); 
//      receiver.close(); 
//   } catch (IOException e) { 
//      e.printStackTrace(); 
//   }  
//} 
//
// public static void main(String[] args) throws IOException { 
//   new DaytimeClient();
// }
//}


//multi sender - 1210
//
//import java.io.*;
//import java.net.*;  
//import java.util.Date;
//
//public class DaytimeClient {         
//
// public static void main(String[] args) { 
//
//    InetAddress ia = null;
//    int port = 0;
//    byte ttl = (byte) 1;
//    // command line에서 주소 읽어 들임
//    try {
//       ia = InetAddress.getByName(args[0]);
//       port = Integer.parseInt(args[1]);
//       if (args.length > 2) ttl = (byte) Integer.parseInt(args[2]);
//    } catch (NumberFormatException | IndexOutOfBoundsException
//      | UnknownHostException ex)  {
//       System.err.println(ex);
//       System.err.println(
//               "Usage: java MulticastSender multicast_address port ttl");
//       System.exit(1);
//    }
//
//
//    try (MulticastSocket ms = new MulticastSocket()) {
//       ms.setTimeToLive(ttl);
//       ms.joinGroup(ia);
//       for (int i = 1; i < 10; i++) {
//          byte[] data = (i + " " + new Date() + " 멀티캐스트 데이터\r\n").getBytes("UTF-8");
//          DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
//          ms.send(dp);
//       }
//       ms.leaveGroup(ia);
//    } catch (SocketException ex) {
//          System.err.println(ex);
//    } catch (IOException ex) {
//          System.err.println(ex);
//    }  
// }
//}   
//
//
