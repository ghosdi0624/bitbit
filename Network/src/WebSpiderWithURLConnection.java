import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebSpiderWithURLConnection {

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
		
		FileOutputStream fos = null;
		
		try {
			URLConnection urlcon = url.openConnection();
			String contentType = urlcon.getContentType();
			long d1 = urlcon.getDate();
			Date d = new Date(d1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			String sdate = format.format(d);
			System.out.println("Content Type : "+contentType);
			System.out.println("읽어온 시간 : "+sdate);
			
			InputStream in = urlcon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "euc-kr"));
			fos = new FileOutputStream(args[1]);
			PrintWriter fw = new PrintWriter(new OutputStreamWriter(fos, "euc-kr"));
			System.out.println("읽어오기 시작합니다.");
			String line = null;
			while((line = br.readLine())!=null){
				fw.write(line+"\n");
				fw.flush();
			}
			System.out.println(args[1]+" 파일에 모두 저장하였습니다.");
			
		} catch (IOException e) {
			System.out.println("인터넷 연결안됨");
		}
		
		
	}

}
