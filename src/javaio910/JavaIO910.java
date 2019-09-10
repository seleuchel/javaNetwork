package javaio910;

import java.io.*;

public class JavaIO910 {
	public static void main(String args[]) throws Exception {
		File f1 = new File("..\\file\\box.txt");
		
		//���� ������ ���� ���ο� ���þ��� �׸��� ��µȴ�.
		//hello�� �ִ� ����. ��, ��ũ�� �ִ� ���ϰ� ���� �� ���� �ƴ�
		//file ��ü ���� �ÿ� ����ڰ� �Է��� ������ path�� ������.
		System.out.println(f1.getName());
		System.out.println(f1.getPath());
		
		//���� �۾��ϴ� ���丮 ���
		System.out.println(System.getProperty("user.dir"));
		
		//absolute vs canonicalpath
		//���� ó�� ��Ź�ؿ�~ #�׷��� ��ȸ�� ��
		//�Ź� ���� ó���� ������. main����throws Exception �־��
		new File("..").getAbsolutePath();
		new File("..").getCanonicalPath();

		//���� 1
		File f2 = new File("..\\dirC");
		System.out.println("getName() = " + f2.getName());
		System.out.println("getPath() = " + f2.getPath());
		System.out.println("getAbsolutePath() = " + f2.getAbsolutePath());
		System.out.println("getParent() = " + f2.getParent());
		//Q ���� absoultepath�� canonicalpath�� ���ϴ� �޼ҵ��ΰ�
		//�츮�� �����ζ�� �ǹ̷� canonicalpath()�� ����ϸ� �ȴ�.
		
		//���� ���� ����  - root dir�� �����ȴ�.
		File newFile = new File("veryUseful.txt");
		boolean success = newFile.createNewFile();
		//���� ���� Ȯ��
		System.out.println(success);
		
		//���� ����  - root dir�� �����ȴ�. #java project dir
		File goaway = new File("hello.txt");
		goaway.delete();
		
		//���丮 ���� - root dir�� �����ȴ�.
		//�ڿ� \\ ���̸� ���丮�� ������ �� �ִ�.
		File dirfile = new File("father\\");
		dirfile.mkdir();
		
		//���丮 �ȿ� ���丮 �ȿ� ���丮
		File dirfiles = new File("works\\a\\b\\c");
		boolean success1 = dirfiles.mkdirs();
		System.out.println(success1);
		
		//���� ���� ������ ������ ����Ʈ�� 
		//���� '.'�� �ڹ�������Ʈ�� root dir �̴�.
		File cwd = new File(".");
		String[] files = cwd.list();
		for (String f: files)
			System.out.println(f);
		
		//����Ʈ ���� �Ѹ� ������
		//!!for each �� �迭�̳� �ݷ��� ������� ���� ����
		//!! ���� ��ü�� listRoots()�� �θ��� �ȵ�
		
		System.out.println("-----------------------------");
		File[] listRoot = File.listRoots();
		for(File k: listRoot)
			System.out.println(k);
		
		
		//�ݺ������� ��ġ�� - ���� ������ ����
		//���� Ŭ������ �ٷ� �����!!
		System.out.println("-><><><----------------------------");
		File[] files2 = File.listRoots();
		for(int i = 0 ; i < files2.length ;i++)
			System.out.println(files2[i]);
		
	}
}
