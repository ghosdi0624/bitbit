package DI_TEST03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderManager {

//	@Resource(name="samsung")
	@Autowired
	@Qualifier("hyundai")
	private CarMaker carMaker;
	@Resource
	private Money money;
	
	public void order(){
		money.setAmount(3000);
		carMaker.sell(money);
	}
}
