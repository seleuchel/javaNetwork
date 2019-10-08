package javaio1001;

import java.io.*;

public class Javaio1001 {
	public static void main(String args[]) throws Exception{
		
//1. ���� 1�� - InputStreamReader�� �ѱ��б� (2����Ʈ�� �о ó���� �Ѵ�.)
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
//		//*print�� �ϸ� 30000���� ���(���� ���ڿ�)
//		//�ѱ��� 2����Ʈ �� �̹Ƿ� property������ -> 8����Ʈ�� ����
////bufferedreader + inputstream �ϸ� �ӵ� ���� ����.
	
//	FileReader fi = new FileReader(new File("hanguel.dat"));
//	//!! ���ڵ��� �� �� ����
//	
//	int i = fi.read();
//	
//	while (i != -1) {
//		System.out.print((char)i);
//		i = fi.read();
//	}
		
		
//3. �ѱ۹��� ó�� - outputstream
//		byte[] data = "���ѹα�".getBytes("MS949");
//		OutputStream j = new FileOutputStream("hangeul.dat");
//		
//		for(int m = 0; m < data.length; m++) {
//			int ic = data[m] & 0xff;
//			j.write(ic);
//		}
//		//��ü�� ������ �� ���� �ִ�.
//		//j.write(data);
//		j.close();
//		
//		//�о���϶��� �ݵ�� ������ �̿�!!!
		
//4. �ѱ۷κ��� ������ ���.
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("hangeul.dat"));
//		int input = isr.read();
//		while(input != -1) {	
//			// ���� input�� �� �κп��� ������ �����
//			System.out.print((char)input);
//			input = isr.read();
//		}
//		
//		isr.close();
		
//5. ����Ʈ �迭�� �����ؼ� �ʿ��� �� ���ڿ��� ��ȯ�Ͽ� ����� ���� �ִ�. (���� ���·� �о string���� �ٲپ� �д´�)
//��� 2����Ʈ ���ڸ� ó���ϴ� ���!!
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
//		// �� ��ġ�� fromArray�� ä��� �ٸ� �ڵ嵵 ������
//		System.out.println("�迭 ���� byte ��  " + fromArray.length);
//		// byte �迭�κ��� �о� ���� ByteArrayInputStrem�� ����
//		ByteArrayInputStream bais = new ByteArrayInputStream(fromArray);
//		
//		byte[] carrier = new byte[512]; // 1ȸ�� 512 ����Ʈ�� ���� ����
//		int count = bais.read(carrier); //�о���� ���� ��?
//		while(count != -1){
//			System.out.write(carrier, 0, count); //�ܼ��� ���ڷ� �ٲپ� ������(write [���̳ʸ� �� ��ü�� ���])
//			count = bais.read(carrier);
//		}
//		System.out.println("byte �迭�� ����Ϳ� ��� �������");

//		
//		
//		InputStream in = new DataInputStream(new FileInputStream("a.txt"));
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		int b =in.read();
//		while(b != -1) {
//			out.write(b); // �о� ���� �����͸� ����Ʈ �迭�� ��� #��
//			b =in.read();
//		}
//		byte[] data = out.toByteArray();// ����Ʈ �迭�� ��´� !!

		
		//!! ������ �򰥸��� ��ƴ�! �� �з��ص���
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(bos);
		String s = "�ڹ�stream";
		osw.write(s); 
		osw.flush();
		byte[] ba = bos.toByteArray();
		
		// ����Ʈ �迭�� ��ü ������ �� ����Ʈ�� ����� ����
		for(int m=0;m<ba.length;m++){
			int ich = ba[m] & 0xff;
			System.out.print(Integer.toHexString(ich) + " ");
		}
		// ����Ʈ �迭�� ���ڿ��� ��ȯ�Ͽ� ����� ����
		String reconstructed = new String(ba, 0, ba.length);
		System.out.println('\n' + reconstructed);
		
	}
}
