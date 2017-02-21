<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/hello/hello.do">
	hello
	</a><br/>
	<a href="${pageContext.request.contextPath }/method/method.do">
	method
	</a><br/>
	<a href="${pageContext.request.contextPath }/form/joinForm.do">
	form
	</a><br/>
	<a href="${pageContext.request.contextPath }/ajax/resBody.do">
	문자열 응답
	</a><br/>
	<a href="${pageContext.request.contextPath }/ajax/resBody.json">
	Json 응답
	</a><br/>
	<a href="${pageContext.request.contextPath }/ajax/resVOBody.json">
	Json VO 응답
	</a><br/>
	<a href="${pageContext.request.contextPath }/ajax/resStringListBody.json">
	Json List(문자열) 응답
	</a><br/>
	<a href="${pageContext.request.contextPath }/ajax/resVOListBody.json">
	Json List(VO) 응답
	</a><br/>
	<a href="${pageContext.request.contextPath }/file/uploadForm.do">
	파일 업로드
	</a><br/>
</body>
</html>