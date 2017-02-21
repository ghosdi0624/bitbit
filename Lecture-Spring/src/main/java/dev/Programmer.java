package dev;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Developer {

	@Override
	public void gotoOffice() {
		System.out.println("프로그래머 출근");	
	}

	@Override
	public void getoffOffice() {
		System.out.println("프로그래머 퇴근");	
	}

}
