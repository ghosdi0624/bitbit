package AOP05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 	pointCut
 * 
 *  [접근제한자] 리턴타입 [패키지.클래스명] 메소드명(파라미터) [throws 예외패턴]
 */

@Aspect
public class MyAspect {

	@Before("execution(* runSomething())")
	public static void before(JoinPoint joinPoint){		
		System.out.println("열쇠로 문을 열고 집으로 들어온다.");
	}
	
	@After("execution(* runSomething())")
	public static void after(JoinPoint joinPoint){
		System.out.println("불을 끄고 잠을 잡니다.");
		System.out.println("문을 잠그고 집을 나섭니다.");
	}
	
}
