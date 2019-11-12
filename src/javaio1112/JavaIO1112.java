package javaio1112;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class JavaIO1112 {

	// 11 12
//
//	public static void main(String[] args) {
//		Socket sock = null;
//		BufferedReader br = null;
//		try {
//			ServerSocket ss = new ServerSocket(80);
//			sock = ss.accept();
//			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//			String line = null;
//			while ((line = br.readLine()) != null)
//				System.out.println(line);
//		} catch (Exception ex) {
//			System.out.println(ex);
//		} finally {
//			try {
//				if (br != null)
//					br.close();
//			} catch (Exception ex) {
//			}
//			try {
//				if (sock != null)
//					sock.close();
//			} catch (Exception ex) {
//			}
//		} // finally
//	}

//url-connection
	// 1. �ش� �������� html�� �޾ƿ��� �ڵ�
//	public static void main(String[] args) {
//		if (args.length > 0) {
//			try {
//				// Open the URLConnection for reading
//				URL u = new URL(args[0]);
//				URLConnection uc = u.openConnection();
//				InputStream raw = uc.getInputStream();
//				InputStream buffer = new BufferedInputStream(raw);
//				// chain the InputStream to a Reader
//				Reader r = new InputStreamReader(buffer, "utf-8");
//				int c;
//				while ((c = r.read()) != -1) {
//					System.out.print((char) c);
//				}
//			} catch (MalformedURLException ex) {
//				System.err.println(args[0] + " is not a parseable URL");
//			} catch (IOException ex) {
//				System.err.println(ex);
//			}
//		} // end if
//	} // end main

//	// 2. ���� ���� ���ڵ� ���� ����. - �������� �ϴ� ���� �̷��� ����
//	public static void main(String[] args) {
//		for (int i = 0; i < args.length; i++) {
//			try {
//				// set default encoding
//				String encoding = "ISO-8859-1";
//				URL u = new URL(args[i]);
//				URLConnection uc = u.openConnection();
//				String contentType = uc.getContentType();
//				int encodingStart = contentType.indexOf("charset="); // �ε��� ã��.
//				if (encodingStart != -1) {
//					encoding = contentType.substring(encodingStart + 8);
//					System.out.println(encoding);
//				}
//				InputStream in = new BufferedInputStream(uc.getInputStream());
//				Reader r = new InputStreamReader(in, encoding);
//				int c;
//				while ((c = r.read()) != -1) {
//					System.out.print((char) c);
//				}
//				r.close();
//			} catch (MalformedURLException ex) {
//				System.err.println(args[0] + " is not a parseable URL");
//			} catch (UnsupportedEncodingException ex) {
//				System.err.println("Server sent an encoding Java does not support: " + ex.getMessage());
//			} catch (IOException ex) {
//				System.err.println(ex);
//			}
//		}
//	}

	// 3. ������ ������Ʈ ���� ���� ����
	// argv[0] : file:///C:/User/user/mem.png
	// �׸��� �ڹ� ������Ʈ ���� ������ ��
//	public static void main (String args[]) {
//		  
//		      for (int i = 0; i < args.length; i++) {
//		  
//		        try {
//		          URL root = new URL(args[i]);
//		          saveBinaryFile(root);
//		        }
//		        catch (MalformedURLException ex) {
//		          System.err.println(args[i] + " is not URL I understand.");
//		        }
//		        catch (IOException ex) {
//		          System.err.println(ex);
//		        }
//		      } // end for
//		  
//		    } // end main
//
//	public static void saveBinaryFile(URL u) throws IOException {
//		  
//		    URLConnection uc = u.openConnection();
//		    String contentType = uc.getContentType();
//		    int contentLength = uc.getContentLength();
//		    if (contentType.startsWith("text/") || contentLength == -1 ) {
//		      throw new IOException("This is not a binary file.");
//		    }
//		
//		    InputStream raw = uc.getInputStream();
//		    InputStream in  = new BufferedInputStream(raw);
//		    byte[] data = new byte[contentLength];
//		    int bytesRead = 0;
//		    int offset = 0;
//		    while (offset < contentLength) {
//		       bytesRead = in.read(data, offset, data.length - offset);
//		       if (bytesRead == -1) break;
//		       offset += bytesRead;
//		    }
//		    in.close();
//		    
//		    if (offset != contentLength) {
//		      throw new IOException("Only read " + offset 
//		       + " bytes; Expected " + contentLength + " bytes");
//		    }
//		
//		    String filename = u.getFile();
//		    filename = filename.substring(filename.lastIndexOf('/') + 1);
//		    FileOutputStream fout = new FileOutputStream(filename);
//		    fout.write(data);
//		    fout.flush();
//		    fout.close();
//		  
//		  }

	// 4. ����� �м��ϴ� �ڵ� - �װ� �ڵ��� �� �˾ƾ� �Ѵ�.
//	public static void main(String[] args) {
//		for (int i = 0; i < args.length; i++) {
//			try {
//				URL u = new URL(args[0]);
//				URLConnection uc = u.openConnection();
//				System.out.println("Content-type: " + uc.getContentType());
//				if (uc.getContentEncoding() != null) {
//					System.out.println("Content-encoding: " + uc.getContentEncoding());
//				}
//				if (uc.getDate() != 0) {
//					System.out.println("Date: " + new Date(uc.getDate()));
//				}
//				if (uc.getLastModified() != 0) {
//					System.out.println("Last modified: " + new Date(uc.getLastModified()));
//				}
//				if (uc.getExpiration() != 0) {
//					System.out.println("Expiration date: " + new Date(uc.getExpiration()));
//				}
//				if (uc.getContentLength() != -1) {
//					System.out.println("Content-length: " + uc.getContentLength());
//				}
//			} catch (MalformedURLException ex) {
//				System.err.println(args[i] + " is not a URL I understand");
//			} catch (IOException ex) {
//				System.err.println(ex);
//			}
//			System.out.println();
//		}
//	}
//	

//5. �������б� ��� ����� ���
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				URLConnection uc = u.openConnection();
				for (int j = 1;; j++) {
					String header = uc.getHeaderField(j);
					if (header == null)
						break;
					System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
				}
			} catch (MalformedURLException ex) {
				System.err.println(args[i] + " is not a URL I understand.");
			} catch (IOException ex) {
				System.err.println(ex);
			}
			System.out.println();
		}
	}
	
	
//** 67
// �ϱ�����. get, post, ���ò�  #�ͽ��÷��� �ڵ� ¥��
	

}
