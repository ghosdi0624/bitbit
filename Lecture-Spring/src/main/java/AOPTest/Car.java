package AOPTest;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

	public void info(){
		System.out.println("자동차 입니다.");
	}
}
