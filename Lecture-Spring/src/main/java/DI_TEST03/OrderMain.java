package DI_TEST03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("carContext.xml");
		
		OrderManager manager = (OrderManager)context.getBean("orderManager");
		manager.order();
	}

}
