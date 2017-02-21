import java.io.*;

public class BufferedTest {

	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader("C:/AAA.txt");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("C:/BBB.txt");
			bw = new BufferedWriter(fw);
			
			String s;
			while((s=br.readLine())!=null){
				bw.write(s);
				bw.newLine();
				System.out.println(s);
			}
			bw.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
