package javaio1121;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Javaio1121 {
	// 1.Server socket - 클라이언트와의 일을 스레드로 독립시킬 필요가 있다.
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
//				// 한 클라이언트와의 연결에서 생긴 문제
//				// 서버를 셧다운할 필요는 없음
//				System.err.println(ex.getMessage());
//			}
//		}
	//연습문제 2번
		int port = 7009;
		ServerSocket server = new ServerSocket(port);
		while( true) {
			try(Socket connection = server.accept()){
				//OutputStream 을 가져온다.
				//종류 정리 좀 하자.
				OutputStreamWriter out = new OutputStreamWriter(
						connection.getOutputStream());
				
				out.write("너 몇 시에 올래 \r\n"); //# write
				out.flush();
				
				System.out.println("Server : 너 몇 시에 올래");
				//Inputstream을 가져온다.
//				InputStreamReader in = new InputStreamReader(
//						connection.getInputStream());
//				String str = in.read();
						
			}
		}
		
	}

}

//서버는 계속 돌고있다!
//클라이언트는 포트의 언급이 없다.