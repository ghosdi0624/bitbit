package java1;

class JoinThread extends Thread{
	
	public JoinThread(String name){
		super(name);
	}
	public void run(){
		System.out.println(getName()+" started.");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName()+" ended.");
	}
}

public class ThreadTest7 {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++){
			JoinThread thread = new JoinThread("Thread"+i);
			System.out.println(thread.getName()+" created.");
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("mainThread end....");
	}

}
