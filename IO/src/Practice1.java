import java.io.*;;

public class Practice1 {

	public static void main(String[] args) {

		OutputStream out = null;
		InputStream in = null;
		
		int num[] = {1,4,-1,88,50};
		byte b[] = {7,51,3,4,1,24};
		
		try {
			out = new FileOutputStream("C:/Test.txt");
			for(int i=0; i<num.length; i++)
				out.write(num[i]);
			
			out.write(b);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		int c;
		try {
			in = new FileInputStream("C:/Test.txt");
			while((c=in.read())!=-1)
			{
				System.out.print(c+" ");
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	
		
	}

}
