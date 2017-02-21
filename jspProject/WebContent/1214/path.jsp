<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <%-- 지시자 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSP 스크립트 Example</title>
</head>
<body>
<h1>Script Example</h1>
<%! String declaration = "Declaration"; %>
<%! public String decMethod(){
		return declaration;
		}%>
<% String scriptlet = "Scriptlet";
	String comment = "Comment"; 
	out.println("내장객체를 이용한 출력 : " + declaration + "<p>");%>
	
선언문의 출력 1 : <%=declaration %><p>
선언문의 출력 2 : <%=decMethod() %><p>
스크립트릿의 출력 : <%=scriptlet %><p>
<!-- JSP주석부분 -->
<!-- JSP 주석1 : <%=comment%> --><p>
<%-- JSP 주석2 : <%=comment%> --%><p>
<% /* 주석
(여러줄 주석)
*/%>
<%//한줄주석 %>		
</body>
</html>