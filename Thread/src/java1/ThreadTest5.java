package java1;

class Consumer extends Thread{
	private Buffer basket;
	
	public Consumer(Buffer c){
		basket = c;
	}
	public void run(){
		int value=0;
		for(int i=0; i<10; i++){
			basket.get();
			try {
				sleep((int)(Math.random()*1000));
			} catch (Exception e) {
			}
		}
	}
}

class Producer extends Thread{
	private Buffer basket;
	
	public Producer(Buffer b){
		basket = b;
	}
	public void run(){
		for(int i=0; i<10; i++){
			basket.put(i);
			try {
				sleep((int)(Math.random()*1000));
			} catch (Exception e) {
			}
		}
	}
}

class Buffer{
	private int contents;
	private boolean available = false;
	
	public synchronized void get(){
		while(available == false){
			try {
				wait();
			} catch (InterruptedException e) {
			}}
			System.out.println(contents+"번 공을 소비...");
			available = false;
			notify();		
		
	}
	
	public synchronized void put(int value){
		while(available == true){
			try {
				wait();
			} catch (InterruptedException e) {
			}}
			contents = value;
			System.out.println("생산자 : 생산 "+contents);
			available = true;
			notify();
		
	}
}

public class ThreadTest5 {

	public static void main(String[] args) {

		Buffer c= new Buffer();
		Producer pro = new Producer(c);
		Consumer con = new Consumer(c);
		
		pro.start();
		con.start();
		
		
		
		
		
		
	}

}
