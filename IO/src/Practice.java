import java.io.*;

public class Practice {

	public static void main(String[] args) {

//		InputStream in = new FileInputStream("C:\\a.txt");
//		OutputStream out = new FileOutputStream("C:\\b.txt");
		
		InputStream in = null;
		int a;
		
		try {
			in = new FileInputStream("src/IO1.java");
			while((a=in.read()) != -1){
				System.out.print((char)a);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

		
		
		
		
	}

}
