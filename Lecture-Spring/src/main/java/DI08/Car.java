package DI08;

import javax.annotation.Resource;

public class Car {
	
	@Resource(name="koreaTire")
	private Tire tire;
	
	//생성자 주입방식
	public Car(Tire tire){
		this.tire = tire;
		System.out.println("Car(Tire) 생성자 호출...");
	}

	//setter 주입방식
	public void setTire(Tire tire){
		this.tire = tire;
		System.out.println("setTire() 메소드 호출...");
	}
	
	public String getTireBrand(){
		return "장착된 타이어 : " + tire.getBrand();
	}
}
