package javaio919;

import java.io.*;
import java.util.Date;

public class javaio919 { 
	public static void main(String[] args) throws IOException{
//		FileInputStream in = null;
//		try {
//			in = new FileInputStream("c:\\windows\\system.ini"); 
//
//			int c;
//			while ((c = in.read()) != -1) { 
//				System.out.print((char)c); 
//			}
//			in.close(); 
//		} catch (IOException e) {
//				System.out.println("입출력 오류");
//		}
//		
		
//예제 2 : javalogo.gif 바이트 수 확인
//		FileInputStream fi = new FileInputStream("javalogo.gif");
//		int total = 0;
//		int j = fi.read();
//		
//		while(j != -1) {
//			total++;
//			j = fi.read();
//			//값 확인
//			System.out.print((char)j);
//
//		}
//		
//		System.out.println(total + " bytes");
		
		
//예제 3 : javalogo.gif 바로 복사하기	(.gif, .hwp)
//		FileInputStream fi = new FileInputStream("test.hwp");
//		FileOutputStream fos = new FileOutputStream("test_copy.hwp");
//		
//		int total = 0;
//		int j = fi.read();
//		
//		while(j != -1) {
//			total++;
//			fos.write(j);
//			j = fi.read();
//		}
//		System.out.println(total + " bytes");
//		

//예제 4 : 100bytes 씩 읽는 prog
//		FileInputStream fi = new FileInputStream("test.hwp");
//		FileOutputStream fos = new FileOutputStream("test2_copy.hwp");
//		
//		byte[] temp = new byte[500];
//		int total = 0;
//		//가져온 수만큼 출력
//		int count = fi.read(temp);
//		
//		while(count != -1) {
//			total = total + count;
//			fos.write(temp, 0, count);
//			count = fi.read(temp);
//			System.out.println("총 가져온 바이트 수 : " + count);
//			System.out.println("readcnt :" + count);
//		}
//		
//		System.out.println(total + " bytes");
//		
//		fi.close();
//		fos.close();
//				
//		//100개식 56번 + 나머지 1번 + -1 반환 얻기위해서 1번 = 58번 읽기
		
		//예제 4 : 100bytes 씩 읽는 prog		
//		FileInputStream fi = new FileInputStream("test.hwp");
//		FileOutputStream fos = new FileOutputStream("test3_copy.hwp");
//		
//		byte[] buffer = new byte[500];
//		int total = 0;
//		//가져온 수만큼 출력
//		int count = fi.read(buffer,0,buffer.length);
//		
//		while(count != -1) {
//			total = total + count;
//			fos.write(buffer, 0, count);
//			count = fi.read(buffer,0,buffer.length);
//			System.out.println("총 가져온 바이트 수 : " + count);
//			System.out.println("readcnt :" + count);
//		}
//		
//		System.out.println(total + " bytes");
//		
//		fi.close();
//		fos.close();
		
//예제 9. 기타		
//		FileInputStream fi = new FileInputStream("javalogo.gif");
//	
//		int bytesAvailable = in.available();
//		byte[] input = new byte[bytesAvailable];
//		int bytesRead = in.read(input, 0, bytesAvailable);
//		// perform next line immediately
//
//		int count = fi.read(buffer,0,buffer.length);
//		fi.close();
//		System.out.println(" bytes read: " + count);
//		
//		for (int i = 0; i < count ; i++) {
//			int alpha = buffer[i] & 0xff;
//			System.out.print(alpha + " ");
//			if(i % 8 == 7) System.out.print('\n');
//			else System.out.print('\t');
//
//		}
//		
//		System.out.println(fi.available());
		
//지금까지 바이트 스트림 , while input, while ouputstream	

		
		
//		int from = 0;
//		int to = 100000;
//		long start = new Date().getTime();
//		FileOutputStream fos = new FileOutputStream("numbers.dat");
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
//		for(int i = from; i < to; i++) {
//			bos.write(i);
//		}
//		bos.flush();
//		bos.close();
//		int bytes = 0;
//		FileInputStream fis = new FileInputStream("numbers.dat");
//		BufferedInputStream bis = new BufferedInputStream(fis);
//		int input = bis.read();
//		while(input != -1) {
//			bytes++;
//			input = bis.read();
//		}
//		bis.close();
//		System.out.println("Tot =  " + bytes);
//		long end = new Date().getTime();
//		System.out.println("Buffered Elapsed Time = " + (end - start));
		
		
		int from = 0;
		int to = 100000;
		long start = new Date().getTime();
		FileOutputStream fos = new FileOutputStream("numbers.dat");
		for(int i = from; i < to; i++) {
			fos.write(i);
		}
		fos.close();
		int bytes = 0;
		FileInputStream fis = new FileInputStream("numbers.dat");
		int input = fis.read();
		while(input != -1) {
			bytes++;
			input = fis.read();
		}
		System.out.println("Tot = " + bytes);
		fis.close();
		long end = new Date().getTime();
		System.out.println("Elapsed Time = " + (end - start));
		//버퍼 안 쓴게 더 빠른듯

		
	}
}
