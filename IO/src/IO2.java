import java.io.*;

//============================================================================
// FileOutputStream
//============================================================================



public class IO2 {
	
	public static void main(String[] args)
	{
		try 
		{
			byte [] bytes = new byte[]{65,65,65,65,65};	// --> 아스키 코드로 입력됨
			
			OutputStream os = new FileOutputStream("bit.txt"); 
			// 1byte씩 파일에 저장 !!
			/*
			for (byte b : bytes)
			{
				os.write(b);
			}
			*/
			//byte 배열을 한번에 저장
			os.write(bytes);
			
			os.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
