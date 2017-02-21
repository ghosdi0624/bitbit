package DI06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 스프링을 통한 DI - @Autowired 어노테이션을 이용한 자동주입
 * 	- 운전자는 쇼핑 센터를 이용하여 자동차 구매
 * 	- 쇼핑센터에서 타이어 주문
 *	- 쇼핑센터에서 선택한 타이어를 장착한 자동차 주문
 *	- 자동차를 운전자에게 전달
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di06-1.xml");
		
		Car car = context.getBean("car", Car.class);
		System.out.println(car.getTireBrand());
	}
}
