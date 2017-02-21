package DI02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 스프링을 통한 DI - 속성(setter) 주입방식
 * 	- 쇼핑센터에서 타이어 주문
 *  - 쇼핑센터에서 자동차 주문
 *  - 운전자 직접 자동차에 타이어 장착
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di02.xml");
		Tire tire = (Tire)context.getBean("tire2");
		Car car = (Car)context.getBean("car");
		
		car.setTire(tire);
		System.out.println(car.getTireBrand());
	}
}
