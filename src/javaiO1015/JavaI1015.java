package JavaIO1015;

/*
 * 지난시간에 뭐 했는지 정리 좀 해 보자.
 * 스레드를 만들어서 실행시키는 두 가지 방법이 있엇다.
 * new thread시에 runnable 객체를 주든지.
 * 
 * 
 * 스레드 : 작업처리를 스레드는 여러군데에서 작업이 이루어 지기 때문에. 
 * 	스레드를 만들 때 
 */

// 1.
//	public static void main(String[] args) {
//		Worker w = new Worker();
//		Thread t = new Thread(w, "Able"); //#이름을 줌
//		t.start();
//		for ( int i = 0; i < 3; i++ ) w.namePrint(); //#메인 스레드도 3번 호출.
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
//		System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
//		}

////2-2 : 각각의 스레드가 일을 하나씩 처리.
//public class JavaI1015 implements Runnable {
//	public void run() {
//		unitTask();
//	}
//
//	private void unitTask() {
//		System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
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
//		//[문제] a 부터 z 까지 출력하는 스레드를 생성.
//		for(int i = 0; 'a' + i <= 'z'; i++) {
//			System.out.println((char)('a' + i));
//		}
//	}
//
//	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++) {
//			ex.execute(new JavaI1015());
//			//100번 new 해서 실행을 시키는 것.
//			// Q. 스레드를 100번 만들고 제거해서 이름이 동일한 건가. 잘 모르겟다.
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
//			// run을 메소드 내에 넣음
//			Future<?> future = executorService.submit(() -> {
//
//				for (int i = 0; i < 500; i++)
//					JavaI1015.count++;
//			});
//			// future.get(10, TimeUnit.SECONDS); 10초를 기다림. 그래도 못 얻으면.. catch 구문으로 이동.
//			System.out.println("future.get() = " + future.get(10, TimeUnit.SECONDS));
//			System.out.println("도달함");
//
//		} catch (TimeoutException e) {
//			System.out.println("시간 내 도달하지 못함");
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
//		//? 왜 오류가 생기는가?
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

////2. 반환을 string 타입으로 고정.
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//public class JavaI1015 implements Callable<String> {
//	public String call() throws Exception { // call의 return 타입을 문자열로 함.
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
//스레드를 1만개만 생성하고, 사용을 다한 스레드가 나왔을 때 스레드를 할당해 줌.
//무작정 스레드를 주는 것이 아니라 max 지정함.

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
//		System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
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
////배열을 2개로 쪼개서 각각 최댓값을 구해서 둘 중에 큰 것을 골라내는
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
//배열을 2개로 쪼개서 각각 최댓값을 구해서 둘 중에 큰 것을 골라내는
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



//오늘 과제는 submit해서 callerable로 받는 것.
// inner class는 JavaI1015의 객체 안에 속해야하므로. 
// JavaI1015객체를 만들고 거기서 inner 클래스의 객체를 생성해주어야함.

//1-1.
//class Worker implements Runnable{
//	public Worker() { 
//		Thread maker = Thread.currentThread();
//		System.out.println(maker + " has created " + this); //#maker가 실행되고 있는 스레드
//	}
//	public void run() {
//		for ( int i = 0; i <3; i++ ) {
//			namePrint();
//		}
//	}
//	public void namePrint() {
//		Thread t = Thread.currentThread(); //#현재 스레드를 호출한다.
//		System.out.println("namePrint() called by " + t.getName());
//	}
//}
