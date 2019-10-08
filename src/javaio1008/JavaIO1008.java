package javaio1008;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaIO1008 {

	public static void main(String[] args) throws Exception{
		//������ stream�� ������ �ð�. 
		//����, ��ȣȭ�� �Ѵ�.
		
////����1
//		ZipFile zf = new ZipFile("my.zip");
//		Enumeration e = zf.entries();
//		while(e.hasMoreElements()) {
//		       ZipEntry ze = (ZipEntry)e.nextElement();//�Ѱ��Ѱ�����
//		       System.out.println("Unzipping: " + ze.getName());//�׼����̸�(�Ѱ�������)
//		       FileOutputStream fos = new FileOutputStream(ze.getName());
//		       InputStream is = zf.getInputStream(ze);
//		       for(int c = is.read(); c != -1; c = is.read()) {
//		                   fos.write(c);
//		       }
//		       is.close();
//		       fos.close();
//		}
		

//����2 : ������ ����� �ڵ�
//���ڸ� �ָ� �����Ѵ�.
//	    if (args.length < 2) {
//	        System.out.println("Usage: java Zipper [-d level] name.zip"+
//	                           " file1 file2...");
//	        return; 
//	      }
//	      
//	      String outputFile = args[0];
//	      // Default to maximum compression
//	      int level = 9;
//	      int start = 1;
//	      if (args[0].equals("-d")) {
//	        try {
//	          level = Integer.parseInt(args[1]);
//	          outputFile = args[2];
//	          start = 3;
//	        }
//	        catch (Exception ex) {
//	          System.out.println("Usage: java Zipper [-d level] name.zip"
//	                          + " file1 file2...");
//	          return;         
//	        }
//	      }    
//	      
//	      FileOutputStream fout = new FileOutputStream(outputFile);
//	      ZipOutputStream zout = new ZipOutputStream(fout);
//	      zout.setLevel(level);
//	      for (int i = start; i < args.length; i++) {
//	        ZipEntry ze = new ZipEntry(args[i]);
//	        FileInputStream fin = new FileInputStream(args[i]);
//	        try {
//	          System.out.println("Compressing " + args[i]);
//	          zout.putNextEntry(ze);
//	          for (int c = fin.read(); c != -1; c = fin.read()) {
//	            zout.write(c);
//	          }
//	        }
//	        finally {
//	          fin.close();
//	        }
//	      }
//	      zout.close();
//		
		
		//######�� ���۷� ������ ����� ���� �����̴�!!!
		

//���� 4 : unzip
//	    for (int i = 0; i < args.length; i++) {
//	        FileInputStream fin = new FileInputStream(args[i]);
//	        ZipInputStream zin = new ZipInputStream(fin);
//	        ZipEntry ze = null;
//	        while ((ze = zin.getNextEntry()) != null) {
//	          System.out.println("Unzipping " + ze.getName());
//	          FileOutputStream fout = new FileOutputStream(ze.getName());
//	          for (int c = zin.read(); c != -1; c = zin.read()) {
//	            fout.write(c);
//	          }
//	          zin.closeEntry();
//	          fout.close();
//	        }
//	        zin.close();     
//	      }
// streaming �� ������ zipping, unzipping
		

//		URL u = new URL("http://www.jnu.ac.kr");
//		InputStream in = u.openStream();
//		MessageDigest sha = MessageDigest.getInstance("SHA");
//		byte[] data = new byte[1024];
//		while (true) {
//			int bytesRead = in.read(data);
//			if (bytesRead < 0) break;
//			sha.update(data, 0, bytesRead);
//		}
//		byte[] result = sha.digest();
//		for (int i = 0; i < result.length; i++) {
//			System.out.print(result[i] + " ");
//		}

//���� 5
		if (args.length != 2) {
		      System.err.println("Usage: java FileDigest url filename");
		      return;
		    }

		    URL u = new URL(args[0]);
		    FileOutputStream out = new FileOutputStream(args[1]);
		    copyFileWithDigest(u.openStream(), out);
		    out.close();
		  }

		  public static void copyFileWithDigest(InputStream in, OutputStream out)  throws IOException, NoSuchAlgorithmException {
		    
		     MessageDigest sha = MessageDigest.getInstance("SHA-512");
		     DigestOutputStream dout = new DigestOutputStream(out, sha);
		     byte[] data = new byte[128];
		     while (true) {
		       int bytesRead = in.read(data);
		       if (bytesRead < 0) break;
		       dout.write(data, 0, bytesRead);
		     }
		     dout.flush();
		     byte[] result = dout.getMessageDigest().digest();
		     for (int i = 0; i < result.length; i++) {
		       System.out.print(result[i] + " ");
		     }
		     System.out.println();

		
		
		//�����ð� ���ʹ� ������.... 
		
		
		
		
		
		
		
		
		
		

	}

}
