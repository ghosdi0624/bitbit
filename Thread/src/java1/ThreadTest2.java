package java1;

class Thread1 extends Thread {
	int n = 0;
	public void run(){
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("현재 스레드 이름 = "+name);
		System.out.println("현재 스레드 ID = "+id);
		System.out.println("현재 스레드 우선순위 값 = "+priority);
		System.out.println("현재 스레드 상태= "+s);
	}
}

public class ThreadTest2 {

	public static void main(String[] args) {

		Thread1 th = new Thread1();
		
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("현재 스레드 이름 = "+name);
		System.out.println("현재 스레드 ID = "+id);
		System.out.println("현재 스레드 우선순위 값 = "+priority);
		System.out.println("현재 스레드 상태= "+s);
		
		th.start();
		
	}

}
