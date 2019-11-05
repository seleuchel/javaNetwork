package javaio1105;

import java.net.MalformedURLException;
import java.net.URL;

public class JavaIO1105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//1. �̰��� ������ ���ͳ��� ȣ��Ʈ�� ��Ÿ���� #ip
//		try {
//			InetAddress address = InetAddress.getByName("www.jnu.ac.kr");
//			System.out.println(address);
//		}catch(UnknownHostException es) {
//			System.out.println("no");
//		}
		
//2. �� ����  ���ϴ� getByName #ip �˻��� ������ ���� ��ȯ
//		try {
//			InetAddress address = InetAddress.getByName("168.131.31.206");
//			System.out.println(address.getHostName());
//		}catch(UnknownHostException es) {
//			System.out.println("no");
//		}
		
//3. ��� �� �ľ� ���� #ip
//		try {
//			InetAddress[] addresses = InetAddress.getAllByName("www.naver.com");
//			for (InetAddress address: addresses) {
//				System.out.println(address);
//			}
//		} catch (UnknownHostException e) {
//			System.out.println("Could not find www.oreilly.com");
//		}
		
//4. �� ������-�� �������� ������ �ּҸ� ��ȯ�Ѵ�.
//		try {
//		      InetAddress address = InetAddress.getLocalHost();
//		      System.out.println(address);
//		    } catch (UnknownHostException ex) {
//		      System.out.println("Could not find this computer's address.");
//		    }

//5. 
//		try {
//			InetAddress machine = InetAddress.getByName("169.254.17.51");
//			System.out.println(machine.getHostName());
//		}catch(Exception e) {
//			System.out.println("Could not find this computer's address.");
//		}
//
//6.	    InetAddress ia;
//	try {
//			ia = InetAddress.getByName("webhacking.kr");
//		    System.out.println("toString() --> " + ia);
//		    System.out.println("getHostName() --> " + ia.getHostName());
//		    System.out.println("getCanonicalHostName() --> " + ia.getCanonicalHostName());
//		    for(byte k: ia.getAddress()){ //4����Ʈ�� �迭�� ��� and ó�� �� ��� #�׷��� ���� �ȳ���
//		        System.out.println("getAddress() --> " + (k & 0xff));
//		    }
//		    System.out.println("getHostAddress() --> "+ ia.getHostAddress());

//7.
//			InetAddress ia = InetAddress.getByName("208.201.239.37");
//	    	System.out.println("getCanonicalHostName() --> " + ia.getCanonicalHostName());

//@@? canonical? �ƴ� �Ͱ� ���̴� ? 
//8. ip�� ����Ʈ�� �ٷ� �޾� ó���� �� �ְ� �ؾ��Ѵ�.
//�� ������ 
//			InetAddress is = InetAddress.getLocalHost();
//			byte[] addre = is.getAddress();
//			
//			for (byte i : addre) {
//				System.out.println(i&0xff);//������ ��µǸ� �ȵ�!
//			}
//			
//		
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
//ip�� InetAddress ��ü�� ǥ���Ѵ�!!
//	}		
			
			
// [5. URL]
		//1.
	    // hypertext transfer protocol
	    testProtocol("http://www.adc.org");  
	    
	    // secure http
	    testProtocol("https://www.amazon.com/exec/obidos/order2/"); 
	    
	    // file transfer protocol
	    testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
	  
	    // Simple Mail Transfer Protocol 
	    testProtocol("mailto:elharo@ibiblio.org");

	    // telnet 
	    testProtocol("telnet://dibner.poly.edu/");
	  
	    // local file access
	    testProtocol("file:///etc/passwd");

	    // gopher 
	    testProtocol("gopher://gopher.anc.org.za/");
	  
	    // Lightweight Directory Access Protocol
	    testProtocol(
	        "ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");

		
	    testProtocol(
	            "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
	             + "/com/macfaq/io/StreamCopier.class");
	      
	        // NFS, Network File System
	        testProtocol("nfs://utopia.poly.edu/usr/tmp/");
	      
	        // a custom protocol for JDBC
	        testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
	      
	        // rmi, a custom protocol for remote method invocation
	        testProtocol("rmi://ibiblio.org/RenderEngine");
	      
	        // custom protocols for HotJava
	        testProtocol("doc:/UsersGuide/release.html");
	        testProtocol("netdoc:/UsersGuide/release.html");
	        testProtocol("systemresource://www.adc.org/+/index.html");
	        testProtocol("verbatim:http://www.adc.org/");
	      }
	      
	      private static void testProtocol(String url) {
	        try {  
	          URL u = new URL(url);
	          System.out.println(u.getProtocol() + " is supported");
	        } catch (MalformedURLException ex) {
	          String protocol = url.substring(0, url.indexOf(':'));
	          System.out.println(protocol + " is not supported");
	        }
	      } 

		
		
		
		
	

}
