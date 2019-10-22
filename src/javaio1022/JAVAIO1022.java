package javaio1022;

import java.io.IOException;

/*
 * 렉걸리니 여기다 적는다.
 * SYNCHRONIED : 공유자원을 사용할 수 있는 질서를 지킬 수 있다.
 * P.14
 * LOCK의 대상이 너무 커짐. 
 * ->극심한 성능 저햐ㅏ.
 * 데드락 발생가능.
 * 
 * 메소드를 담는 객체를 동기화 대상으로 여김
 * 
 * 
 * 
 * 그래서
 * 
 * 동기화이 대안
 * 그래서 필드 대신 메소드단위를 사용하느 것이 좋다.
 * 
 *  그리고 CALL BY VALUE로 처리되도록 메소드 인자로 기본 타입을 사용
 *  
 *  
 * 
 */

////예제1번 - 양보

//
//public class JAVAIO1022 extends Thread {
//	static int times;
//	static boolean doYield;
//	private String word;
//
//	JAVAIO1022(String word) {
//		this.word = word;
//	}
//
//	public void run() {
//		for (int i = 0; i < times; i++) {
//			System.out.println(word);
//			if (doYield)
//				yield(); // give another thread a chance
//		}
//	}
//
//	public static void main(String[] args) {
//		times = Integer.parseInt(args[1]);
//		doYield = new Boolean(args[0]).booleanValue();
//		Thread cur = currentThread();
//		cur.setPriority(Thread.MAX_PRIORITY);
//		for (int i = 2; i < args.length; i++) {
//			new JAVAIO1022(args[i]).start();
//		}
//	}
//}

//예제2 - 아예 wait에서 빠져나오는 것. 
//sleep은 thread
//
//public class JAVAIO1022 extends Thread {
//	public void run() {
//		while (true) {
//			try {
//				Thread.sleep(5000); // 300milliseconds
//				System.out.println("zzZZZ");
//			} catch (InterruptedException e) {
//				// 누가 인터럽트 걸면 sleep 빠져나와 이거 수행
//				System.out.println("누가 내 잠을 방해했어!");
//			}
//			System.out.println("잘잤다!");
//		}
//
//	}
//
//	public static void main(String[] args) {
//
//			Thread th = new JAVAIO1022();
//			th.start();
//			th.interrupt();
//
//	}
//}

//예제3
//class CalcThread extends Thread {
//	private double result;
//	public void run(){
//		result = calculate();
//	}
//	public double getResult(){
//		return result;
//	}
//	public double calculate(){
//		// calculate a value for "result"
//		int ret = 0;
//		int arr[] = new int [10];
//		
//		for(int i= 0; i < )
//		
//		return ret;
//	}
//}
//
//
//public class JAVAIO1022 {
//	public static void main(String[] args){
//		CalcThread calc = new CalcThread();
//		calc.start();
//		doSomethingElse();
//		try{
//			calc.join();
//			System.out.println("Result is " + calc.getResult());
//		} catch (InterruptedException e){
//			System.out.println("조인 중에 인터럽 됨");
//		}
//	}
//	static void doSomethingElse(){
//	}
//}
//
//

////예제3.12 - 파일별로 digest가 구해지기를 기다림
//public class JAVAIO1022 {
//	public static void main(String[] args) {
//		WaitNotify wn = new WaitNotify();
//		Thread t1 = new Thread(wn, "WAIT");
//		Thread t2 = new Thread(wn, "NOTIFY");
//		t1.start();
//		t2.start();
//	}
//	static class WaitNotify implements Runnable {
//		private Object lockObject = new Object(); //공유객체
//		public void run() {
//			if((Thread.currentThread().getName()).equals("WAIT"))
//				//lock 얻고 sum1
//				sun();
//			if((Thread.currentThread().getName()).equals("NOTIFY"))
//				//lock 해제 
//				moon();
//		}
//		public void sun() {
//			synchronized (lockObject) { 
//				try {
//					System.out.println("1 sun() ");
//					lockObject.wait();
//					System.out.println("2 sun() ");
//				} catch (InterruptedException e) {
//					System.out.println("3 sun() ");
//				}
//			}
//		}
//		public void moon() {
//			synchronized (lockObject) {
//				System.out.println("A moon() ");
//				lockObject.notify();
//				System.out.println("B moon() ");
//				try {
//					int val = System.in.read();
//					System.out.println(val);
//				}catch(IOException e) {
//				}
//			}
//		}
//	}

//	}
//어느객체를 공유하는가?

////예4 - 공유 객체
//public class JAVAIO1022 {
//	public static void main(String[] args) {
//		Integer integer = new Integer(100);
//		Wait wait = new Wait(integer);
//		Notify notify = new Notify(integer);
//		Thread t1 = new Thread(wait, "WAIT");
//		Thread t2 = new Thread(notify, "NOTIFY");
//		t1.start();
//		t2.start();
//	}
//}
//class Wait implements Runnable {
//	private Object lockObject;
//	public Wait(Object obj){
//		lockObject = obj;
//	}
//	public void run() {
//		synchronized (lockObject) { 
//			try {
//				System.out.println(Thread.currentThread().getName() + "-  1");
//				lockObject.wait();
//				System.out.println(Thread.currentThread().getName() + "-  2");
//			} catch (InterruptedException e) {
//				System.out.println("Sun() 3");
//			}
//		}
//	}
//}
//class Notify implements Runnable {
//	private Object lockObject;
//	public Notify(Object obj){
//		lockObject = obj;
//	}
//	public void run() {
//		synchronized (lockObject) {
//			System.out.println(Thread.currentThread().getName() + "-  A");
//			lockObject.notify();
//			System.out.println(Thread.currentThread().getName() + "-  B");
//		}
//	}
//}
//
//
//

//
////average 공유 min 공유
//public class JAVAIO1022 {
//	public static void main(String[] args) {
//		Mean mean = new Mean();
//		Waiter waiter = new Waiter(mean);
//		Server server = new Server(mean, new int[] { 1, 2, 3, 4, 5 });
//		Thread t1 = new Thread(waiter);
//		Thread t2 = new Thread(server);
//		t1.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			System.out.println("Interrupted !");
//		}
//		t2.start();
//	}
//}
//
//class Waiter implements Runnable {
//	private Mean avr;
//
//	public Waiter(Mean a) {
//		avr = a;
//	}
//
//	public void run() {
//		synchronized (avr) {
//			try {
//				avr.wait();
//				System.out.println("average = " + avr.getAverage());
//			} catch (InterruptedException e) {
//				System.out.println("Interrupted !");
//			}
//		}
//	}
//}
//
//class Server implements Runnable {
//	private Mean avr;
//	private int[] array;
//
//	public Server(Mean a, int[] data) {
//		avr = a;
//		array = data;
//	}
//
//	public void run() {
//		synchronized (avr) {
//			double sum = 0;
//			for (int i = 0; i < array.length; i++) {
//				sum += array[i];
//			}
//			avr.setAverage(sum / array.length);
//			avr.notify();
//		}
//	}
//}
//
//class Mean {
//	private double average;
//
//	void setAverage(double d) {
//		average = d;
//	}
//
//	double getAverage() {
//		return average;
//	}
//}
//
//
////wait notify는 숙달해야하는 중요한 것.

//예제5 - 스위치
public class JAVAIO1022 {
	public static void main(String[] args) {
		Switch swtch = new Switch();
		Second second = new Second(swtch);
		Thread t1 = new Thread(second);
		Minute minute = new Minute(swtch);
		Thread t2 = new Thread(minute);
		t1.start();
		t2.start();
	}
}

class Switch {
	private boolean inUse = true;

	public synchronized void on() {
		while (inUse) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
			;
		}
		inUse = true;
	}

	public synchronized void off() {
		inUse = false;
		notify();
	}
}

class Second implements Runnable {
	private int seconds = 0;
	private Switch swtch;

	public Second(Switch swtch) {
		this.swtch = swtch;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (seconds == 59) {
				swtch.off();
				seconds = 0;
			} else {
				seconds++;
				System.out.println(seconds);
			}
		}
	}
}

class Minute implements Runnable {
	private int minutes = 0;
	private Switch swtch;

	public Minute(Switch swtch) {
		this.swtch = swtch;
	}

	public void run() {
		while (true) {
			swtch.on();
			if (minutes == 59)
				minutes = 0;
			else {
				minutes++;
				System.out.println(minutes + " minutes");
			}
		}
	}
}
//1.
//과제는 second, min, hour 도 있는거 만들기 
//1시 27분 17초 (;을 사이에 두고)
//3개 단위의 시간을 공유해야하고 toString을 잘 표시해야함.
//!! 중요 !!
//초시계와 분시계가 스위치를 공유.
//분시계와 시시계가 또 스위치 하나를 공유. 

//결국 분시계는 스위치를 두 개를 가지고 있어야 한다.
//초시계도 갖고 있어야 하고 시시계도 가지고 있어야 한다.
//
//과제는 초,분, 시 를 모두 가지는 디지털 시계.
//표시를 time 같은 class를 to string으로 만들어주어야한다.
//시간은 초시계가 보여주어야함.
//1초에 시간을 모두 보여주어야함/
//스위치를 모두 공유해야한다.

//2.
//스레드가 평균을 구해내기를 기다림.
//그것을 join으로 

//둘 다 과제로도 나오고 중간고사에도 나온다.

//시험은 주로 우리가 했던 예제 프로그램에서 나온다. 
//잘 풀어봐라 
//개념 안나오고 풀이 나온다 

//Thread -> runnable로 바꾸시오. 
