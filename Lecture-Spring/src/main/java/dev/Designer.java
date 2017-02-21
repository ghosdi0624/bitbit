package dev;

import org.springframework.stereotype.Component;

@Component
public class Designer implements Developer{
	
	@Override
	public void gotoOffice() {
		System.out.println("디자이너 출근");
		
	}

	@Override
	public void getoffOffice() {
		System.out.println("디자이너 퇴근");
		
	}
	

}
