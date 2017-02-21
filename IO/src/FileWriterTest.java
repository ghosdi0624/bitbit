import java.io.*;

public class FileWriterTest {

	public static void main(String[] args) {

		InputStreamReader in = null;
		FileWriter fw = null;
		
		try {
			int c;
			in = new InputStreamReader(System.in);
			fw = new FileWriter("C:/AAA.txt");
			while((c=in.read())!=-1){
				fw.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
