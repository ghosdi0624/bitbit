package DI02;

public class Car {
	
	private Tire tire;
	
	public Car(){
		
	}
	
	public void setTire(Tire tire){
		this.tire = tire;
	}
	
	public String getTireBrand(){
		return "������ Ÿ�̾� : " + tire.getBrand();
	}
}
