package AOPTest;

import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicle{

	public void info(){
		System.out.println("버스 입니다.");
	}
}
