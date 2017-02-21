import java.util.Arrays;
import java.util.Scanner;

class PersonInfo {
	String name;
	int height;
	double weight;

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	public void showWeightOrder(PersonInfo[] p) {
		PersonInfo temp = new PersonInfo();
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < i; j++) {
				if (p[i].weight > p[j].weight) {
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].name + " " + p[i].height + " " + p[i].weight);
		}
	}
	public void showNameOrder(PersonInfo[] p)
	{
		PersonInfo temp = new PersonInfo();
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((p[i].name).compareTo(p[j].name) < 0) {
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].name + " " + p[i].height + " " + p[i].weight);
		}
		
	}

}

public class temp {

	public static void temp(String[] args) {

		Scanner scan = new Scanner(System.in);
		PersonInfo[] p = new PersonInfo[5];
		PersonInfo p1 = new PersonInfo();

		for (int i = 0; i < p.length; i++) {
			p[i] = new PersonInfo();
			p[i].name = scan.next();
			p[i].height = scan.nextInt();
			p[i].weight = scan.nextDouble();
		}
		System.out.println("이름순");
		p1.showNameOrder(p);
		System.out.println("");
		System.out.println("몸무게순");
		p1.showWeightOrder(p);

		
	}

}
