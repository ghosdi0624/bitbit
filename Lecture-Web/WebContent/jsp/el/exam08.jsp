<%@page import="kr.co.bit.board.vo.BoardVo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 자바빈즈 클래스 + 콜렉션
	/* BoardVo board = new BoardVo();
	board.setTitle("성공");
	
	List<BoardVo> boardList = new ArrayList<>();
	boardList.add(board);
	
	pageContext.setAttribute("boardList", boardList); */
	
	// 2. 자바빈즈 클래스 + 배열
	/* BoardVo board = new BoardVo();
	board.setTitle("성공");
	
	BoardVo[] boardList = {board};
	pageContext.setAttribute("boardList", boardList); */
	
	// 3. Map객체 + 콜렉션	
	/* Map<String, String> b = new HashMap<String, String>();
	b.put("title","성공");
	
	List<Map<String,String>> array = new ArrayList<Map<String,String>>();
	array.add(b);
	
	pageContext.setAttribute("boardList", array); */
	
	// 4. Map객체 + 배열
	Map<String, String> b = new HashMap<String, String>();
	b.put("title","성공");
	
	Map[] array = {b};
	pageContext.setAttribute("boardList", array);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	성공/실패? ${ boardList[0].title }<br/>
</body>
</html>