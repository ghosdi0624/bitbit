import java.io.*;
import java.net.*;

class MultiThread extends Thread {

	private Socket sock;

	public MultiThread(Socket sock) {
		this.sock = sock;
	}

	public void run() {

		try {
			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " 로 부터 접속하였습니다.");

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;

			while ((line = br.readLine()) != null) {

				System.out.println("클라이언트로 부터 전송받은 문자열 : " + line);
				pw.println(line);
				pw.flush();
			}

			pw.close();
			br.close();
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

public class ThreadServer {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");

			while (true) {
				Socket sock = server.accept();
				MultiThread mt = new MultiThread(sock);
				mt.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
