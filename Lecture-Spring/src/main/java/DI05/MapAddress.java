package DI05;

import java.util.List;
import java.util.Map;

public class MapAddress {

	private Map<String, String> address;
	
	public MapAddress(){
		
	}
	
	public MapAddress(Map<String, String> address){
		this.address = address;
	}

	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

	public Map<String, String> getAddress() {
		return address;
	}
	
}
