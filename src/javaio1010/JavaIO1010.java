package javaio1010;
import java.io.*;
import java.security.*;
import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0


public class JavaIO1010 extends Thread {
//	public int sum = 0;
//	public int num = 0;
//	
//	public JavaIO1010() {
//		
//	}
//	
//	public JavaIO1010(int a) {
//		num = a;
//	}
//	
// 1. 
//	public void run() {
//		for (int i = 0; i < num; i++) {
//			sum += i;
//		}
//		//���ϰٴ�
//	}
//	
//	public void summing(int a) {
//		int sum = 0;
//		
//	}
//
//	public static void main(String[] args) {
//		// thread 10/10
//		new JavaIO1010(10).start();// ������ ��ü�� ����. start��ü�� ����!
//	}

	
	//2. ������ �ض� Ŭ���� �� ��Ծ��� ///////////////////////////
	// ������ �ֱ�� ���ڿ��� ��Ÿ��. 
	// quick�� 3�� ���� ��, slow�� 1�� ���;� �� �� ������ �̻��ϱ��� - �� �����
//	String say;
//	int delay;
//
//	JavaIO1010(String whatToSay, int delayTime) {
//		say = whatToSay;
//		delay = delayTime;
//	}
//
//	public void run() {
//		try {
//			for (;;) {
//				System.out.print(say + " ");
//				sleep(delay);
//			}
//		} catch (InterruptedException e) {
//			return; // ������ ���� ��
//		}
//	}
//
//	public static void main(String[] args) {
//		new JavaIO1010("Quick", 1000).start(); // 1/30 ��
//		new JavaIO1010("Slow", 3000).start(); // 1/10 ��
//	}
	
	//3. summing�� ��������
//	int total = 0;
//	
//	JavaIO1010(int num){
//		run(num);
//	}
//	public void run(int num) {
//		for(int i = 0; i < num; i++) {
//			total += i;
//		}
//		System.out.println("total : " + total);
//	}
//	
//	public static void main(String[] args) {
//		new JavaIO1010(100).start();
//	}
	
//4. digest�� ��ȯ�ϴ� 
//	  private String filename;
//
//	  public JavaIO1010(String filename) {
//	   this.filename = filename;
//	  }
//
//	  @Override
//	  public void run() {
//	    try {
//	      FileInputStream in = new FileInputStream(filename);
//	      MessageDigest sha = MessageDigest.getInstance("SHA-256");
//	      DigestInputStream din = new DigestInputStream(in, sha);
//	      while (din.read() != -1) ;
//	      din.close();
//	      byte[] digest = sha.digest();
//	      
//	      StringBuilder result = new StringBuilder(filename); //��Ʈ������ �����
//	      result.append(": ");
//	      result.append(DatatypeConverter.printHexBinary(digest));
//	      System.out.println(result);
//	    } catch (IOException ex) {
//	      System.err.println(ex);
//	    } catch (NoSuchAlgorithmException ex) {
//	      System.err.println(ex);
//	    }
//	  }
//	  
//	  public static void main(String[] args) {
//	    for (String filename : args) {
//	      Thread t = new JavaIO1010(filename);
//	      t.start();
//	    }
//	  }
/*
 * arg : output.txt output1.txt
 * output.txt: 92ACB7DF4EE23F7144632613627594688824AEC138AAF84187DD68543C9977C5
 * output1.txt: E3B0C44298FC1C149AFBF4C8996FB92427AE41E4649B934CA495991B7852B855
 */
	  
//5. 
//	 public static void main(String[] args) {
//	      new Thread(new CountDown()).start();
//	//new CountDown : �����尡 ���ϴ� ��ü (Ÿ�� ��ü��� ��)
//	   }
	
	//6.
	public static void main(String args[]) {
		new Thread(new MyRunnable()).start();
	}
	
}


//5.
//class CountDown implements Runnable {
//	   public void run() {
//	      System.out.println("Counting Down" + " ");
//	      for (int i = 0; i < 10; i++) {
//	         System.out.print(10 - i + " ");
//	      }
//	      System.out.println("\nShot");
//	   }
//	}

//6. 
class MyRunnable implements Runnable {
	public void run(){
	       System.out.print("1 line print.");
	}

}

