<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String protocol = request.getProtocol();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String method = request.getMethod();
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String useBrowser = request.getHeader("User-Agent");
		String fileType = request.getHeader("Accept");
	%>
	프로토콜 :
	<%=protocol%><p>
		서버의 이름 :
		<%=serverName%>
	<p>
		서버의 포트 번호 :
		<%=serverPort%>
	<p>
		사용자 컴퓨터의 주소 :
		<%=remoteAddr%>
	<p>
		사용자 컴퓨터의 이름 :
		<%=remoteHost%>
	<p>
		사용 method :
		<%=method%>
	<p>
		요청 경로(URL) :
		<%=requestURL%>
	<p>
		요청 경로(URI) :
		<%=requestURI%>
	<p>
		현재 사용하는 브라우저 :
		<%=useBrowser%>
	<p>
		브라우저가 지원하는 file의 type :
		<%=fileType%>
	<p>
</body>
</html>