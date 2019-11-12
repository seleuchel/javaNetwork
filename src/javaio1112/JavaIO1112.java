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
	// 1. 해당 페이지의 html을 받아오는 코드
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

//	// 2. 서버 상의 인코딩 따라서 읽음. - 브라우저가 하는 일을 이렇게 읽음
//	public static void main(String[] args) {
//		for (int i = 0; i < args.length; i++) {
//			try {
//				// set default encoding
//				String encoding = "ISO-8859-1";
//				URL u = new URL(args[i]);
//				URLConnection uc = u.openConnection();
//				String contentType = uc.getContentType();
//				int encodingStart = contentType.indexOf("charset="); // 인덱스 찾음.
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

	// 3. 파일이 프로젝트 폴더 내에 저장
	// argv[0] : file:///C:/User/user/mem.png
	// 그림이 자바 프로젝트 내에 저장이 됨
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

	// 4. 헤더를 분석하는 코드 - 네가 코딩할 줄 알아야 한다.
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

//5. 전남대학교 모든 헤더를 출력
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
// 암기하자. get, post, 오늘꺼  #익스플로잇 코드 짜기
	

}
