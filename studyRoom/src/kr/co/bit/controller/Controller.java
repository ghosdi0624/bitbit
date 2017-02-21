package kr.co.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/* default void info(){}; //1.7부터 default도 사용가능, 개발용x, 유지보수용 */
}
