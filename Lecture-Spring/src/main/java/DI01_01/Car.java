package DI01_01;

public class Car {
	
	private Tire tire;
	
	public Car(){
//		this.tire = new KoreaTire();		// 의존 관계 발생
		this.tire = new AmericaTire();
	}
	
	public String getTireBrand(){
		return "장착된 타이어 : " + tire.getBrand();
	}
}
