import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Account{
	private String id;
	private String name;
	private int balance;
	
	public Account(String id, String name){
		this(id, name, 0);
	}
	public Account(String id, String name, int balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setBalance(int money){
		this.balance = money;
	}
	public int getBalance() {
		return balance;
	}
	public int credit(int amount){ //입금
		balance += amount;
		System.out.println(name+"이 "+amount+"원 저금,");
		return balance;
	}
	public int debit(int amount){ //출금
		if(amount<=balance){
			balance -= amount;
			System.out.println(name+"이 "+amount+"원 출금,");
		}
		else
			System.out.println("Amount exceeded balance");
		return balance;
	}
	public int traceferTo(Account another, int amount){
		if(amount <= balance){
			another.balance += amount;
			balance -= amount;
			System.out.println(name+"가 "+another.name+"에게 "+amount+"원 송금,");
		}
		else
			System.out.println("Amount exceeded balance");
		return balance;
	}
	public String toString(){
		return String.format("[id=%s, name=%s, balance=%d]",id, name, balance);
	}
}


public class pr3 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stat1 = null;
		Statement stat2 = null;
		ResultSet rs = null;		
		String driver = "oracle.jdbc.driver.OracleDriver";
		ArrayList<Account> list = new ArrayList<Account>();
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			stat1 = conn.createStatement();
			stat2 = conn.createStatement();
			rs = stat1.executeQuery("select * from account");
			
			while(rs.next()){
				Account account = new Account(rs.getString(1),rs.getString(2),rs.getInt(3));
				System.out.println(account);
				list.add(account);
			}			
			
			list.get(1).traceferTo(list.get(0), 10000);
			list.get(0).credit(300000);
			list.get(2).debit(5000);
			
			stat2.executeUpdate("update account set balance = "+list.get(0).getBalance()+"where name = \'코난\'");
			stat2.executeUpdate("update account set balance = "+list.get(1).getBalance()+"where name = \'장미\'");
			stat2.executeUpdate("update account set balance = "+list.get(2).getBalance()+"where name = \'미란\'");

			rs = stat2.executeQuery("select * from account");
			
			int index = 0;
			while(rs.next()){
				list.get(index).setBalance(rs.getInt(3));
				System.out.print(list.get(index++));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		
//		Account p1 = new Account("01011111111","코난",20000);
//		Account p2 = new Account("01022222222","장미",100000);
//		Account p3 = new Account("01033333333","미란",50000);
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
//		
//		p2.traceferTo(p1, 10000);
//		p1.credit(300000);
//		p3.debit(5000);
//		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
	}

}