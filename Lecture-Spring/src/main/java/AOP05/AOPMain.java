package AOP05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aop05.xml");
		
		Person boy = context.getBean("boy", Person.class);
		Person girl = context.getBean("girl", Person.class);
		
		boy.runSomething();
		
	}

}
