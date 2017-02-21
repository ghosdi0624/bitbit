import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {

		Reader fr = null;
		
		try {
			fr = new FileReader("C:/Users/soonil/workspace/21_Collection/src/Collection7.java");
			int c;
			while((c=fr.read())!=-1){
				System.out.print((char)c);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				fr.close();
			} catch (Exception e) {
				System.out.println("입출력 오류");
			}
		}
		
		
		
	}

}
