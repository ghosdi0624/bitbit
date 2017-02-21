package dev;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


@Component
public class Develope {
	
	
	private Developer developer;
	
//	@Autowired
//	public Develope(@Qualifier("Programmer")Developer developer){
//		this.developer = developer;
//	}
	
//	@Autowired
//	@Qualifier("Programmer")
//	private Developer developer;
	
	public void coding(){
		developer.gotoOffice();
		System.out.println("개발합니다");
		developer.getoffOffice();
	}

	@Resource(name="programmer")
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
//	@Autowired
//	public void setDeveloper(@Qualifier("Programmer")Developer developer) {
//		this.developer = developer;
//	}
	
	
}
