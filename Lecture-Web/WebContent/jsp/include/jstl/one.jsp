<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<hr/>
	id : ${ id }<br/>
	name : ${ param.name }<br/>
	age : ${ param.age }<br/>
	<h2>인클루드된 내용</h2>
	<h2>인클루드된 내용</h2>
	<h2>인클루드된 내용</h2>
	<h2>인클루드된 내용</h2>
	<h2>인클루드된 내용</h2>
	<hr/>
	
<%
	request.setAttribute("phone", "010-1111-2222");
%>
