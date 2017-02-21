package DI01_02;

/*
 * 스프링없이 DI - 생성자 주입방식
 * 	- 운전자가 타이어 선택
 * 	- 운전자가 차를 주문하면 선택한 타이어 장착
 */

public class DriverMain {

	public static void main(String[] args) {
		
//		Tire tire = new KoreaTire();
		Tire tire = new AmericaTire();
		
		Car car = new Car(tire);
		
		System.out.println(car.getTireBrand());
	}

}
