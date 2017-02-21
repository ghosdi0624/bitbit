package AOP01;

public class Girl {
	
	public void runSomthing(){
		
		MyAspect.beforeRunSomething();
		
		System.out.println("요리를 합니다.");
		
		MyAspect.afterRunSomething();
	}
}
