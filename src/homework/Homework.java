package homework;
import java.io.*;

/*
 * 	특정 디렉토리를 입력받아 그 내용을 모두 인쇄하는 Recursion 메소드 void printDir(File f) 작성하기
 */

public class Homework {
	public static void main(String args[]){
		File file = new File(args[0]);
		PrintDir.printDir(file);

	}
}