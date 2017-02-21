import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

public class WebSpider {

	public static void main(String[] args) {

		if(args.length != 2){
			System.out.println("args 잘못입력");
			System.exit(1);
		}
		
		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (Exception e) {
			System.out.println("잘못된 URL입니다.");
			System.exit(1);
		}
		
		FileOutputStream out = null;
		
		
		try {
			InputStream in  = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
			out = new FileOutputStream(args[1]);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
			String line = null;
			System.out.println("읽어오기 시작합니다");
			
			while((line = br.readLine()) != null){
				pw.write(line+"\n");
				pw.flush();
			}
			System.out.println(args[1]+" 파일에 모두 저장하였습니다");
// ================================================================================			
			InputStreamReader in1 = new InputStreamReader(new FileInputStream("abcde"));
			br = new BufferedReader(in1);
			
			line = null;
			String find = null;
			String start = "<title>";
			String end = "</title>";
			while((line = br.readLine())!=null){
				if(line.indexOf(start)==0){
				find = line.substring(start.length(), line.length()-end.length());	
				System.out.println(start+" 와 "+end+" 사이에 있는 문자는 : "+find);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

}
