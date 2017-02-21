x<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#msgView {
		border: 1px solid red;
		width: 500px;
		height: 200px;
	}
</style>
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$(":button").click(function(){
			/*
				url 		: 요청주소 (문자열)
				type 		: 메소드 (get/post)
				data 		: 파라미터 (문자열, 객체)
				dataType	: 응답데이터 타입
				success		: 수신성공 (함수)
				error		: 수신실패 (함수)
				complete	: 수신완료 (성공/실패의 여부 관계없이 실행)
			*/
			$.ajax({
				url : "hello.jsp",
				type : "GET",
				success : function(data){
					$('#msgView').append(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>서버에서 받은 메세지</h2>
	<div id="msgView"></div>
	<input type="button" value="서버에 자료요청" />
</body>
</html>
