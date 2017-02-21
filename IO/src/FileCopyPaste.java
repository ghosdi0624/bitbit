import java.io.*;

public class FileCopyPaste {

	public static void main(String[] args) {
		
		// FileReader, FileWriter는 문자만 다루기 때문에 이미지 copy,paste에는 부적절...
		// Buffered는 한줄씩 읽어오기... 속도가 빠름
		
		InputStream in = null;  
		OutputStream fw = null;
		
		int c;
		try {
			in = new FileInputStream("C:/picture.PNG");
			fw = new FileOutputStream("src/photo.JPG");
			while((c=in.read())!=-1){
				fw.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
