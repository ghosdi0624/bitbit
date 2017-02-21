<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  
	http://localhost:8080/Lecture-Web/jsp/el/exam02.jsp?id=aaa&name=bbb 요청했다 가정	
--%>
<%
	String id = request.getParameter("id");
	String[] hobbys = request.getParameterValues("hobby");
	if(hobbys == null){
		hobbys = new String[]{"파라미터 없음"};
	}
%>

id : <%=id %> <br />
el id : ${param.id} <br />
name : ${param.name} <br />
<%--
	http://localhost:8080/Lecture-Web/jsp/el/exam02.jsp?id=aaa&name=bbb&hobby=music&hobby=movie 요청했다 가정
--%>

hobby[0] = <%=hobbys[0] %> <br />
el hobby[0] = ${ paramValues.hobbys[0] }

<%--
	pageContext : 자신의 페이지에서만 볼수 있음 ex) a.jsp에서 변수 선언시 a.jsp에서만 해당 변수를 확인할 수 있음 / private 형태
	request : 서버로 클라이언트가 a.jsp 요청 시 서버는 b.jsp까지 연계하여 응답을 하게됨 / 한번 응답 시 같이 공유할수 있으며 응답 종료 시 변수 소멸
	session : 하나의 브라우저에서 요청 시  a.jsp / b.jsp 등등 해당 브라우저에서 지속적으로 변수 사용 가능
	application : 여러 브라우저에서 요청 시 공유 할수 있는 변수
	EL에서는 Scope로 사용
--%>
</body>
</html>