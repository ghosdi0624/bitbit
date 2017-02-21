import java.sql.*;

// 테이블 이름 : emp
public class Practice {

	public static void main(String[] args) {
			
		Connection conn = null;
		Statement stat1 = null;
		Statement stat2 = null;
		ResultSet rs = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			stat1 = conn.createStatement();
			stat2 = conn.createStatement();
//			String str = "개발";
//			for(int i=199; i<206; i++){
//				stat.executeUpdate("update emp set increasedPayroll=salary+salary*0.25 where empid="+i);//25% 인상
//				stat.executeUpdate("update emp set depPay=salary+salary*0.123 where dep =\'"+str+"\'"); //12.3%인상
//				stat.executeUpdate("update emp set depPay=salary where dep not in \'개발\'");
//			}
			rs = stat1.executeQuery("select * from emp order by increasedPayroll DESC");	
			
			while(rs.next()){
				stat2.executeUpdate("update emp set increasedPayroll=salary+salary*0.25");//25% 인상
			}
//			rs = stat.executeQuery("select empid, empName, salary, dep from emp where salary = (select min(salary) from emp)");
//			rs = stat.executeQuery("select empName,dep,salary from emp where salary > (select avg(salary) from emp)");
			System.out.print("empid / empName / salary / dep / hireDate / manid / newDate / increasedPayroll / increasedPay / depPay");
			System.out.println();
			rs = stat1.executeQuery("select * from emp order by increasedPayroll DESC");	
			while (rs.next()) {
				System.out.print(" " + rs.getString(1));
				System.out.printf(" %7s", rs.getString(2));
				System.out.printf(" %16d", rs.getInt(3));
				System.out.printf(" %5s", rs.getString(4));
				System.out.printf("      %s", rs.getString(5));
				System.out.printf("     %3d", rs.getInt(6));
				System.out.printf(" %10s", rs.getString(7));
				System.out.printf("    %10d ", rs.getInt(8));
				System.out.print("           " + rs.getString(9));
				System.out.print("        " + rs.getString(10));

				System.out.println();
			}
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				stat1.close();
				stat2.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
