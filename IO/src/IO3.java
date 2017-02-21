import java.io.*;

// 기본 타입의 입출력 (int, double)
//	--> 필터 스트림을 이용 !!
//	--> 


public class IO3 {

	public static void main(String[] args) throws IOException {
		
		
		int data = 4885;
		OutputStream os = new FileOutputStream("IO3.lop");
		// 4바이트, 8바이트의 타입을 저장 !!
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeInt(data);
		dos.close();
		
		//=============================================================
		// 뷰어 : 파일에 저장된 데이타를 읽어서 보여주기 !!
		//=============================================================
		InputStream is = new FileInputStream("IO3.lop");
		DataInputStream dis = new DataInputStream(is);
		data = 0;
		data = dis.readInt();
		
		System.out.print("read : " + data);
		
		
		
	}

}
