package DI08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 스프링을 통한 DI - @Resource , @Autowired 어노테이션 비교
 * 	- @Resource  : 자바표준 어노테이션
 *  - @Autowired : 스프링 어노테이션
 *  
 *  객체 찾기 우선순위
 *  - @Resource  : type, id 중 id 우선순위 높음 
 *  - @Autowired : type, id 중 type 우선순위 높음
 */

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("di08-5.xml");
		
		Car car = context.getBean("car", Car.class);
		System.out.println(car.getTireBrand());
	}
}
