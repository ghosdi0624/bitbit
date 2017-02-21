package AOP02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 	pointCut
 * 
 *  [접근제한자] 리턴타입 [패키지.클래스명] 메소드명(파라미터) [throws 예외패턴]
 */

@Aspect
public class MyAspect {
	
	@Before("execution(* AOP02.Boy.runSomething(..))")		// @Before("포인트컷")
	public static void before(JoinPoint joinPoint){			// 조인포인트
		System.out.println("열쇠로 문을 열고 집으로 들어온다.");
	}
	
}
