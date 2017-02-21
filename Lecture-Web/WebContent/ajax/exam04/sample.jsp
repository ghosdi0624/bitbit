<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("POST"))
		request.setCharacterEncoding("utf-8");
%>    
안녕하세요 ${ param.name }회원님
회원님이 입력하신 자료는
name = ${ param.name }
age = ${ param.age }
addr = ${ param.addr }