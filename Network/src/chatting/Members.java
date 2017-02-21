package chatting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Members {
	String id = null;
	String pw = null;
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	final String driver = "oracle.jdbc.driver.OracleDriver";

	public void newMember(String id, String pw) {

		this.id = id;
		this.pw = pw;
		try {
			Class.forName(driver); // 드라이버 지정......
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			stat = conn.createStatement();
			rs = stat.executeQuery("insert into members values (\'" + id + "\',\'" + pw + "\')");
			rs = stat.executeQuery("commit");

			System.out.println("회원가입이 완료 되었습니다.");
		} catch (Exception e) {
			System.out.println("회원 ID가 존재합니다.");
		}
	}

	public void Login(String id, String pw) {

		this.id = id;
		this.pw = pw;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from members where chatId = '" + this.id + "'");

			rs.next();
			if (rs.getString(2).equals(this.pw)) {
				System.out.println("인증에 성공하였습니다.");
				Client c1 = new Client(this.id, this.pw);
				c1.getClient();
			} else{
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
			}
			
			// rs.close();
			// stat.close();
			// conn.close();

		} catch (Exception e) {
			System.out.println("ID가 존재하지 않습니다.");
		}
	}
}