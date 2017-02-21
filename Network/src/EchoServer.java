import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EchoServer {

	public static void main(String[] args) {

		BufferedReader br1 = null;
		Connection conn = null;
		Statement stat1 = null;
		ResultSet rs = null;
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");
			Socket sock = server.accept();

			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " 로 부터 접속하였습니다.");

			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String line = null;
			String s = null;
			String comp = null;
			String noFile = "요청 파일이 존재하지 않음";
			
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			stat1 = conn.createStatement();
			String end = "end";
			while ((line = br.readLine()) != null) {

				int f = 0;
				System.out.println("클라이언트로 부터 전송받은 문자열 : " + line);

				rs = stat1.executeQuery("select test from javanetwork");
				while (rs.next()) {
					comp = rs.getString(1);
					if (line.equals(comp)) {
						br1 = new BufferedReader(new FileReader("C:/" + line + ".txt"));
						while ((s = br1.readLine()) != null) {
							pw.println(s);
							pw.flush();
						}
						pw.println(end);
						pw.flush();
						f++;
						break;
					}
				}
				
				if(f==0){
					pw.println(noFile);
					pw.flush();
				}

			}
			br1.close();
			pw.close();
			br.close();
			sock.close();
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stat1.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
