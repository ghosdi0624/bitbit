package DI_TEST03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hyundai")
public class HyundaiMaker implements CarMaker{
	
	@Autowired
	private Car car;
	
	@Override
	public Car sell(Money money) {
		car.setName("그랜저");
		System.out.println(car.getName()+"는 "+money.getAmount()+"만원에 팔았습니다.");
		return car;
	}
}
