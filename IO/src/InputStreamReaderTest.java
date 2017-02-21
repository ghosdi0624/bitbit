import java.io.*;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		
		InputStreamReader ir = null;
		
		try {
			int c;
			ir = new InputStreamReader(new FileInputStream("C:/hangul.txt"), "MS949");
			while((c=ir.read())!=-1){
				System.out.print((char)c+" ");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				ir.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
