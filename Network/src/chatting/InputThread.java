package chatting;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class InputThread extends Thread {
	private Socket sock = null;
	private BufferedReader br = null;

	public InputThread(Socket sock, BufferedReader br) {
		this.sock = sock;
		this.br = br;
	}

	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
			}
			try {
				if (sock != null)
					sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

