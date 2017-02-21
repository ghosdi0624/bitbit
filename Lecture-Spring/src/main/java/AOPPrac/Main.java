package AOPPrac;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPPrac.xml");
		
		Human man = context.getBean("man", Human.class);
		
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.print("나이 입력 : ");
			int age = scan.nextInt();
			if(age == 0){
				System.out.println("종료..");
				break;
			}
			man.setAge(age);
		}

	}

}
