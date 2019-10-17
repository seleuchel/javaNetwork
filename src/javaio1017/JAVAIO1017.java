//package javaio1017;
//
//import javax.xml.bind.*; // for DatatypeConverter
//import java.io.*;
//import java.security.*;
//
//class ReturnDigest extends Thread {
//
//	private String filename;
//	private byte[] digest; // 파일로부터 다이제스트구해서 만든다
//
//	public ReturnDigest(String filename) {
//		this.filename = filename;
//	}
//
//	public void run() {
//		try {
//			FileInputStream in = new FileInputStream(filename);
//			MessageDigest sha = MessageDigest.getInstance("SHA-256");
//			DigestInputStream din = new DigestInputStream(in, sha);
//			while (din.read() != -1)
//				; // read entire file
//			din.close();
//			digest = sha.digest();
//		} catch (IOException ex) {
//			System.err.println(ex);
//		} catch (NoSuchAlgorithmException ex) {
//			System.err.println(ex);
//		}
//	}
//
//	public byte[] getDigest() { // 다이제스트 얻음
//		return digest;
//	}
//}
////
////1. 예제 - 원래 안되는 코드
////
////public class JAVAIO1017 {
////
////	public static void main(String[] args) {
////		for (String filename : args) {
////			// Calculate the digest
////			System.out.println(filename);
////			ReturnDigest dr = new ReturnDigest(filename);
////			dr.start();
////
////			// Now print the result
////			StringBuilder result = new StringBuilder(filename);
////			result.append(": ");
////			byte[] digest = dr.getDigest();
////			result.append(DatatypeConverter.printHexBinary(digest));
////			System.out.println(result);
////		}
////	}
////}
//
////2. 경쟁 - 이전의 ReturnDigest 활용
////아무것도 안 나온다.
//public class JAVAIO1017 {
//	public static void main(String[] args) {
//		ReturnDigest[] thread = new ReturnDigest[args.length];
//		for (int i = 0; i < args.length; i++) {
//			// Calculate the digest
//			thread[i] = new ReturnDigest(args[i]);
//			thread[i].start();
//		}
//		for (int i = 0; i < args.length; i++) {
//			while (true) {
//				// Now print the result
//				byte[] digest = thread[i].getDigest();
//				if (digest != null) {
//					for(byte a: digest) {
//						System.out.println(a);
//					}
//					StringBuffer result = new StringBuffer(args[i]);
//					result.append(": ");
//					result.append(DatatypeConverter.printHexBinary(digest));
//					System.out.println(result);
//					break;
//				}
//			}
//		}
//	}
//}

//
////3.
//import java.io.*;
//import java.security.*;
//import javax.xml.bind.*; 
//
//public class JAVAIO1017 {
//  
//  public static void receiveDigest(byte[] digest, String name) {
//    StringBuilder result = new StringBuilder(name);
//    result.append(": ");
//    result.append(DatatypeConverter.printHexBinary(digest));
//    System.out.println(result);
//  }
//  
//  public static void main(String[] args) {
//    for (String filename : args) {    
//      // Calculate the digest
//      CallbackDigest cb = new CallbackDigest(filename);
//      Thread t = new Thread(cb);
//      t.start();
//    } 
//  }
//}
//
//
//class CallbackDigest implements Runnable {
//
//  private String filename;
//
//  public CallbackDigest(String filename) {
//   this.filename = filename;
//  }
//
//  public void run() {
//    try {
//      FileInputStream in = new FileInputStream(filename);
//      MessageDigest sha = MessageDigest.getInstance("SHA-256");
//      DigestInputStream din = new DigestInputStream(in, sha);
//      while (din.read() != -1) ; // read entire file
//      din.close();
//      byte[] digest = sha.digest();
//      CallbackDigestUserInterface.receiveDigest(digest, filename);
//    } catch (IOException ex) {
//      System.err.println(ex);
//    } catch (NoSuchAlgorithmException ex) {
//      System.err.println(ex);
//    }
//  }
//}

////4
//import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0
//
//public class InstanceCallbackDigestUserInterface {
//
//	private String filename;
//	private byte[] digest;
//
//	public InstanceCallbackDigestUserInterface(String filename) {
//		this.filename = filename;
//	}
//
//	public void calculateDigest() {
//		InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
//		Thread t = new Thread(cb);
//		t.start();
//	}
//
//	void receiveDigest(byte[] digest) {
//		this.digest = digest;
//		System.out.println(this);
//	}
//
//	public String toString() {
//		String result = filename + ": ";
//		if (digest != null) {
//			result += DatatypeConverter.printHexBinary(digest);
//		} else {
//			result += "digest not available";
//		}
//		return result;
//	}
//
//	public static void main(String[] args) {
//		for (String filename : args) {
//			// Calculate the digest
//			InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
//			d.calculateDigest();
//		}
//	}
//}
// 자신의 객체 참조변수를 스레드에 넘겨줌.

//5. 동기화




