<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer = "1kb" autoFlush = "true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	int totalbuffer = out.getBufferSize();
	int remainbuffer = out.getRemaining();
	int usebuffer = totalbuffer - remainbuffer;
%>
<h1>Out Example</h1>
<b>현재 페이지의 buffer 상태</b>
출력 버퍼의 전체크기 : <%= totalbuffer %>byte<p>
남은 버퍼의 크기 : <%= remainbuffer %>byte<p>
현재 버퍼의 사용량 : <%= usebuffer %>byte<p>
</body>
</html>