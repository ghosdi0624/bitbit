import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		
		Calendar cal = Calendar.getInstance();
		
		
		
		int w = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(w);
		
/*		int last = cal.getActualMaximum(Calendar.DATE);
		System.out.println(w);
		System.out.println(last);*/
/*		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		
		int year = 2017;
		int month = 2;
		int day = 27;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		String time = df.format(cal.getTime());
		System.out.println(time);
		
		cal.add(Calendar.DATE, 5);
		time = df.format(cal.getTime());
		System.out.println(time);
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		
		start.set(2012,2,12);
		
		System.out.println(start.getTime());
		end.set(2012,2,28);
		
		long d1 = start.getTime().getTime();
		long d2 = end.getTime().getTime();
			
		int days =(int)((d2-d1)/(1000*60*60*24));*/
		

		
		

	}

}
