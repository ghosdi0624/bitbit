import java.io.*;
import java.net.*;

public class ThreadClient {

	public static void main(String[] args) {

		try {
			Socket sock = new Socket("127.0.0.1", 10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;

			while ((line = keyboard.readLine()) != null) {
				if (line.equals("quit"))
					break;
				pw.println(line);
				pw.flush();
				
				System.out.println("server >>> " + br.readLine());

			}
			pw.close();
			br.close();

			sock.close();
		} catch (Exception e) {
			e.getMessage();

		}
	}

}
