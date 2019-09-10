package javaio910;

import java.io.*;

public class JavaIO910 {
	public static void main(String args[]) throws Exception {
		File f1 = new File("..\\file\\box.txt");
		
		//실제 파일의 존재 여부와 관련없이 항목이 출력된다.
		//hello가 있던 없던. 즉, 디스크에 있는 파일과 매핑 된 것이 아님
		//file 객체 생성 시에 사용자가 입력한 값으로 path가 설정됨.
		System.out.println(f1.getName());
		System.out.println(f1.getPath());
		
		//현재 작업하는 디렉토리 출력
		System.out.println(System.getProperty("user.dir"));
		
		//absolute vs canonicalpath
		//예외 처리 부탁해요~ #그러니 우회를 해
		//매번 예외 처리는 귀찮다. main에서throws Exception 넣어요
		new File("..").getAbsolutePath();
		new File("..").getCanonicalPath();

		//예제 1
		File f2 = new File("..\\dirC");
		System.out.println("getName() = " + f2.getName());
		System.out.println("getPath() = " + f2.getPath());
		System.out.println("getAbsolutePath() = " + f2.getAbsolutePath());
		System.out.println("getParent() = " + f2.getParent());
		//Q 질문 absoultepath랑 canonicalpath는 뭘하는 메소드인가
		//우리는 절대경로라는 의미로 canonicalpath()를 사용하면 된다.
		
		//파일 생성 예제  - root dir에 생성된다.
		File newFile = new File("veryUseful.txt");
		boolean success = newFile.createNewFile();
		//존재 여부 확인
		System.out.println(success);
		
		//파일 제거  - root dir에 생성된다. #java project dir
		File goaway = new File("hello.txt");
		goaway.delete();
		
		//디렉토리 생성 - root dir에 생성된다.
		//뒤에 \\ 붙이면 디렉토리를 생성할 수 있다.
		File dirfile = new File("father\\");
		dirfile.mkdir();
		
		//디렉토리 안에 디렉토리 안에 디렉토리
		File dirfiles = new File("works\\a\\b\\c");
		boolean success1 = dirfiles.mkdirs();
		System.out.println(success1);
		
		//현행 폴더 내부의 내용을 리스트로 
		//물론 '.'는 자바프로젝트의 root dir 이다.
		File cwd = new File(".");
		String[] files = cwd.list();
		for (String f: files)
			System.out.println(f);
		
		//리스트 파일 뿌리 보여줌
		//!!for each 는 배열이나 콜렉션 대상으로 진행 가능
		//!! 절대 객체로 listRoots()를 부르면 안됨
		
		System.out.println("-----------------------------");
		File[] listRoot = File.listRoots();
		for(File k: listRoot)
			System.out.println(k);
		
		
		//반복문으로 고치기 - 위와 동일한 예제
		//파일 클래스로 바로 써야함!!
		System.out.println("-><><><----------------------------");
		File[] files2 = File.listRoots();
		for(int i = 0 ; i < files2.length ;i++)
			System.out.println(files2[i]);
		
	}
}
