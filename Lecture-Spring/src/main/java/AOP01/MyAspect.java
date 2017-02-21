package AOP01;

// 공통관심문장을 분리
public class MyAspect {
	
	public static void beforeRunSomething(){
		System.out.println("열쇠로 문을 열고 집으로 들어온다.");
	}
	
	public static void afterRunSomething(){
		System.out.println("불을 끄고 잠을 잡니다.");
		System.out.println("문을 잠그고 집을 나섭니다.");
	}
}
