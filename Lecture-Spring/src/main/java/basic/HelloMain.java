package basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {
/*		
		Hello obj = new Hello();
		obj.printMsg();
*/
		
//		Resource resource = new ClassPathResource("beanContainer.xml");							// ClassPath : src/main/java
		Resource resource = new FileSystemResource("src/main/resources/beanContainer.xml");		// 경로 지정해서 설정
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Hello obj = (Hello)factory.getBean("hello");
		obj.printMsg();
		
		Hello obj2 = (Hello)factory.getBean("hello2");
		obj2.printMsg();
		
		Hello obj3 = (Hello)factory.getBean("hello");
		obj3.printMsg();
		
		System.out.println(obj);
		System.out.println(obj2);
		System.out.println(obj3);
	}

}
