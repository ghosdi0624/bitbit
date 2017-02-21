<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
	alert("게시물이 등록되었습니다.");
	location.href = "${ pageContext.request.contextPath }/board/list.do";
</script>