package AOP03;

import org.aspectj.lang.JoinPoint;

/*
 * 	pointCut
 * 
 *  [접근제한자] 리턴타입 [패키지.클래스명] 메소드명(파라미터) [throws 예외패턴]
 */

public class MyAspect {

	public static void before(JoinPoint joinPoint){		
		System.out.println("열쇠로 문을 열고 집으로 들어온다.");
	}
	
}
