<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var httpRequest = null;

	function getXMLHttpRequest() {
		if(window.XMLHttpRequest)
			return new XMLHttpRequest();
		else if(window.ActiveXObject)
			return new ActiveXObject("Microsoft.XMLHTTP");
		else 
			return null;
	}
	
	function sendProcess(method, param) {
		
		var msg = "";
		msg += "----------------------------------------------------------\n";
		msg += "/Lecture-Web/ajax/exam03/param2.jsp?name="+param+ "\n";
		debugTrace(msg);		
		
		httpRequest = getXMLHttpRequest();
		httpRequest.onreadystatechange = callbackFunction;
		
		var url = "param2.jsp";
		
		param = encodeURIComponent(param);
		
		var args = "name="+param;
		// get방식은 ?파라미터  post body안에 파라미터
		if(method == "GET") {
			httpRequest.open(method, url + '?' + args, true);
			httpRequest.send(null);
		} else if(method == "POST") {
			httpRequest.open(method, url, true);
			httpRequest.setRequestHeader("Content-type",
									"application/x-www-form-urlencoded");
			httpRequest.send(args);
		}
		
	}
	
	function callbackFunction() {
		
		var msg = "";
		var debug = document.getElementById("debug");
		switch(httpRequest.readyState) {
		case 1 : 
			msg += "Loading...\n";
			break;
		case 2 : 
			msg += "Loaded...\n";
			break;
		case 3 : 
			msg += "Interactive...\n";
			break;
		case 4 :
			msg += "Complete...\n";
			// 서버 응답완료후 응답결과 처리
			if(httpRequest.status == 200) {
				msg += "웹서버에서 정상적으로 수행....\n";
				msg += "결과 : " + httpRequest.responseText + "\n";
			} else {
				msg += "웹서버에서 오류 발생...\n";
				msg += "오류코드 : " + httpRequest.status + "\n";
				msg += "오류내용 : " + httpRequest.statusText + "\n";
			}
			break;
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
	<textarea rows="10" cols="80" id="debug"></textarea><br/>
	<input type="button" value="Get영문인자호출" 
			onclick="sendProcess('GET', 'honggil-dong')" />
	<input type="button" value="Get한글인자호출" 
			onclick="sendProcess('GET', '홍길동')" />
	<input type="button" value="Post영문인자호출" 
			onclick="sendProcess('POST', 'honggil-dong')" />
	<input type="button" value="Post한글인자호출" 
			onclick="sendProcess('POST', '홍길동')" />
	<input type="button" value="초기화" onclick="clearOnClick()"/>
	
</body>
</html>







