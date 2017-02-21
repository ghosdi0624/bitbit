<%@page import="kr.co.bit.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	BoardDAO dao = new BoardDAO();
	dao.delete(no);
%>

<script>
	alert("게시물 [${ param.no }]번이 삭제 되었습니다");
	location.href = "list.jsp";
</script>