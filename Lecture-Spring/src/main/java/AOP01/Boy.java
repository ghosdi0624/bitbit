package AOP01;

public class Boy {
	
	public void runSomthing(){
		
		MyAspect.beforeRunSomething();
		
		System.out.println("컴퓨터로 게임을 합니다.");
		
		MyAspect.afterRunSomething();
	}
}
