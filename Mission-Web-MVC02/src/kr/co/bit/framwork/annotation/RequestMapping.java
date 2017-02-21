package kr.co.bit.framwork.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {	//어떤 uri가 들어오면 특정 메소드를 호출할수 있게 하려는 어노테이션
	
	String value();		//@RequestMapping(value="") / value는 하나밖에 없을시 생략가능

}
