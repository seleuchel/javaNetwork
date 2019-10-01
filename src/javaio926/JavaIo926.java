package javaio926;

import java.io.*;

public class JavaIo926 {

	public static void main(String[] args) throws Exception{
		//1. 표준 입출력 스트림 -> 한 바이트씩 (아스키라던가..아스키라던가..)
//		int count = 0;
//		int b = System.in.read();
//		while (b != -1) {
//			count++;
//			System.out.println(b + " " + (char) b);
//			b = System.in.read();
//
//		}
//		System.out.println("Number of Charactoer : " + count);
		
		//2. 문자 스트림  : 한글 유니코드를 소화한다 #강낭콩
//	    int c;
//	    int count = 0;
//	    InputStreamReader link = new InputStreamReader(System.in); 
//	    BufferedReader br  = new BufferedReader( link);
//	    while (  (c = br.read())  != -1) {
//	        count++;
//	        System.out.println(c + "  "+(char)c);
//	    }
//	    System.out.println("Number of Characters: "+count);

	    //3. 한 줄씩 출력 - 한글
//	    InputStreamReader link = new  InputStreamReader(System.in);
//     	BufferedReader br = new BufferedReader( link);
//     	System.out.println("Enter lines of text.  End with CTRL-Z");
//     	//readLine을 사용하려면 BufferedReader에 연결.
//     	//System.in - InputStreamReader - BufferedREader 
//     	//System.in을 바로 BufferedReader에 끼울 수 없다.
//     	String str = br.readLine();
//     	while ( str != null){
//		System.out.println(str);
//		str = br.readLine();
//	}

	// < 문자 >
	//1. Writer : 한글 문자열 화면에 출력. 
//		Writer w = new OutputStreamWriter(System.out);
//		char[] nation = {'K', 'O', 'R', 'E', 'A', '한', '국' };
//		for (int i = 0; i < nation.length; i++) w.write(nation[i]); // write(int)
//		w.write(nation); 			// write(char[])
//		w.write(nation, 0, nation.length); 	// write(char[], int, int)
//		w.write("KOREA한국"); 		// write(String)
//		w.write("KOREA한국", 0, 7); 		// write(String, int, int)
//		w.flush(); // flush()를 호출하지 않으면 출력 결과 안 보인다

	//2. Writer : 한글 문자열 파일에 쓰기
//		Writer w = new OutputStreamWriter(
//				//System.out
//				new FileOutputStream("output1.txt")
//				);
//		char[] nation = {'K', 'O', 'R', 'E', 'A', '한', '국' };
//		for (int i = 0; i < nation.length; i++) w.write(nation[i]); // write(int)
//		w.write(nation); 			// write(char[])
//		w.write(nation, 0, nation.length); 	// write(char[], int, int)
//		w.write("KOREA한국"); 		// write(String)
//		w.write("KOREA한국", 0, 7); 		// write(String, int, int)
//		w.flush(); // flush()를 호출하지 않으면 출력 결과 안 보인다. 파일에 출력도 안됨.
	
		//3. Writer
		//출력 : 오징어 - 갈치 - 문어box
		//줄바꿈 처리를 하지 않았으므로 문자열이 다 이어진다.
//		OutputStreamWriter osw = new OutputStreamWriter(
//				new FileOutputStream("hanguel.dat"),
//				"MS949" //encoding-value (한글 default : MS949 )
//				);
//		
//		//인코딩 값 출력
//		System.out.println(osw.getEncoding());
//		//파일에 쓰기
//		osw.write("오징어 - 갈치 - 문어");
//		osw.write("집에가고싶어라");
//		osw.flush();
		
		//4. 파일에 문자 출력
		//FileWriter = FileOuputStream + OutputStreamWriter
		//	이거 사용하면 버퍼링 안함. 꼭! 2바이트씩 연결해서 처리.
//		FileWriter fw = new FileWriter("mytxt.txt");
//		
//		char ch = 'a';
//		fw.write(ch);;
//		fw.flush(); // 니가 writer라면 필수로!
//		fw.close();
		
		//5. bufferedwriter - filewriter
		//쓸 때마다 2바이트씩 쓴다.
		//기존은 한 바이트씩 쓴다.
//		FileWriter fw = new FileWriter ("alphabet.txt");
//		BufferedWriter bw = new BufferedWriter(fw); 
//		for (int i = 0 ; i < 26; i++)
//		                 bw.write(i + 'a'); 
//		bw.close();

		//6. pritwriter 를 이용하여 출력
		//라인 seperator를 추가로 더하여야 한다.
		// 52바이트(문자만으로) + a[알파](라인변환 26바이트) = 78바이트 
		PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                new FileWriter ("alphabet2.txt")));
		for (int i = 0 ; i < 26; i++)
			//pw.println ((char)(i + 'A'));  // 문자로 변환
			pw.print ((char)(i + 'A'));  // 문자로 변환
		pw.close();


		
	}

}
