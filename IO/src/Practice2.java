import java.io.*;

public class Practice2 {

	public static void main(String[] args) {

		
		OutputStream out = null;
		InputStream in = null;
		
		try {
			out = new FileOutputStream("src/txt.txt");
			for(int i=10; i>0; i--)
				out.write(i);
			in = new FileInputStream("src/txt.txt");
			int c;
			while((c=in.read())!=-1){
				System.out.print(c+" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
		
		
		
	}

}
