package java1;

class TimerThread extends Thread{
	int n=0;
	boolean f = false;
	
	public void finish(){
		f = true;
	}
	
	public void run(){
		while(true){
			System.out.println("상속 : "+n);
			n++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(f = true)
				return;
		}
	}
}

class TimerThread1 implements Runnable{
	int n=0;
	
	public void run(){
		while(true){
			System.out.println("인터페이스 : "+n);
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest1 {

	public static void main(String[] args) {

		TimerThread tm = new TimerThread();
		tm.start();
		
		Thread th = new Thread(new TimerThread1());
		th.start();
		
		tm.finish();
		
	}

}
