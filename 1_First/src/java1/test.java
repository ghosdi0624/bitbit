package java1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test {

	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd" ); 
		Date currentTime = new Date ( ); 
		String today = formatter.format ( currentTime ); 
		System.out.println ( today );

	}

}
