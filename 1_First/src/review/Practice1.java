package review;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		double num=0;
		boolean f = true;
		int f2 = 0;
		
		for(int i=0; i<str.length(); i++)
		{
			if(!(str.charAt(i)>='0' && str.charAt(i)<='9')){
				if(str.charAt(i)=='.'){
					f2++;
				}
				if(!(str.charAt(i)=='.') || f2>1){
					num = Double.parseDouble(str.substring(0, i));
					f=false;
					break;					
				}
			}
		}
		if(f)
			num = Double.parseDouble(str.substring(0, str.length()));
		System.out.printf("%.2f",num);		
	}

}
