import java.util.Random;
import java.util.Scanner;

class Performance
{
	String[] arr;
	int num;
	int total;
	int max;
	
	public Performance(int max)
	{
		num = 0;
		total = 0;
		this.max=max;
		arr = new String[max];
		System.out.println("총 좌석 수..");
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = "O";
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	public void curView()
	{
		System.out.println("현재 예약 현황 ...");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println("");
		
	}
	public void reserve(int num)
	{
		if((total+num)>this.max)
		{
			System.out.println("잔여 좌석이 요청한 예약인원보다 적습니다..");
			return;
		}
		for(int i=total; i<total+num; i++)
			arr[i] = "X";
		total += num;
	}
}

public class Main2 {
	
	public static void main(String[] args) {

		Performance p1 = new Performance(20);
		p1.reserve(3);
		p1.reserve(15);
		p1.reserve(3);
		p1.curView();
		
		
		
//		int[] arr = new int[20];
//		Random rand = new Random();
//		int odd = 0;
//		int even = 0;
//		
//		for(int i=0; i<arr.length; i++)
//			arr[i]=(Math.abs(rand.nextInt()%101));
//		
//		for(int i=0; i<arr.length; i++)
//		{
//			if(arr[i]%2==0)
//				even+=arr[i];
//			else
//				odd+=arr[i];
//		}
//		System.out.println("짝수 합 : "+even);
//		System.out.println("홀수 합 : "+odd);
		
//		Scanner scan = new Scanner(System.in);
//		int[] arr = new int[10];
//		int cnt=0;
//		
//		for(int i=0;;i++)
//		{
//			arr[i]=scan.nextInt();
//			if(arr[i]%2==0)
//			{
//				cnt++;
//				if(cnt==(arr.length))
//					break;
//			}
//			else
//				i--;
//		}
//		for(int i=0; i<arr.length; i++)
//			System.out.println(arr[i]);
		
		
			
			
		
	}

}
