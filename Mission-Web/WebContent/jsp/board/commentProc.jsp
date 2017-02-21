<%@page import="kr.co.bit.comment.vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.bit.comment.dao.CommentDAO"%>
<%@page import="kr.co.bit.login.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	LoginVO userVO = (LoginVO)session.getAttribute("userVO");
	String writer = userVO.getId();
	int boardNo = Integer.parseInt(request.getParameter("no"));
	String content = request.getParameter("content");

	CommentDAO dao = new CommentDAO();
	dao.insertComment(boardNo, writer, content);
	
%>
[
	{
		content : '${param.content}',
		writer : '${sessionScope.userVO.id}'
	}
]