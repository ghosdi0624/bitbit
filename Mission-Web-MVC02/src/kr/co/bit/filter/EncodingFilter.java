package kr.co.bit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


public class EncodingFilter implements Filter {		// 요청, 응답 진행중 필터를 하나 세워 중간에서 수정 및 차단 가능

	private FilterConfig config;
	@Override
	public void destroy() {
		System.out.println("Filter 소멸...");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter 작업수행...");
		
		request.setCharacterEncoding(config.getInitParameter("utf-8"));
		chain.doFilter(request, response);
		System.out.println("Filter 진행...");

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filter 초기화...");
		this.config = config;
	}

}
