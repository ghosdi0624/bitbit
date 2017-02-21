package DI_TEST;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *  10, 2 사칙연산 결과를 출력하는 코드를 스프링 기반의 주입방식을 이용하여 구현
 */
public class CalMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("di_test.xml");
		
		MyCalculator cal = (MyCalculator)context.getBean("MyCalculator");
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		
	}

}
