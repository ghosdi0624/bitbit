import java.io.File;

// File클래스 ..
// 읽고 쓰는 개념이 아닌 파일 관리 클래스

public class FileClassTest {

	public static void main(String[] args) {

		File f = new File("C:/windows");
		if(f.isFile())
			System.out.println("파일임");
		if(f.isDirectory())
			System.out.println("디렉토리임");
		String[] filenames = f.list();
		
		for(int i=0; i<filenames.length; i++)
		{
			File st = new File(f, filenames[i]);
			System.out.print(filenames[i]);
			System.out.print("파일크기 : "+ st.length()+"\n");
		}
		
	}

}
