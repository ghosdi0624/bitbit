<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src = "/Lecture-Web/jquery/js/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="httprequest.js" ></script>
<script>
	function sendOnClick() {
		sendRequest("POST","sample.xml", null, callback);
	}
	
	function callback() {
		var msg = "";
		if(httpRequest.readyState ==4){
			if(httpRequest.status == 200){
				var xmlDoc = httpRequest.responseXML;
//				var xmlDoc = $.parseXML(httpRequest.responseText);
//				console.log(xmlDoc);
				
				var memberList = $(xmlDoc).find("member");
				msg += '회원 수 : '+memberList.length+'명\n';
				
				$(memberList).each(function(index){
					var id = $(this).find("id").text();
					var name = $(this).find("name").text();
					msg += id +' '+name+'\n';
				});
			}
		}
		debugTrace(msg);
	}

	function debugTrace(msg) {
		var debug = document.getElementById("debug");
		debug.value += msg;
	}
	
	function clearOnClick() {
		var debug = document.getElementById("debug");
		debug.value = "";
	}
</script>
</head>
<body>
	<h3>JSON 데이터 예제</h3>
	<br/>
	
	<form name="inputForm">
		<textarea rows="10" cols="80" id="debug"></textarea><br/>
		<input type="button" value="서버에 자료요청" onclick="sendOnClick()"/>
		<input type="button" value="초기화" onclick="clearOnClick()" />
	</form>
</body>
</html>