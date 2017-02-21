package DI03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 스프링을 통한 DI - 속성(setter) 주입방식(XML)
 * 	- 운전자는 쇼핑 센터를 이용하여 자동차 구매
 * 	- 쇼핑센터에서 타이어 주문
 *  - 쇼핑센터에서 자동차 주문
 *  - 쇼핑센터에서 자동차에 타이어 장착
 *  - 쇼핑센터가 운전자에게 타이어가 장착된 자동차 전달
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di03.xml");
		
		Car car = (Car)context.getBean("car");
		
		System.out.println(car.getTireBrand());
	}
}
