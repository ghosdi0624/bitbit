package java1;

import java.util.Random;

class Thread11 extends Thread {

	Random rand = new Random();

	public Thread11(String name) {
		super(name);
	}

	public void run() {

		int sum = 0;
		int target = 100;
		while (true) {

			sum += (rand.nextInt(10) + 1);
			if (sum > 100) {
				sum = target;
				System.out.print(getName() + "개표율 : " + sum + " ");
				for (int i = 0; i < sum; i++) {
					System.out.print("*");
				}
				System.out.println();
				break;
			} else if (sum == target) {
				System.out.print(getName() + "개표율 : " + sum + " ");
				for (int i = 0; i < sum; i++) {
					System.out.print("*");
				}
				System.out.println();
				break;

			} else {
				System.out.print(getName() + "개표율 : " + sum + " ");
				for (int i = 0; i < sum; i++) {

					System.out.print("*");

					System.out.println();
				}
			}
		}

	}
}

public class ThreadTest4 {

	public static void main(String[] args) {

		Thread11 t1 = new Thread11("1개표구");
		Thread11 t2 = new Thread11("2개표구");
		Thread11 t3 = new Thread11("3개표구");

		t1.setPriority(t1.MAX_PRIORITY);
		t2.setPriority(t2.NORM_PRIORITY);
		t3.setPriority(t3.MIN_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
	}

}
