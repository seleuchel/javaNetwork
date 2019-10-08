package javaio1001;

import java.io.*;

public class Javaio1001 {
	public static void main(String args[]) throws Exception{
		
//1. 예제 1번 - InputStreamReader로 한글읽기 (2바이트씩 읽어서 처리를 한다.)
//		InputStreamReader ir = new InputStreamReader(new FileInputStream("hanguel.dat"));
//		
//		int num = 0;
//		int i = ir.read();
//		while( i != -1) {
//			System.out.print(i);
//			i = ir.read();
//			num++;
//		}
//		System.out.println();
//		System.out.println(num);
//		//*print로 하면 30000으로 출력(각각 문자열)
//		//한글은 2바이트 씩 이므로 property에서는 -> 8바이트로 나옴
////bufferedreader + inputstream 하면 속도 증가 가능.
	
//	FileReader fi = new FileReader(new File("hanguel.dat"));
//	//!! 인코딩을 줄 수 없음
//	
//	int i = fi.read();
//	
//	while (i != -1) {
//		System.out.print((char)i);
//		i = fi.read();
//	}
		
		
//3. 한글문자 처리 - outputstream
//		byte[] data = "대한민국".getBytes("MS949");
//		OutputStream j = new FileOutputStream("hangeul.dat");
//		
//		for(int m = 0; m < data.length; m++) {
//			int ic = data[m] & 0xff;
//			j.write(ic);
//		}
//		//전체를 가져다 쓸 수도 있다.
//		//j.write(data);
//		j.close();
//		
//		//읽어들일때는 반드시 리더를 이용!!!
		
//4. 한글로부터 데이터 출력.
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("hangeul.dat"));
//		int input = isr.read();
//		while(input != -1) {	
//			// 읽힌 input을 이 부분에서 적절히 사용함
//			System.out.print((char)input);
//			input = isr.read();
//		}
//		
//		isr.close();
		
//5. 바이트 배열에 저장해서 필요할 때 문자열로 변환하여 사용할 수도 있다. (원시 상태로 읽어서 string으로 바꾸어 읽는다)
//모든 2바이트 문자를 처리하는 방법!!
//		byte [] buf = new byte[1024];
//		InputStream is = new FileInputStream("hangeul.dat");
//		int len = is.read(buf, 0, buf.length);
//		
//		String ms = new String(buf, 0, len, "MS949");
//		System.out.println(ms);
//
//		
		
		
//< byte >
		
//		byte[] fromArray = {61,62,63,64,65};
//		// 이 위치에 fromArray를 채우는 다른 코드도 가능함
//		System.out.println("배열 내의 byte 수  " + fromArray.length);
//		// byte 배열로부터 읽어 들일 ByteArrayInputStrem을 생성
//		ByteArrayInputStream bais = new ByteArrayInputStream(fromArray);
//		
//		byte[] carrier = new byte[512]; // 1회에 512 바이트씩 끊어 읽음
//		int count = bais.read(carrier); //읽어들인 글자 수?
//		while(count != -1){
//			System.out.write(carrier, 0, count); //콘솔이 문자로 바꾸어 보여줌(write [바이너리 값 자체를 출력])
//			count = bais.read(carrier);
//		}
//		System.out.println("byte 배열을 모니터에 모두 출력했음");

//		
//		
//		InputStream in = new DataInputStream(new FileInputStream("a.txt"));
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		int b =in.read();
//		while(b != -1) {
//			out.write(b); // 읽어 들인 데이터를 바이트 배열에 출력 #씀
//			b =in.read();
//		}
//		byte[] data = out.toByteArray();// 바이트 배열을 얻는다 !!

		
		//!! 굉장히 헷갈리고 어렵다! 잘 분류해두자
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(bos);
		String s = "자바stream";
		osw.write(s); 
		osw.flush();
		byte[] ba = bos.toByteArray();
		
		// 바이트 배열의 전체 내용을 한 바이트씩 출력해 본다
		for(int m=0;m<ba.length;m++){
			int ich = ba[m] & 0xff;
			System.out.print(Integer.toHexString(ich) + " ");
		}
		// 바이트 배열을 문자열로 변환하여 출력해 본다
		String reconstructed = new String(ba, 0, ba.length);
		System.out.println('\n' + reconstructed);
		
	}
}
