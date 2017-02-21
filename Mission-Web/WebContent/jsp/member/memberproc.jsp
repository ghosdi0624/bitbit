<%@page import="kr.co.bit.member.dao.MemberDAO"%>
<%@page import="kr.co.bit.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.bit.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String selectmail = request.getParameter("selectMail");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String post = request.getParameter("post");
	String basic_addr = request.getParameter("basic_addr");
	String addr = request.getParameter("addr");
	
	
	MemberDAO member = new MemberDAO();
	member.insertMember(id, pw, name, email, selectmail, tel1, tel2, tel3, post, basic_addr, addr);
	
%>

<script>
	alert("회원가입이 완료 되었습니다.");
	location.href = "loginform.jsp";
</script>