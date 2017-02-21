import java.util.Scanner;

class PInfo {
	String name;
	String phoneNo;
	String address;

	public String getName() {
		return name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getAddress() {
		return address;
	}
	public void showNameMin(PInfo[] p)
	{
		PInfo temp = new PInfo();
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < i; j++) {
				if((p[i].name).compareTo(p[j].name)<0){
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}
		System.out.println("이름 : " + p[0].name);
		System.out.println("전화번호 : " + p[0].phoneNo);
		System.out.println("주소 : " + p[0].address);
	}
}

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		PInfo[] p = new PInfo[3];
		PInfo p1 = new PInfo();

		for (int i = 0; i < p.length; i++) {
			p[i] = new PInfo();
			p[i].name = scan.next();
			p[i].phoneNo = scan.next();
			p[i].address = scan.next();
		}		
		p1.showNameMin(p);
	}

}

