package javaio923;

import java.io.*;


public class javaio923 {

	public static void main(String[] args) throws IOException {
		
//1 . 문자로 바꾸어 파일로 출력.	
//		try {
//			FileOutputStream fos = new FileOutputStream("textout.txt");
//			PrintStream ps = new PrintStream(fos);
//			boolean bool = true;
//			ps.println(bool);// boolean
//			byte b = -128;
//			ps.println(b);// byte
//			double d = 0.9;
//			ps.println(d);// double
//			Object o = new Object();
//			ps.println(o);// object
//		} catch (IOException e) {
//			System.out.println("Error -- " + e.toString());
//		}

		
//2. print()와 write()의 차이란.
//		System.out.println(1);//int 1 -> '1'(int 49)
//		System.out.write(1); //출력이 안됨. 0000 0001 임. 해당하는 코드가 없어서 출력이 불가함. #제어문자인가..? 
		
		
//2.1  둘 다 파일로 출력하는 print()와 write()의 차이		
//		PrintStream ps = new PrintStream(new FileOutputStream( "write.txt"));
//		ps.write(127); //0000 0127로 바이트를 쓰나 보이지는 않음. 한 바이트를 출력한다.
//
//		PrintStream ps1 = new PrintStream(new FileOutputStream("print.txt"));
//		ps1.print(127);//1,2,7 : 세 바이트를 출력한다.


//2.2  print()와 write()의 차이	
//System.out.write(65);  //1바이트
//System.out.print(65); //2바이트 = '6' + '5'


//2.3 이거는 같다.
//System.out.println('A');
//System.out.print('A'); 
		
//일반적 : MS949 (microsoft-hangule MS)

		
//>> DataOutputStream <<
//나머지는 두 바이트 이상. - little endian, Big endian 문제
//java는 bigendian!! 상위 바이트부터 떼어 처리

//1. 예제 : DataOutputStream 으로 출력하기. textfile 내의 것은 127 64
//어떤 데이터로 출력을 할 거냐에 대한 => DataOutputStream
//이상한 문자(127)와 A(64)가 출력되었다. 
//	       Scanner input = new Scanner(new File("textfile"));
//	       DataOutputStream out = new DataOutputStream(new FileOutputStream("binaryFile"));
//
//	       while (input.hasNext()) {
//	              int number = input.nextInt();
//	              out.writeInt(number);
//	       }
//	       out.close();

		
//2. 보충문제
//		DataOutputStream dos = new DataOutputStream(
//		new FileOutputStream("1000.dat"));
//		dos.writeInt(18);// 0000 0000 0001 0010
//		dos.writeInt(-18);// 1111 1111 1110 1110
//		dos.close();
//		FileInputStream fis = new FileInputStream ("1000.dat");
//		int total = 0;
//		int j = fis.read();
//		while (j != -1) {
//			total++;
//			System.out.print(j + " ");
//			j = fis.read();
//		}
//		System.out.println(total + " bytes");

//2.1 보충문제 이어서
//		DataOutputStream dos = new DataOutputStream(
//		new FileOutputStream("1000.dat"));
//		dos.writeInt(65 * pow(2, 24) + 66 * pow(2, 16) + 67 * pow(2, 8) + 68);
//		dos.writeInt(0x3C * pow(2, 24) + 0x3D * pow(2, 16) + 0x3E * pow(2, 8) + 0x3F);
//		dos.close();
//		FileInputStream fis = new FileInputStream ("1000.dat");
//		int total = 0;
//		int j = fis.read();
//		while (j != -1) {
//			total++;
//			System.out.print(j + " ");
//			j = fis.read();
//		}
//		System.out.println(total + " bytes");
	
//3. EOF exception  @@일종의 IO Exception?
//this code no throws exception in main
//		int total = 0; //3번 read int int eofexception #-1대신에 이게 출력.
//		try{
//			DataInputStream dis = new DataInputStream(
//				new FileInputStream("1000.dat")); # DataInputStream
//			while (true) {
//				int theRead = dis.readInt();
//				total++;
//				System.out.println(theRead + " ");
//			}
//		}catch (EOFException e) {
//			System.out.println(total + " ints read");
//		} catch (IOException e) {
//			System.err.println("Some IO Exception occurred");
//		}

		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("1000.txt"));
			dos.writeDouble(3.141592);
			dos.writeDouble(0.12122112);
			dos.writeDouble(1.1111111);
			dos.writeDouble(9.98989898);
			dos.writeDouble(9.33333333);
			
			dos.close();
		try {
			//DataInputStream
			DataInputStream dis = new DataInputStream(new FileInputStream("1000.txt"));
		while(true) {
			byte read = dis.readByte();
			System.out.print(read);
		}
		
	}catch (EOFException e) {
		System.out.println("ok");
	}
	
		try {
			// 3번째 내용. 이진수로 출력하라며, ppt 내용하고 많이 다른데, 괜찮아?? 문제에서 요구하는 출력을 잘 모르겠다.
			DataInputStream dis1 = new DataInputStream(new FileInputStream("1000.txt"));
		while(true) {
			double read2 = dis1.readDouble();
			System.out.print(read2);
		}
		
	}catch (EOFException e) {
		System.out.println("ok");
	}
		
// 이진수로 출력하라며, ppt 내용하고 많이 다른데, 괜찮아?? 문제에서 요구하는 출력을 잘 모르겠다.
	
//    static int pow(int a, int b) {
//return (int) (Math.pow(a, b));
//     }
	}
	}

