package kr.co.bit.framwork.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) 	// 컨트롤러 라는 어노테이션은 클래스명에만 붙일 수 있다. 라고 명시 
@Retention(RetentionPolicy.RUNTIME)		//언제까지 유지하게 할 것인지. --> 실시간 동적으로 호출했을때만 / 프로그램을 실행했을때만
public @interface Controller {
	
}
