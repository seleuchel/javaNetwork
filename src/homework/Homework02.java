package homework;

import java.util.*;
import java.io.*;
//1. �ڽ��� ��ǻ���� ���� ���� �� �� ���� �ϳ�(��: bird.gif)�� �����Ѵ�.
//2. InputStream�� 3���� read���� �̿��Ͽ� 3���� ���ο� �� ���� ����(��: bird1.gif, bird2.gif, bird3.gif)�� �����Ͽ� �̵��� �ٸ��� ����Ǿ��°� ���� ���� Ȯ���Ѵ�.
//3. BufferedInputStream�� �̿��Ͽ� �� ������ �����ϰ� �� ��� �ð��� ����Ѵ�. 

public class Homework02 {

	public static void main(String[] args) throws IOException {

////Code 1 : public int read() throws IOException
//		InputStream is = new FileInputStream("bird.gif");
//		FileOutputStream fis = new FileOutputStream("bird1.gif");
//		
//		int input = 0;
//		input = is.read();
//		while(input != -1) {
//			fis.write(input);
//			input = is.read();
//		}
//		

////Code 2 : public int read (byte[] b) throws IOException
//		InputStream fi = new FileInputStream("bird.gif");
//		FileOutputStream fos = new FileOutputStream("bird2.gif");
//		byte[] buffer = new byte[500];
//		int count = fi.read(buffer);
//		
//		while(count != -1) {
//			fos.write(buffer);
//			count = fi.read(buffer);
//		}
//		fi.close();
//		fos.close();

////Code 3 : public int read (byte[] b, int offset, int length) throws IOException
//			InputStream fi = new FileInputStream("bird.gif");
//			FileOutputStream fos = new FileOutputStream("bird3.gif");
//			
//			byte[] buffer = new byte[500];
//			int count = fi.read(buffer,0,buffer.length);
//			
//			while(count != -1) {
//				fos.write(buffer,0,count);
//				//������ŭ �����´�. �� �ɼ�
//				count = fi.read(buffer, 0, buffer.length);
//			}
//			fi.close();
//			fos.close();

////Code 4 : BufferedInputStream
		long start = new Date().getTime();
		FileInputStream fi = new FileInputStream("bird.gif");
		BufferedInputStream bos = new BufferedInputStream(fi);
		FileOutputStream fos = new FileOutputStream("bird4.gif");

		int count = bos.read();

		while (count != -1) {
			fos.write(count);
			count = bos.read();
		}
		bos.close();
		long end = new Date().getTime();
		System.out.println("Buffered Time : " + (end - start));

	}

}
