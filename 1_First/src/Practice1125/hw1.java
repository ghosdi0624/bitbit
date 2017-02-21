package Practice1125;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

class Customer {
	private String name;		// 고객 이름
	private boolean member;  	// 회원 여부
	private String memberType;	// 회원 등급

	public Customer(String name) {
		this.name = name;
		this.member = false;
		this.memberType = "walkIn";
	}
	public boolean isMember() {
		return member;
	}
	public void setMember(boolean member) {
		this.member = member;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getName() {
		return name;
	}
	public String toString(){
		return "Customer[name="+this.getName()+", member="+this.isMember()+", memberType="+this.getMemberType()+"]";
	}
}

class Visit {
	private Customer customer;
	private Calendar date;
	private double serviceExpense;		// 서비스 제공받음
	private double productExpense;		// 물품 구매
	
	public Visit(Customer customer, Calendar date){
		this.customer = customer;
		this.date = date;
		this.serviceExpense = 0;
		this.productExpense = 0;
	}
	public double getServiceExpense() {
		System.out.println(customer.getName()+"님이 "+this.serviceExpense+"원의 서비스를 제공받았음..");
		return serviceExpense;
	}
	public void setServiceExpense(double serviceExpense) {
		this.serviceExpense = serviceExpense;
	}
	public double getProductExpense() {
		System.out.println(customer.getName()+"님이 "+this.productExpense+"원의 물품을 구매했음..");
		return productExpense;
	}
	public void setProductExpense(double productExpense) {
		this.productExpense = productExpense;	
	}
	public double getTotalExpense(){
		String str = Boolean.toString(customer.isMember());
		return productExpense*DiscountRate.getProductDiscountRate(str)
				+serviceExpense*DiscountRate.getServiceDiscountRate(customer.getMemberType());
	}
	public String toString(){
		Random rand = new Random();
		int day = rand.nextInt(31)+1;
		return String.format("[%d/%d/%d]%s%.1f",date.get(Calendar.YEAR),date.get(Calendar.MONTH),day,
				customer.toString(),this.getTotalExpense());
	}
		
}

class DiscountRate {
	public static double serviceDiscountPremium = 0.2;
	public static double serviceDiscountGold = 0.15;
	public static double serviceDiscountSilver = 0.1;
	public static double productDiscountPremium = 0.1;
	public static double productDiscountGold = 0.1;
	public static double productDiscountSilver = 0.1;
	
	public static double getServiceDiscountRate(String type){
		if(type.compareTo("Premium")==0)
			return 1-serviceDiscountPremium;
		if(type.compareTo("Gold")==0)
			return 1-serviceDiscountGold;
		if(type.compareTo("Silver")==0)
			return 1-serviceDiscountSilver;
		return 1;
	}
	public static double getProductDiscountRate(String type){
		boolean f = Boolean.parseBoolean(type);
		if(f)
			return 1-productDiscountSilver;
		return 1;
	}
	
}

public class hw1 {

	public static void main(String[] args) {

		ArrayList<Visit> arr = new ArrayList<Visit>();
		Calendar cal= Calendar.getInstance();
		Random rand = new Random();
		cal.set(Calendar.YEAR, 2016);
		cal.set(Calendar.MONTH, 8);
		
		Visit v;
		Customer c1;
		Scanner scan = new Scanner(System.in);
		String name;
		boolean b = false;
		String type;
		
		for(int i=0; i<2; i++){
			System.out.print("이름 : ");
			name = scan.next();
			c1 = new Customer(name);
			System.out.print("멤버여부(true or false) : ");
			b = scan.nextBoolean();
			c1.setMember(b);
			if(c1.isMember()){
				System.out.print("멤버타입(Premium, Gold, Silver) : ");
				type = scan.next();
				c1.setMemberType(type);
			}
			v = new Visit(c1, cal);
			v.setProductExpense(rand.nextInt(500000));
			v.setServiceExpense(rand.nextInt(50000));
			arr.add(v);			
		}
		scan.close();
		for(int i=0; i<arr.size(); i++){
			arr.get(i).getProductExpense();
			arr.get(i).getServiceExpense();
			System.out.println(arr.get(i));
		}
		
	}

}
