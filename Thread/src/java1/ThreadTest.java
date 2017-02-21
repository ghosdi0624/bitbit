package java1;

import java.util.Scanner;

class Sum {
	int num = 0;
	boolean f = false;

	public void setNum(int num) {
		synchronized (this) {
			if (f == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.num = num;
			notify();
		}
	}

	public int getNum() {
		int returnNum = 0;
		synchronized (this) {
			if (f == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			returnNum = num;
			f = false;
			notify();
		}
		return returnNum;
	}
}

class ThreadTest10 extends Thread {
	int intSum = 0;
	Sum sum;

	public ThreadTest10(Sum s) {
		this.sum = s;
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			intSum += sum.getNum();
		}

		System.out.println("입력된 숫자의 합 : " + intSum);
	}
}

public class ThreadTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Sum sum = new Sum();
		ThreadTest10 s1 = new ThreadTest10(sum);

		s1.start();
		
		System.out.println("5개 정수 입력..");
		for (int i = 0; i < 5; i++) {
			System.out.print("입력 >> ");
			int scanNum = scan.nextInt();
			sum.setNum(scanNum);
		}

		try {
			s1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		scan.close();
	}

}
