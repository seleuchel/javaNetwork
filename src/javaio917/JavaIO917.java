package javaio917;
import java.io.*;
/*
 * io ���� �� + io ����
 * ����Ʈ ��Ʈ��
 * �� �̿��Ͽ� ���Ͽ� ���
 */
public class JavaIO917 {
	public static void main(String args[]) throws Exception {
		// ����1 ��� : ���� �����Ͽ� FileOUtputStream���� ����ϱ�
		//�� ���� �� ����Ʈ
//		FileOutputStream fos = new FileOutputStream("file01.dat");
//		for (int i = 65; i < 65 + 26; i++) 
//			fos.write(i);
//		// �� �ΰ��� �ּ�ó���ϸ� ���� ������ ��� ������ ����! 
//		fos.close();
//		System.out.println(System.getProperty("user.dir"));
	
		// ���� 2
//		FileOutputStream fos = new FileOutputStream("file02.dat");
//		for(int i=33; i < 126 ; i++) {
//			fos.write(i);
//		}
//		fos.close();
		
		//���� 3
//		FileOutputStream fos = new FileOutputStream("file321.dat");
//			fos.write(321);
//			//A�� ������
//			//256 + 65 #9��° ��Ʈ�� 1
//		fos.close();
		
		//���� 4
//		FileOutputStream fos = new FileOutputStream("file02.dat");
//		for (int i = 321; i < 321 + 26; i++) 
//			fos.write(i);
//		fos.close();
		
		//���� 5
//		FileOutputStream fos = new FileOutputStream("file02.dat");
//		for (int i = -191; i < -191 + 26; i++) {
//			fos.write(i);
//			System.out.println("���Ͽ� ��µǴ� ��=" + (-191 & 0xff));
//		}
//		fos.close();
		
		//���� 6 : ��ä�� �迭�� ������ ����ִ� ��� 
//		byte[] b = new byte[26];
//		for (int i = 0; i < 26; i++) b[i] = (byte)(i+65);
//		
//		FileOutputStream fos = new FileOutputStream("file03.dat");
//		//����Ʈ �迭�� ���ڷ� �־��ָ� �ȴ�
//		fos.write(b);
//		fos.close();
		
		//���� 7 : ��°�� ����ϴ� ��
//		String s = "�ڶ����� �������б�";
//		byte[] data = s.getBytes();
//		
//		FileOutputStream fos1 = new FileOutputStream("jnu.dat");
//		fos1.write(data);
//		fos1.close();
		
// < �Է� ��Ʈ��  ���� >
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
