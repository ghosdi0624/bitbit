<%@page import="kr.co.bit.member.dao.MemberDAO"%>
<%@page import="kr.co.bit.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.bit.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("회원가입이 완료 되었습니다.");
	location.href = "${ pageContext.request.contextPath }/loginform.do";
</script>