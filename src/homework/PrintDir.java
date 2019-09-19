package homework;
import java.io.*;

class PrintDir {
	public static void printDir(File f) {
		// exist?
		if (!f.exists())
			System.exit(0);
		// is directory exist?
		if (!f.isDirectory())
			System.exit(0);

		File[] list = f.listFiles();
		for (File k : list) {
			System.out.println("[" + k.getName() + "]");
			try {
				FileInputStream fin = new FileInputStream(k);
				int i = fin.read();

				while (i != -1) {
					System.out.print((char) i);
					i = fin.read();
				}
				System.out.println();
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
