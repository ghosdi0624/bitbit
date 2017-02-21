package Practice1125;

import java.util.Calendar;
import java.util.Random;


public class pr7 {

	public static int getRand(int from, int to) {
		Random rand = new Random();
		int num;
		while (true) {
			num = rand.nextInt(from+to);
			if (from < to) {
				if (from < num && to > num)
					return num;
			}
			if (from > to)
				if (from > num && to < num)
					return num;
		}
	}
	
	public static double round(double d, int n){
		d = (Math.round(d*Math.pow(10, n))/Math.pow(10, n));
		return d;
	}
	
	public static String dayCheck(int day){
		
		String s="";
		switch(day){
		case 1: s = "Sunday"; break;
		case 2: s = "Monday";break;
		case 3: s = "Tuesday";break;
		case 4: s = "Wednesday";break;
		case 5: s = "Thursday";break;
		case 6: s = "Friday";break;
		case 7: s = "Saturday";break;
		}
		return s;
	}
	
	public static int salaryNo(Calendar start, Calendar end){
		System.out.println(end.get(Calendar.DAY_OF_YEAR));
		System.out.println(end.get(Calendar.DAY_OF_MONTH));
		System.out.println(end.get(Calendar.DAY_OF_YEAR));
		return 1;
	}

	public static void main(String[] args) {

//		System.out.println(getRand(5,10));
//		System.out.println(round(3.141592,4));
		Calendar cal = Calendar.getInstance();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		System.out.println(cal.get(Calendar.DATE));
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH)+1;
//		int day = cal.get(Calendar.DATE);
		int day_week = cal.get(Calendar.DAY_OF_WEEK);
		String s = dayCheck(day_week);
//		System.out.println(String.format("%d년 %d월 %d일 %s",year, month, day, s));
//		
//		System.out.println("년월일 세팅2....."+cal.getTime());
//		cal.set(Calendar.YEAR, 2015);
//		System.out.println("년월일 세팅2....."+cal.getTime());
//		cal.set(Calendar.DAY_OF_WEEK, 1);
//		System.out.println("년월일 세팅2....."+cal.getTime());
//		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//		System.out.println("년월일 세팅2....."+cal.getTime());
//		
//		for(int i=0; i<12; i++)
//		{
//			int date;
//			cal.set(Calendar.YEAR, 2015);
//			cal.set(Calendar.MONTH, i);
//			cal.set(Calendar.DAY_OF_WEEK, 1);
//			cal.set(Calendar.WEEK_OF_MONTH, 2);
//			if(cal.get(Calendar.DATE)<8){
//				date = cal.get(Calendar.DATE)+7;
//				System.out.println(date+"일");
//			}
//			else{
//				date = cal.get(Calendar.DATE);
//				System.out.println(date+"일");
//			}
//		}
		
//		start.clear();
//		start.set(Calendar.YEAR, 2015);
//		start.set(Calendar.MONTH, 9);
//		start.set(Calendar.DATE, 15);
//		end.clear();
//		end.set(Calendar.YEAR, 2016);
//		end.set(Calendar.MONTH, 1);
//		end.set(Calendar.DATE, 1);
//		int No = salaryNo(start, end);
		
		
		
	}

}
