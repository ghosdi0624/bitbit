import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// IO
//============================================================================
// Input Output --> 입출력 !!
//	--> 화면 입출력 !! --> out.println	Scanner
//	--> 하드디스크, 네트워크, 프린터, 스피커
//============================================================================
// 스트림 (stream)
//	--> 데이타의 흐름, 데이타가 이동하기 위한 통로
//	--> 입력스트림 (Input Stream)
//	--> 출력스트림 (Output Stream)
//============================================================================
//			 InputStream 	// 모든 입력 스트림의 부모클래스
//				read : 스트림을 통해 데이타를 읽어오는 메소드 !!
//				close : 스트림을 닫을때 사용 !!
//			 /			\
//	FileInputStream  GDIInputStream
//============================================================================
//			OutputStream
//				write : 스트림에 데이타를 쓰기 !!
//				close : 스트림을 닫을때 사용 !!
//		   /
//	FileOutputStream : 파일에 쓰기 작업 클래스 !!



public class IO1 {

	public static void main(String[] args)
	{
		// 기본적인 파일 읽기 !!
		
		try
		{
			InputStream input = new FileInputStream("C:\\AAA.txt");
			
			while(true)
			{
				char b =(char) input.read();
				if(b==-1)
					break;
				System.out.print((char)b);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

}








