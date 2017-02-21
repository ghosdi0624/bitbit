import java.io.*;

public class PracticeIO {

	public static void main(String[] args) throws IOException {
		
		try 
		{
			InputStream input = new FileInputStream("C:\\photo.jpg");
			OutputStream output = new FileOutputStream("photo.jpg");
			input.read();
			
			while(true)
			{
				int data = input.read();
				if(data == -1)
					break;
				output.write(data);
			}
			input.close();
			output.close();
			
			
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	
	}

}
