import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) {

		FileWriter fw = null;
		BufferedWriter bf = null;

		try {
			Socket sock = new Socket("127.0.0.1", 10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			fw = new FileWriter("copy");
			bf = new BufferedWriter(fw);

			String line = null;
			String response = null;
			String end = "end";
			String noFile = "요청 파일이 존재하지 않음";

			while ((line = keyboard.readLine()) != null) {
				if (line.equals("quit"))
					break;
				pw.println(line);
				pw.flush();

				while ((response = br.readLine()) != null) {
					if (response.equals(end)){
						System.out.println("파일 생성 완료");
						break;
					}
					if (response.equals(noFile)) {
						System.out.println(noFile);
						break;
					}
					fw.write(response+"\n");
					fw.flush();
				}

				// while((response = br.readLine())!=null){
				// System.out.println(response);
				// fw.write(response+"\n");
				// fw.flush();
				// }
			}
			pw.close();
			br.close();
			bf.close();
			fw.close();
			sock.close();
		} catch (Exception e) {
			e.getMessage();

		}
	}

}
