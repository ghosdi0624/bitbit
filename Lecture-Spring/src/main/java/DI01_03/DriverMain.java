package DI01_03;

/*
 * 스프링없이 DI - 속성(setter) 주입방식
 * 	- 운전자가 타이어 선택
 * 	- 운전자가 차를 주문
 * 	- 운전자가 직접 자동차에 타이어 장착
 */

public class DriverMain {

	public static void main(String[] args) {
		
		Tire tire = new KoreaTire();
		
		Car car = new Car();
		car.setTire(tire);
		
		System.out.println(car.getTireBrand());
	}
}
