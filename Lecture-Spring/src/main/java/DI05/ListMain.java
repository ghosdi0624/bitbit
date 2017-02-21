package DI05;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di05.xml");
		
		ListAddress list = (ListAddress)context.getBean("list");
		
		List<String> address = list.getAddress();
		
		for(String addr : address){
			System.out.println(addr);
		}
	}

}
