package javaio1121;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Javaio1121 {
	// 1.Server socket - Ŭ���̾�Ʈ���� ���� ������� ������ų �ʿ䰡 �ִ�.
	public static void main(String args[]) throws IOException {
//		int port = 13;
//		ServerSocket server = new ServerSocket(port); //# make server socket
//		while (true) {
//			try (Socket connection = server.accept()) { //# make connection and get socket
//				Writer out = new OutputStreamWriter(connection.getOutputStream());//# get data from connection getoutputstream & coever writer
//				Date now = new Date();
//				out.write(now.toString() + " from SuMin \r\n"); //# write
//				out.flush();
//			} catch (IOException ex) {
//				// �� Ŭ���̾�Ʈ���� ���ῡ�� ���� ����
//				// ������ �˴ٿ��� �ʿ�� ����
//				System.err.println(ex.getMessage());
//			}
//		}
	//�������� 2��
		int port = 7009;
		ServerSocket server = new ServerSocket(port);
		while( true) {
			try(Socket connection = server.accept()){
				//OutputStream �� �����´�.
				//���� ���� �� ����.
				OutputStreamWriter out = new OutputStreamWriter(
						connection.getOutputStream());
				
				out.write("�� �� �ÿ� �÷� \r\n"); //# write
				out.flush();
				
				System.out.println("Server : �� �� �ÿ� �÷�");
				//Inputstream�� �����´�.
//				InputStreamReader in = new InputStreamReader(
//						connection.getInputStream());
//				String str = in.read();
						
			}
		}
		
	}

}

//������ ��� �����ִ�!
//Ŭ���̾�Ʈ�� ��Ʈ�� ����� ����.