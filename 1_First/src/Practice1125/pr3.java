package Practice1125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		
		Account p1 = new Account("01011111111","코난",20000);
		Account p2 = new Account("01022222222","장미",100000);
		Account p3 = new Account("01033333333","미란",50000);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		p2.traceferTo(p1, 10000);
		p1.credit(300000);
		p3.debit(5000);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
