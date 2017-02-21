package review;

import java.io.*;
import java.net.*;

class Thre extends Thread{
	Socket sock = null;
	
	public Thre(Socket sock){
		this.sock = sock;
	}
	
	public void run(){
		try {
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			String line = null;
			while((line = br.readLine()) != null){
				pw.println(line);
				pw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class abc {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");
			
			while(true){
				Socket sock = server.accept();
				Thre th = new Thre(sock);
				th.start();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
