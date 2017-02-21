package review;

import java.util.Scanner;

/*한 개의 문자열을 입력받아서 최초 숫자 부분을 실수로 변환한 후 반올림하여 소수 둘째자리까지 출력하는 프로그램을 작성하시오.

ex) 22.4&34 -> 22.40
7@888@88 -> 7.00
22..1@2@ -> 22.00
3 -> 3.00

1. 어떤식으로 풀껀지 대략적인 설명
2. 코드
3. 걸린 시간 
11/22 자정까지*/

public class Review {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = "12.as2";
		int[] num = null;
		int sum = 0;
		
		System.out.println(str.substring(0, 0));
		
		for(int i=0; i<str.length(); i++)
		{
			num[i] = Integer.parseInt(str.substring(i, i+1));
			if(num[i]>0){
				
			}
		}
		
		
	}

}
