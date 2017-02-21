package AOPTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("aopTest.xml");
		
		Vehicle car = context.getBean("car", Vehicle.class);
		Vehicle bus = context.getBean("bus", Vehicle.class);
		
		car.info();
		
	}

}
