import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class ChatThread extends Thread {

	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap hm;
	private boolean initFlag = false;

	public ChatThread(Socket sock, HashMap hm) {
		this.sock = sock;
		this.hm = hm;
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			id = br.readLine();
			broadcast(id + "님이 접속하였습니다.");
			System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");
			synchronized (hm) {
				hm.put(this.id, pw);
			}
			initFlag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.equals("quit"))
					break;
				if (line.indexOf("/to ") == 0)
					sendmsg(line);
				else
					broadcast(id + " : " + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			synchronized (hm) {
				hm.remove(id);
			}
			broadcast(id + "님이 접속 종료 하였습니다.");
			try {
				if (sock != null)
					sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendmsg(String msg) {
		int start = msg.indexOf(" ") + 1;
		int end = msg.indexOf(" ", start);
		if (end != -1) {
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end + 1);
			Object obj = hm.get(to);
			if (obj != null) {
				PrintWriter pw = (PrintWriter) obj;
				pw.println(id + "님이 귓속말을 보냈습니다. : " + msg2);
				pw.flush();
			}
		}
	}

	public void broadcast(String msg) {
		synchronized (hm) {
			Collection collection = hm.values();
			Iterator iter = collection.iterator();
			while (iter.hasNext()) {
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}
}

public class ChatServer {

	public static void main(String[] args) {

	
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");
			HashMap hm = new HashMap();
			while (true) {
				Socket sock1 = server.accept();
				ChatThread chatthread = new ChatThread(sock1, hm);
				chatthread.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
