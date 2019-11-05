package tester;

import java.io.File;

public class PU {
	public static void main(String[] args) throws Exception {
		File file1 = new File("Ran.test");
		File file2 = new File(".");
		File file3 = new File("..");
		System.out.println(System.getProperty("user.dir"));
		System.out.println(file1.getCanonicalPath());
		System.out.println(file2.getCanonicalPath());
		System.out.println(file3.getCanonicalPath());
		System.out.println("==================");
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getAbsoluteFile());
	}
}
