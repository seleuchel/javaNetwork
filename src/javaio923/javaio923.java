package javaio923;

import java.io.*;


public class javaio923 {

	public static void main(String[] args) throws IOException {
		
//1 . ���ڷ� �ٲپ� ���Ϸ� ���.	
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

		
//2. print()�� write()�� ���̶�.
//		System.out.println(1);//int 1 -> '1'(int 49)
//		System.out.write(1); //����� �ȵ�. 0000 0001 ��. �ش��ϴ� �ڵ尡 ��� ����� �Ұ���. #������ΰ�..? 
		
		
//2.1  �� �� ���Ϸ� ����ϴ� print()�� write()�� ����		
//		PrintStream ps = new PrintStream(new FileOutputStream( "write.txt"));
//		ps.write(127); //0000 0127�� ����Ʈ�� ���� �������� ����. �� ����Ʈ�� ����Ѵ�.
//
//		PrintStream ps1 = new PrintStream(new FileOutputStream("print.txt"));
//		ps1.print(127);//1,2,7 : �� ����Ʈ�� ����Ѵ�.


//2.2  print()�� write()�� ����	
//System.out.write(65);  //1����Ʈ
//System.out.print(65); //2����Ʈ = '6' + '5'


//2.3 �̰Ŵ� ����.
//System.out.println('A');
//System.out.print('A'); 
		
//�Ϲ��� : MS949 (microsoft-hangule MS)

		
//>> DataOutputStream <<
//�������� �� ����Ʈ �̻�. - little endian, Big endian ����
//java�� bigendian!! ���� ����Ʈ���� ���� ó��

//1. ���� : DataOutputStream ���� ����ϱ�. textfile ���� ���� 127 64
//� �����ͷ� ����� �� �ųĿ� ���� => DataOutputStream
//�̻��� ����(127)�� A(64)�� ��µǾ���. 
//	       Scanner input = new Scanner(new File("textfile"));
//	       DataOutputStream out = new DataOutputStream(new FileOutputStream("binaryFile"));
//
//	       while (input.hasNext()) {
//	              int number = input.nextInt();
//	              out.writeInt(number);
//	       }
//	       out.close();

		
//2. ���湮��
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

//2.1 ���湮�� �̾
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
	
//3. EOF exception  @@������ IO Exception?
//this code no throws exception in main
//		int total = 0; //3�� read int int eofexception #-1��ſ� �̰� ���.
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
			// 3��° ����. �������� ����϶��, ppt �����ϰ� ���� �ٸ���, ������?? �������� �䱸�ϴ� ����� �� �𸣰ڴ�.
			DataInputStream dis1 = new DataInputStream(new FileInputStream("1000.txt"));
		while(true) {
			double read2 = dis1.readDouble();
			System.out.print(read2);
		}
		
	}catch (EOFException e) {
		System.out.println("ok");
	}
		
// �������� ����϶��, ppt �����ϰ� ���� �ٸ���, ������?? �������� �䱸�ϴ� ����� �� �𸣰ڴ�.
	
//    static int pow(int a, int b) {
//return (int) (Math.pow(a, b));
//     }
	}
	}

