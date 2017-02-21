<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		$(':button').click(function(){
			$.ajax({
				url : "param3.jsp",
				type : "GET",
//				data : "name=홍길동&age=25",
				data : {name:'홍길동', age:'25'},
				success : callback
			});
		});
	});
	
	function callback(data){
		console.log(data);
		$('#debug').prepend(data.trim() + "\n");
	}
</script>
</head>
<body>
	<textarea rows="10" cols="80" id="debug"></textarea><br/>
	<input type="button" value="호출"  />
</body>
</html>







