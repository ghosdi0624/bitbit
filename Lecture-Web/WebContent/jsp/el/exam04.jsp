<%@page import="kr.co.bit.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo b = new BoardVo();
	b.setNo(1);
	b.setTitle("test");
	
	// pageContext영역에 등록
	// 이름 : board, 값 : 생성된 BoardVo 객체	
	pageContext.setAttribute("board", b);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	no : <%=b.getNo() %><br/>
	no : <%=((BoardVo)pageContext.getAttribute("board")).getNo() %><br/>
	title : <%=b.getTitle() %>
	title : <%=((BoardVo)pageContext.getAttribute("board")).getTitle() %><br/>
	
	el no : ${ board.no }<br/>
	el title : ${ board.title } <br/>
	
</body>
</html>