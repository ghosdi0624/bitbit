package AOPPrac;

import org.springframework.stereotype.Component;

@Component
public class Man implements Human {

	private String name;
	private int age;
	
	@Override
	public void setAge(int age) {
		this.age=age;
	}
	
	public int getAge(){
		return age;
	}

}
