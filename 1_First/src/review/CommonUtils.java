package review;

import java.util.UUID;

public class CommonUtils {

	public static void main(String[] args) {
		
/*		System.out.println(UUID.randomUUID());
		 System.out.println(UUID.randomUUID().toString());
		 System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));*/
		
		String originalFileName = "abc.exe";
		String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		System.out.println(originalFileExtension);
		      
		   
	
	}
}
