package AOPPrac;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class MyAspect {

	@Around("execution(* setAge(..))")
	public static void around(ProceedingJoinPoint joinPoint) throws Throwable {

		joinPoint.proceed();

//		Object[] obj = joinPoint.getArgs();
//		int age = (int)obj[0];
		
		Object obj = joinPoint.getTarget();
		int age = 0;
		
		if(obj instanceof Man){
			age = ((Man)obj).getAge();
		}
		
		if (age > 19) {
			System.out.println(age + "세는 성년 입니다.");
		} else {
			System.out.println(age + "세는 미성년자 입니다.");
		}
	}
}
