import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet jobs = null;
		
		try {
			// 오라클 드라이버를 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이타 베이스에 접속
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			// Statement object를 생성
			stmt = conn.createStatement();
			// ResultSet을 얻기위해 SQL query를 실행
// 추가		stmt.executeUpdate("insert into student values(\'홍순일\',\'영문과\',\'5555555\')");
// 수정		stmt.executeUpdate("update student set id=\'4444444\' where name=\'노애리\'");
// 삭제		stmt.executeUpdate("delete from student where name=\'홍순일\'");
			
			rs = stmt.executeQuery("select * from student"); // table이름
			int count = 0;
//			while(rs.next()){
//				System.out.print(++count);
//				System.out.print(" "+rs.getString(1));
//				System.out.print(" "+rs.getString(2));
//				System.out.print(" "+rs.getString(3));
//				System.out.println();
//			}	
			jobs = stmt.executeQuery("select * from jobs");
			while(jobs.next()){
				System.out.print("ID="+jobs.getString(1));
				System.out.print("\tTiTle="+jobs.getString(2));
				System.out.print("\tMinSal="+jobs.getInt(3));
				System.out.print("\tMaxSal="+jobs.getInt(4));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드에러");
		}
		catch (SQLException e) {
			e.printStackTrace(); // DB 연결오류
		}
		
		
		
	}

}
