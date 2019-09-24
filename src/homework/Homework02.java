package homework;

import java.util.*;
import java.io.*;
//1. 자신의 컴퓨터의 사진 파일 중 새 사진 하나(예: bird.gif)를 선정한다.
//2. InputStream의 3가지 read문을 이용하여 3개의 새로운 새 사진 파일(예: bird1.gif, bird2.gif, bird3.gif)로 복사하여 이들이 바르게 복사되었는가 사진 뷰어로 확인한다.
//3. BufferedInputStream을 이용하여 새 사진을 복사하고 그 경과 시간을 기록한다. 

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
//				//읽은만큼 가져온다. 세 옵션
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
