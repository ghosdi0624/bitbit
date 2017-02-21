package dev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("develpe.xml");
		
		Develope develope = (Develope)context.getBean("develope");
		develope.coding();

	}

}
