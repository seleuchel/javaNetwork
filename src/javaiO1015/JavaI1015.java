package JavaIO1015;

/*
 * �����ð��� �� �ߴ��� ���� �� �� ����.
 * �����带 ���� �����Ű�� �� ���� ����� �־���.
 * new thread�ÿ� runnable ��ü�� �ֵ���.
 * 
 * 
 * ������ : �۾�ó���� ������� ������������ �۾��� �̷�� ���� ������. 
 * 	�����带 ���� �� 
 */

// 1.
//	public static void main(String[] args) {
//		Worker w = new Worker();
//		Thread t = new Thread(w, "Able"); //#�̸��� ��
//		t.start();
//		for ( int i = 0; i < 3; i++ ) w.namePrint(); //#���� �����嵵 3�� ȣ��.
//	}

//>>> EXECUTOR <<<
//1.
//	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++) {
//			unitTask();
//		}
//	}
//
//	private static void unitTask() {
//		System.out.println(Thread.currentThread().getName() + " 1ȸ�� �� ó��");
//		}

////2-2 : ������ �����尡 ���� �ϳ��� ó��.
//public class JavaI1015 implements Runnable {
//	public void run() {
//		unitTask();
//	}
//
//	private void unitTask() {
//		System.out.println(Thread.currentThread().getName() + " 1ȸ�� �� ó��");
//	}
//
//	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++) {
//			new Thread(new JavaI1015()).start();
//		}
//	}
//}

////Executor
//public interface Executor {
//	void execute(Runnable command);
//}

//3.
//public class JavaI1015 implements Runnable {
//	private static Executor ex = Executors.newSingleThreadExecutor();
//
//	public void run() {
//		unitTask();
//	}
//
//	private void unitTask() {
//		System.out.println(Thread.currentThread().getName() + " Doing work once");
//		//[����] a ���� z ���� ����ϴ� �����带 ����.
//		for(int i = 0; 'a' + i <= 'z'; i++) {
//			System.out.println((char)('a' + i));
//		}
//	}
//
//	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++) {
//			ex.execute(new JavaI1015());
//			//100�� new �ؼ� ������ ��Ű�� ��.
//			// Q. �����带 100�� ����� �����ؼ� �̸��� ������ �ǰ�. �� �𸣰ٴ�.
//		}
//	}
//
//}

//4.
//import java.util.concurrent.*;
//
//public class JavaI1015 {
//	private static int count = 0;
//
//	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService executorService = null;
//		try {
//			executorService = Executors.newSingleThreadExecutor();
//			// run�� �޼ҵ� ���� ����
//			Future<?> future = executorService.submit(() -> {
//
//				for (int i = 0; i < 500; i++)
//					JavaI1015.count++;
//			});
//			// future.get(10, TimeUnit.SECONDS); 10�ʸ� ��ٸ�. �׷��� �� ������.. catch �������� �̵�.
//			System.out.println("future.get() = " + future.get(10, TimeUnit.SECONDS));
//			System.out.println("������");
//
//		} catch (TimeoutException e) {
//			System.out.println("�ð� �� �������� ����");
//		} finally {
//			executorService.shutdown();
//		}
//	}
//}

// >>callable <<
//1.
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//public class JavaI1015 {
//	public static void main(String[] args) throws Exception {
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		JavaI1015 test = new JavaI1015();
//		Future future = executorService.submit(new MyCallable()); //??????????
//		//? �� ������ ����°�?
//		System.out.println("future.get() = " + future.get());
//		executorService.shutdown();
//	}
//	class MyCallable implements Callable {
//		public Object call() throws Exception {
//			System.out.println("Asynchronous Callable");
//			return "Callable Result";
//		}
//	}
//
//}

////2. ��ȯ�� string Ÿ������ ����.
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//public class JavaI1015 implements Callable<String> {
//	public String call() throws Exception { // call�� return Ÿ���� ���ڿ��� ��.
//		return "Callable Result";
//	}
//
//	public static void main(String[] args) throws Exception {
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		Future<String> future = executorService.submit(new JavaI1015());
//		System.out.println("Result = " + future.get());
//		executorService.shutdown();
//	}
//
//}

//Thread Pool
//�����带 1������ �����ϰ�, ����� ���� �����尡 ������ �� �����带 �Ҵ��� ��.
//������ �����带 �ִ� ���� �ƴ϶� max ������.

//1.
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class JavaI1015 implements Runnable {
//	public void run() {
//		unitTask();
//	}
//
//	private void unitTask() {
//		System.out.println(Thread.currentThread().getName() + " 1ȸ�� �� ó��");
//	}
//
//	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		for (int i = 1; i <= 100; i++) {
//			executorService.execute(new JavaI1015());
//		}
//		executorService.shutdown();
//
//	}
//
//}


//2.
//import java.util.concurrent.*;
//
//public class JavaI1015 {
//
//  public static int max(int[] data) throws InterruptedException, ExecutionException {
//    
//    if (data.length == 1) {
//      return data[0];
//    } else if (data.length == 0) {
//      throw new IllegalArgumentException();
//    }
//    
//    // split the job into 2 pieces
////�迭�� 2���� �ɰ��� ���� �ִ��� ���ؼ� �� �߿� ū ���� ��󳻴�
//    FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
//    FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
//    
//    // spawn 2 threads
//    ExecutorService service = Executors.newFixedThreadPool(2);
//
//    Future<Integer> future1 = service.submit(task1);
//    Future<Integer> future2 = service.submit(task2);
//        
//    return Math.max(future1.get(), future2.get());
//  }
//}

import java.util.concurrent.ExecutionException;


import java.util.concurrent.*;

import java.util.concurrent.Callable;

class FindMaxTask implements Callable<Integer> {

  private int[] data;
  private int start;
  private int end;
  
  FindMaxTask(int[] data, int start, int end) {
    this.data = data;
    this.start = start;
    this.end = end;
  }

  public Integer call() {
    int max = Integer.MIN_VALUE;
    for (int i = start; i < end; i++) {
      if (data[i] > max) max = data[i];
    }
    return max;
  }
}


public class MultithreadedMaxFinder {

  public static int max(int[] data) throws InterruptedException, ExecutionException {
    
    if (data.length == 1) {
      return data[0];
    } else if (data.length == 0) {
      throw new IllegalArgumentException();
    }
    
    // split the job into 2 pieces
//�迭�� 2���� �ɰ��� ���� �ִ��� ���ؼ� �� �߿� ū ���� ��󳻴�
    FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
    FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
    
    // spawn 2 threads
    ExecutorService service = Executors.newFixedThreadPool(2);

    Future<Integer> future1 = service.submit(task1);
    Future<Integer> future2 = service.submit(task2);
        
    return Math.max(future1.get(), future2.get());
  }
}


public class JavaI1015 {
	public static void main(String[] args)throws InterruptedException, ExecutionException{
		int[] ints = {2, 11, 7, 3, 13, 5, 17};
		int a = MultithreadedMaxFinder.max(ints);
		System.out.println(a);
	}
}



//���� ������ submit�ؼ� callerable�� �޴� ��.
// inner class�� JavaI1015�� ��ü �ȿ� ���ؾ��ϹǷ�. 
// JavaI1015��ü�� ����� �ű⼭ inner Ŭ������ ��ü�� �������־����.

//1-1.
//class Worker implements Runnable{
//	public Worker() { 
//		Thread maker = Thread.currentThread();
//		System.out.println(maker + " has created " + this); //#maker�� ����ǰ� �ִ� ������
//	}
//	public void run() {
//		for ( int i = 0; i <3; i++ ) {
//			namePrint();
//		}
//	}
//	public void namePrint() {
//		Thread t = Thread.currentThread(); //#���� �����带 ȣ���Ѵ�.
//		System.out.println("namePrint() called by " + t.getName());
//	}
//}
