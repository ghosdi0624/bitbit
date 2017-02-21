package Practice1125;

import java.util.Scanner;

class InvoiceItem{
	private String id;
	private String desc;
	private int qty;
	private double unitPrice;
	
	public InvoiceItem(String id, String desc, int qty, double unitPrice){
		this.id = id;
		this.desc = desc;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public double getTotal(){
		return unitPrice*qty;
	}
	
	public String toString(){
		return String.format("InvoiceItem[id=%s, desc=%s, qty=%d, unitPrice=%f 의 구매총액은 %.1f]",id,desc,qty,unitPrice,getTotal());
	}
}

public class pr2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		InvoiceItem[] inv = new InvoiceItem[3];
		String id[] = new String[3];
		String desc[] = new String[3];
		int qty[] = new int[3];
		double unitPrice[] = new double[3];
		
		for(int i=0; i<inv.length; i++){
			id[i] = scan.next();
			desc[i] = scan.next();
			qty[i] = scan.nextInt();
			unitPrice[i] = scan.nextDouble();
			inv[i] = new InvoiceItem(id[i], desc[i], qty[i], unitPrice[i]);
			System.out.println((i+1)+"번째 입력완료");
		}
		for(int i=0; i<inv.length; i++){
			System.out.println(inv[i]);
		}
		
		
	}

}
