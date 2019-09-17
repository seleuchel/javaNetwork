package javaio917;
import java.io.*;
/*
 * io 남은 것 + io 과제
 * 바이트 스트림
 * 을 이용하여 파일에 출력
 */
public class JavaIO917 {
	public static void main(String args[]) throws Exception {
		// 예제1 출력 : 파일 생성하여 FileOUtputStream으로 출력하기
		//한 번에 한 바이트
//		FileOutputStream fos = new FileOutputStream("file01.dat");
//		for (int i = 65; i < 65 + 26; i++) 
//			fos.write(i);
//		// 위 두개를 주석처리하면 파일 내용이 모두 지워져 버림! 
//		fos.close();
//		System.out.println(System.getProperty("user.dir"));
	
		// 예제 2
//		FileOutputStream fos = new FileOutputStream("file02.dat");
//		for(int i=33; i < 126 ; i++) {
//			fos.write(i);
//		}
//		fos.close();
		
		//예제 3
//		FileOutputStream fos = new FileOutputStream("file321.dat");
//			fos.write(321);
//			//A가 써진다
//			//256 + 65 #9번째 비트가 1
//		fos.close();
		
		//예제 4
//		FileOutputStream fos = new FileOutputStream("file02.dat");
//		for (int i = 321; i < 321 + 26; i++) 
//			fos.write(i);
//		fos.close();
		
		//예제 5
//		FileOutputStream fos = new FileOutputStream("file02.dat");
//		for (int i = -191; i < -191 + 26; i++) {
//			fos.write(i);
//			System.out.println("파일에 출력되는 값=" + (-191 & 0xff));
//		}
//		fos.close();
		
		//예제 6 : 통채로 배열을 가져다 집어넣는 방법 
//		byte[] b = new byte[26];
//		for (int i = 0; i < 26; i++) b[i] = (byte)(i+65);
//		
//		FileOutputStream fos = new FileOutputStream("file03.dat");
//		//바이트 배열을 인자로 넣어주면 된다
//		fos.write(b);
//		fos.close();
		
		//예제 7 : 통째로 출력하는 것
//		String s = "자랑스런 전남대학교";
//		byte[] data = s.getBytes();
//		
//		FileOutputStream fos1 = new FileOutputStream("jnu.dat");
//		fos1.write(data);
//		fos1.close();
		
// < 입력 스트림  예제 >
		FileInputStream fis = new FileInputStream ("20200915JavaByteStream.txt");
		int total = 0;
		int j = fis.read();
		while (j != -1) {
			total++;
			j = fis.read();
		}
		System.out.println(total + " bytes");
		
	}
}
