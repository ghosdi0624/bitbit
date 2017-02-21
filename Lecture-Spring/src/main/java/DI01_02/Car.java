package DI01_02;

public class Car {
	
	private Tire tire;
	
	// 생성자 주입
	public Car(Tire tire){
		this.tire = tire;

	}
	
	public String getTireBrand(){
		return "장착된 타이어 : " + tire.getBrand();
	}
}
