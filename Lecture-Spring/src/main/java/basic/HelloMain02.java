package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloMain02 {

	public static void main(String[] args) {
		
		String xmlLocation = "classpath:beanContainer.xml";
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("beanContainer.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext(xmlLocation);
		
		Hello obj = (Hello)context.getBean("hello");
		obj.printMsg();
		
		Hello obj2 = (Hello)context.getBean("hello2");
		obj2.printMsg();
		
	}

}
