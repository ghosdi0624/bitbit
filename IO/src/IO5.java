//	1) C://dog.jpg --> D://dog.jpg : 파일 이동 복사 FileInputStream, FileOutputStream
//	2) --> 메뉴 추가 : 불러오기, 저장
//		BufferedReader	BufferedWriter
//	3) AddrBook 주소록 --> ArrayList 저장된 객체 : 저장, 불러오기 !!

import java.io.*;
import java.util.Scanner;

//========================================================================
// 문자열 단위 입출력 !!
//========================================================================
// BufferedReader
// BufferedWriter
//========================================================================

public class IO5 {

	public static void main(String[] args) throws IOException {
		// 사용자가 x를 입력할때까지 문자열을 입력받아서 파일에 저장 !!
		/*
		BufferedWriter out = new BufferedWriter(new FileWriter("IO5.txt"));
			
		String msg = "";
		Scanner scan = new Scanner(System.in);
		while(!msg.equals("x"))
		{
			System.out.println("input : ");
			msg = scan.nextLine();
			out.write(msg);
			out.newLine();	// 개행 문자
		}
		out.close();
		*/
		
		BufferedReader in = new BufferedReader(new FileReader("IO5.txt"));
		
		String msg;
		
		while(true)
		{
			msg = in.readLine();
			if(msg == null)
				break;
			System.out.println(msg);
		}
	}

}
