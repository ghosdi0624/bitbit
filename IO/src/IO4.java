import java.io.*;

//=======================================================================
// text모드로 파일에 저장 !!
//=======================================================================
// --> FileReader : 텍스트 단위로 읽기 메소드 !!
// --> FileWriter : 텍스트 단위로 쓰기 메소드 !!
//=======================================================================


public class IO4 {

	public static void main(String[] args) {

		char ch1 = 'A';
		char ch2 = 65;
		
		try 
		{
			//쓰기
	//		Writer out = new FileWriter("IO4.txt");
	//		out.write(ch1);
	//		out.write(ch2);
	//		out.close();
			// 읽기
			char [] buf = new char[10];
			Reader reader = new FileReader("IO4.txt");
			
			/*
			int c;		
			while((c = reader.read()) != -1)
				System.out.println(c);
			*/
			// 파일에서 읽은 바이트 수 !!
			while(true)
			{int readCnt = reader.read(buf, 0, buf.length);
				
			if(readCnt==-1)
				break;
				for(int i = 0; i<readCnt; i++)
			{
				System.out.print(buf[i]);
			}
			}
			
			reader.close();
			
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

}
