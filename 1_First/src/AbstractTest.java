abstract class Calculator {
	public abstract int add(int a, int b);

	public abstract int sub(int a, int b);

	public abstract double average(int[] a);
}

class GoodCalc extends Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public double average(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}
}

public class AbstractTest {

	public static void main(String[] args) {

		Calculator c = new GoodCalc();
		int[] arr = { 7, 8, 9 };

		System.out.println(c.add(6, 4));
		System.out.println(c.sub(6, 4));
		System.out.println(c.average(arr));

	}

}
