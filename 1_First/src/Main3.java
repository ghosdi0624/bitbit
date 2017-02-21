import java.util.Random;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		// int[][] arr = new int[5][5];
		int data;
		int[] arr = new int[25];
		// 중복제거
		LABEL: for (int i = 0; i < arr.length; i++) {
			data = rand.nextInt(25) + 1;
			arr[i] = data;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					continue LABEL;
				}
			}
		}
		// 별표 바꾸기

		// 출력
		int cnt = 0;
		while (true) {
			System.out.print("숫자 입력 : ");
			int num = scan.nextInt();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == num)
					arr[i] = 100;
				if (arr[i] == 100) {
					{
						System.out.printf(" * ");
					}
				} else {
					System.out.printf("%2d ", arr[i]);
				}
				if ((i + 1) % 5 == 0)
					System.out.println("");
			}
		}

	}

}
