package DI05;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MapMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di05-1.xml");
		
		MapAddress map = context.getBean("map", MapAddress.class); 
		
		Map<String,String> address = map.getAddress();
		
		Set<Map.Entry<String, String>> entry = address.entrySet();
		
		for(Map.Entry<String, String> e : entry){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
	}

}
