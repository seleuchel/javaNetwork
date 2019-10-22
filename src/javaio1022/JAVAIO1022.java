package javaio1022;

import java.io.IOException;

/*
 * ���ɸ��� ����� ���´�.
 * SYNCHRONIED : �����ڿ��� ����� �� �ִ� ������ ��ų �� �ִ�.
 * P.14
 * LOCK�� ����� �ʹ� Ŀ��. 
 * ->�ؽ��� ���� ���᤿.
 * ����� �߻�����.
 * 
 * �޼ҵ带 ��� ��ü�� ����ȭ ������� ����
 * 
 * 
 * 
 * �׷���
 * 
 * ����ȭ�� ���
 * �׷��� �ʵ� ��� �޼ҵ������ ����ϴ� ���� ����.
 * 
 *  �׸��� CALL BY VALUE�� ó���ǵ��� �޼ҵ� ���ڷ� �⺻ Ÿ���� ���
 *  
 *  
 * 
 */

////����1�� - �纸

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

//����2 - �ƿ� wait���� ���������� ��. 
//sleep�� thread
//
//public class JAVAIO1022 extends Thread {
//	public void run() {
//		while (true) {
//			try {
//				Thread.sleep(5000); // 300milliseconds
//				System.out.println("zzZZZ");
//			} catch (InterruptedException e) {
//				// ���� ���ͷ�Ʈ �ɸ� sleep �������� �̰� ����
//				System.out.println("���� �� ���� �����߾�!");
//			}
//			System.out.println("�����!");
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

//����3
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
//			System.out.println("���� �߿� ���ͷ� ��");
//		}
//	}
//	static void doSomethingElse(){
//	}
//}
//
//

////����3.12 - ���Ϻ��� digest�� �������⸦ ��ٸ�
//public class JAVAIO1022 {
//	public static void main(String[] args) {
//		WaitNotify wn = new WaitNotify();
//		Thread t1 = new Thread(wn, "WAIT");
//		Thread t2 = new Thread(wn, "NOTIFY");
//		t1.start();
//		t2.start();
//	}
//	static class WaitNotify implements Runnable {
//		private Object lockObject = new Object(); //������ü
//		public void run() {
//			if((Thread.currentThread().getName()).equals("WAIT"))
//				//lock ��� sum1
//				sun();
//			if((Thread.currentThread().getName()).equals("NOTIFY"))
//				//lock ���� 
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
//�����ü�� �����ϴ°�?

////��4 - ���� ��ü
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
////average ���� min ����
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
////wait notify�� �����ؾ��ϴ� �߿��� ��.

//����5 - ����ġ
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
//������ second, min, hour �� �ִ°� ����� 
//1�� 27�� 17�� (;�� ���̿� �ΰ�)
//3�� ������ �ð��� �����ؾ��ϰ� toString�� �� ǥ���ؾ���.
//!! �߿� !!
//�ʽð�� �нð谡 ����ġ�� ����.
//�нð�� �ýð谡 �� ����ġ �ϳ��� ����. 

//�ᱹ �нð�� ����ġ�� �� ���� ������ �־�� �Ѵ�.
//�ʽð赵 ���� �־�� �ϰ� �ýð赵 ������ �־�� �Ѵ�.
//
//������ ��,��, �� �� ��� ������ ������ �ð�.
//ǥ�ø� time ���� class�� to string���� ������־���Ѵ�.
//�ð��� �ʽð谡 �����־����.
//1�ʿ� �ð��� ��� �����־����/
//����ġ�� ��� �����ؾ��Ѵ�.

//2.
//�����尡 ����� ���س��⸦ ��ٸ�.
//�װ��� join���� 

//�� �� �����ε� ������ �߰���翡�� ���´�.

//������ �ַ� �츮�� �ߴ� ���� ���α׷����� ���´�. 
//�� Ǯ����� 
//���� �ȳ����� Ǯ�� ���´� 

//Thread -> runnable�� �ٲٽÿ�. 
