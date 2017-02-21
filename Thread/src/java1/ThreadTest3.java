package java1;

class PriorityThread extends Thread{
	public PriorityThread(String name){
		super(name);
	}
	public void run(){
		for(int i=0; i<50; i++){
			System.out.println(getName()+":"+i+"번째");
		}
	}
}

public class ThreadTest3 {

	public static void main(String[] args) {

		PriorityThread p1 = new PriorityThread("제일높은 스레드");
		PriorityThread p2 = new PriorityThread("중간 스레드");
		PriorityThread p3 = new PriorityThread("제일낮은 스레드");
		
		p1.setPriority(p1.MAX_PRIORITY);
		p2.setPriority(p2.NORM_PRIORITY);
		p3.setPriority(p3.MIN_PRIORITY);
		
		p1.start();
		p2.start();
		p3.start();
		
	}

}
