package java1;

import java.util.Random;

class Slot {
	Random rand = new Random();
	int num;

	public int getNum() {
		num = rand.nextInt(10);
		return num;
	}
}

class Num1 extends Thread {

	Random rand = new Random();
	Slot slot = new Slot();
	boolean f = true;
	int num;

	public void finish() {
		f = false;
	}

	public void run() {

		while (true) {
			
			num = rand.nextInt(10);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
			//System.out.println(slot.getNum());
			if (f = false)
				break;
		}
	}

	public int getNum() {
		return num;
	}
}

public class ThreadTest6 {

	public static void main(String[] args) {

		Num1 num1 = new Num1();
		Num1 num2 = new Num1();
		Num1 num3 = new Num1();

		num1.start();
		num2.start();
		num3.start();
		int n1, n2, n3;
		boolean flag = true;

		
		while (flag) {
			
			n1 = num1.getNum();
			n2 = num2.getNum();
			n3 = num3.getNum();
			System.out.println(n1 + "" + n2 + "" + n3);
			if (n1 == n2 && n2 == n3) {
				System.out.println("´çÃ·..");
				flag = false;
			}
			
		}
	}

}
