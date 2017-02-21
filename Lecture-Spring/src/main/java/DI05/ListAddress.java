package DI05;

import java.util.List;

public class ListAddress {

	private List<String> address;
	
	public ListAddress(){
		
	}
	
	public ListAddress(List<String> address){
		this.address = address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public List<String> getAddress() {
		return address;
	}
	
}
