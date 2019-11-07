package javaio1105;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

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
//	    testProtocol("http://www.adc.org");  
//	    
//	    // secure http
//	    testProtocol("https://www.amazon.com/exec/obidos/order2/"); 
//	    
//	    // file transfer protocol
//	    testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");
//	  
//	    // Simple Mail Transfer Protocol 
//	    testProtocol("mailto:elharo@ibiblio.org");
//
//	    // telnet 
//	    testProtocol("telnet://dibner.poly.edu/");
//	  
//	    // local file access
//	    testProtocol("file:///etc/passwd");
//
//	    // gopher 
//	    testProtocol("gopher://gopher.anc.org.za/");
//	  
//	    // Lightweight Directory Access Protocol
//	    testProtocol(
//	        "ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");
//
//		
//	    testProtocol(
//	            "jar:http://cafeaulait.org/books/javaio/ioexamples/javaio.jar!"
//	             + "/com/macfaq/io/StreamCopier.class");
//	      
//	        // NFS, Network File System
//	        testProtocol("nfs://utopia.poly.edu/usr/tmp/");
//	      
//	        // a custom protocol for JDBC
//	        testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");
//	      
//	        // rmi, a custom protocol for remote method invocation
//	        testProtocol("rmi://ibiblio.org/RenderEngine");
//	      
//	        // custom protocols for HotJava
//	        testProtocol("doc:/UsersGuide/release.html");
//	        testProtocol("netdoc:/UsersGuide/release.html");
//	        testProtocol("systemresource://www.adc.org/+/index.html");
//	        testProtocol("verbatim:http://www.adc.org/");
//	      }
//	      
//	      private static void testProtocol(String url) {
//	        try {  
//	          URL u = new URL(url);
//	          System.out.println(u.getProtocol() + " is supported");
//	        } catch (MalformedURLException ex) {
//	          String protocol = url.substring(0, url.indexOf(':'));
//	          System.out.println(protocol + " is not supported");
//	        }
//	      } 

//�̾1107
	      
		
//1. ���ڷ� http://www.naver.com �ϸ� 302 ���� ���.
//	    if (args.length > 0) {
//	        InputStream in = null;
//	        try {
//	          // Open the URL for reading
//	          URL u = new URL("file:///C:/Users/ESSEBLE/eclipse-workspace/Day/alphabet.txt"); //url ��ü
//	          in = u.openStream(); //input stream���� ����
//	          //get input stream
//	          // buffer the input to increase performance 
//	          in = new BufferedInputStream(in);  //����ó��
//	          // chain the InputStream to a Reader
//	          Reader r = new InputStreamReader(in); //������ �ٲپ� ����.
//	          int c;
//	          while ((c = r.read()) != -1) {
//	            System.out.print((char) c); // ���
//	          } 
//	        } catch (MalformedURLException ex) {
//	          System.err.println(args[0] + " is not a parseable URL");
//	        } catch (IOException ex) {
//	          System.err.println(ex);
//	        } finally {
//	          if (in != null) {
//	            try {
//	              in.close();
//	            } catch (IOException e) {
//	              // ignore
//	            }
//	          }
//	        }
//	      }
//2.
//		
//	    for (int i = 0; i < args.length; i++) {
//	        try {
//	          URL u = new URL(args[i]);
//	          System.out.println("The URL is " + u);
//	          System.out.println("The scheme is " + u.getProtocol());        
//	          System.out.println("The user info is " + u.getUserInfo());
//	          
//	          String host = u.getHost();
//	          if (host != null) {
//	            int atSign = host.indexOf('@');  
//	            if (atSign != -1) host = host.substring(atSign+1);
//	            System.out.println("The host is " + host);   
//	          } else {          
//	            System.out.println("The host is null.");   
//	          }
//
//	          System.out.println("The port is " + u.getPort());
//	          System.out.println("The path is " + u.getPath());
//	          System.out.println("The ref is " + u.getRef());
//	          System.out.println("The query string is " + u.getQuery());
//	        } catch (MalformedURLException ex) {
//	          System.err.println(args[i] + " is not a URL I understand.");
//	        }
//	        System.out.println();
//	      }
//3. encoding
//
//	    try {
//	      System.out.println(URLEncoder.encode("This string has spaces",  
//	                                              "UTF-16"));
//	      System.out.println(URLEncoder.encode("This*string*has*asterisks",  
//	                                              "UTF-16"));
//	      System.out.println(URLEncoder.encode("This%string%has%percent%signs", 
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This+string+has+pluses",  
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This/string/has/slashes",  
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", 
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This:string:has:colons",  
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This~string~has~tildes",  
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This(string)has(parentheses)",
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This.string.has.periods", 
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This=string=has=equals=signs", 
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("This&string&has&ampersands", 
//	                                              "UTF-8"));
//	      System.out.println(URLEncoder.encode("���", "ms949"));
//	      
//	      String b = "���";
//	      byte[] apple = b.getBytes("utf-16");
//	      for(byte c: apple) {
//	    	  System.out.print(Integer.toHexString(c&0xFF) + "");
//	      }    
//	    } catch (UnsupportedEncodingException ex) {
//	      throw new RuntimeException("Broken VM does not support UTF-8");
//	    }
//		
//		
//		
//		
		
		
//����	
	    String target = "";
	    target = "���";
	    target = target.trim();

	    QueryString query = new QueryString();
	    query.add("q", target);
	    try {
	      URL u = new URL("http://search.daum.net/search?" + query);
	      try (InputStream in = new BufferedInputStream(u.openStream())) {
	        InputStreamReader theHTML = new InputStreamReader(in);
	        int c;
	        while ((c = theHTML.read()) != -1) {
	          System.out.print((char) c);
	        } 
	      }
	    } catch (MalformedURLException ex) {
	      System.err.println(ex);
	    } catch (IOException ex) {
	      System.err.println(ex);
	    }		
		
		
	}
}


//���� - ���ؾȵ�
class QueryString {

  private StringBuilder query = new StringBuilder();
  
  public QueryString() {
  }

  public synchronized void add(String name, String value) { 
    query.append('&');
    encode(name, value);
  }
  
  private synchronized void encode(String name, String value) {
    try { 
      query.append(URLEncoder.encode(name, "UTF-8"));
      query.append('='); 
      query.append(URLEncoder.encode(value, "UTF-8"));
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("Broken VM does not support UTF-8");
    }
  }
  
  public synchronized String getQuery() {
    return query.toString();
  }
  
  @Override
  public String toString() {
    return getQuery();
  }
}