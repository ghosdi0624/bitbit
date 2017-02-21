package AOPTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
		
	@Before("execution(* info())")
	public static void before(JoinPoint joinPoint){
		System.out.println("Before Advise");
	}
	
	@Around("execution(* info())")
	public static void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Around Advise");
		joinPoint.proceed();
	}
	
	@After("execution(* info())")
	public static void after(JoinPoint joinPoint){
		System.out.println("After Advise");
	}
	
}
