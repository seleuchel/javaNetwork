package javaio926;

import java.io.*;

public class JavaIo926 {

	public static void main(String[] args) throws Exception{
		//1. ǥ�� ����� ��Ʈ�� -> �� ����Ʈ�� (�ƽ�Ű�����..�ƽ�Ű�����..)
//		int count = 0;
//		int b = System.in.read();
//		while (b != -1) {
//			count++;
//			System.out.println(b + " " + (char) b);
//			b = System.in.read();
//
//		}
//		System.out.println("Number of Charactoer : " + count);
		
		//2. ���� ��Ʈ��  : �ѱ� �����ڵ带 ��ȭ�Ѵ� #������
//	    int c;
//	    int count = 0;
//	    InputStreamReader link = new InputStreamReader(System.in); 
//	    BufferedReader br  = new BufferedReader( link);
//	    while (  (c = br.read())  != -1) {
//	        count++;
//	        System.out.println(c + "  "+(char)c);
//	    }
//	    System.out.println("Number of Characters: "+count);

	    //3. �� �پ� ��� - �ѱ�
//	    InputStreamReader link = new  InputStreamReader(System.in);
//     	BufferedReader br = new BufferedReader( link);
//     	System.out.println("Enter lines of text.  End with CTRL-Z");
//     	//readLine�� ����Ϸ��� BufferedReader�� ����.
//     	//System.in - InputStreamReader - BufferedREader 
//     	//System.in�� �ٷ� BufferedReader�� ���� �� ����.
//     	String str = br.readLine();
//     	while ( str != null){
//		System.out.println(str);
//		str = br.readLine();
//	}

	// < ���� >
	//1. Writer : �ѱ� ���ڿ� ȭ�鿡 ���. 
//		Writer w = new OutputStreamWriter(System.out);
//		char[] nation = {'K', 'O', 'R', 'E', 'A', '��', '��' };
//		for (int i = 0; i < nation.length; i++) w.write(nation[i]); // write(int)
//		w.write(nation); 			// write(char[])
//		w.write(nation, 0, nation.length); 	// write(char[], int, int)
//		w.write("KOREA�ѱ�"); 		// write(String)
//		w.write("KOREA�ѱ�", 0, 7); 		// write(String, int, int)
//		w.flush(); // flush()�� ȣ������ ������ ��� ��� �� ���δ�

	//2. Writer : �ѱ� ���ڿ� ���Ͽ� ����
//		Writer w = new OutputStreamWriter(
//				//System.out
//				new FileOutputStream("output1.txt")
//				);
//		char[] nation = {'K', 'O', 'R', 'E', 'A', '��', '��' };
//		for (int i = 0; i < nation.length; i++) w.write(nation[i]); // write(int)
//		w.write(nation); 			// write(char[])
//		w.write(nation, 0, nation.length); 	// write(char[], int, int)
//		w.write("KOREA�ѱ�"); 		// write(String)
//		w.write("KOREA�ѱ�", 0, 7); 		// write(String, int, int)
//		w.flush(); // flush()�� ȣ������ ������ ��� ��� �� ���δ�. ���Ͽ� ��µ� �ȵ�.
	
		//3. Writer
		//��� : ��¡�� - ��ġ - ����box
		//�ٹٲ� ó���� ���� �ʾ����Ƿ� ���ڿ��� �� �̾�����.
//		OutputStreamWriter osw = new OutputStreamWriter(
//				new FileOutputStream("hanguel.dat"),
//				"MS949" //encoding-value (�ѱ� default : MS949 )
//				);
//		
//		//���ڵ� �� ���
//		System.out.println(osw.getEncoding());
//		//���Ͽ� ����
//		osw.write("��¡�� - ��ġ - ����");
//		osw.write("��������;��");
//		osw.flush();
		
		//4. ���Ͽ� ���� ���
		//FileWriter = FileOuputStream + OutputStreamWriter
		//	�̰� ����ϸ� ���۸� ����. ��! 2����Ʈ�� �����ؼ� ó��.
//		FileWriter fw = new FileWriter("mytxt.txt");
//		
//		char ch = 'a';
//		fw.write(ch);;
//		fw.flush(); // �ϰ� writer��� �ʼ���!
//		fw.close();
		
		//5. bufferedwriter - filewriter
		//�� ������ 2����Ʈ�� ����.
		//������ �� ����Ʈ�� ����.
//		FileWriter fw = new FileWriter ("alphabet.txt");
//		BufferedWriter bw = new BufferedWriter(fw); 
//		for (int i = 0 ; i < 26; i++)
//		                 bw.write(i + 'a'); 
//		bw.close();

		//6. pritwriter �� �̿��Ͽ� ���
		//���� seperator�� �߰��� ���Ͽ��� �Ѵ�.
		// 52����Ʈ(���ڸ�����) + a[����](���κ�ȯ 26����Ʈ) = 78����Ʈ 
		PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                new FileWriter ("alphabet2.txt")));
		for (int i = 0 ; i < 26; i++)
			//pw.println ((char)(i + 'A'));  // ���ڷ� ��ȯ
			pw.print ((char)(i + 'A'));  // ���ڷ� ��ȯ
		pw.close();


		
	}

}
