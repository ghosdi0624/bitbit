package review;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class abcd {

	public static void main(String[] args) {

		try {
			Socket sock = new Socket("127.0.0.1",10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			String id = keyboard.readLine();
			String line = null;
			while((line = keyboard.readLine()) != null){
				pw.println(line);
				pw.flush();
				String str = br.readLine();
				System.out.println("Server >> " + str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
