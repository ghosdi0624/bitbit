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
	
	function sendProcess(param) {
		
		var msg = "";
		msg += "----------------------------------------------------------\n";
//		msg += "/Lecture-Web/ajax/exam03/param.jsp?name="+param+ "\n";
		msg += "/Lecture-Web/Param?name="+param+ "\n";
		debugTrace(msg);		
		
		httpRequest = getXMLHttpRequest();
		httpRequest.onreadystatechange = callbackFunction;
//		var url = "param.jsp?name="+param;
		var url = "/Lecture-Web/Param?name="+param;
		httpRequest.open("GET", url, true);
		httpRequest.send(null);
	}
	
	function callbackFunction() {
		/*
			readyState
			0 : open() 호출전
			1 : open() 호출, send() 호출전
			2 : send() 호출, 서버응답전
			3 : 서버 응답, 클라이언트에게 header 전송 body 전송전
			4 : 클라이언트에게 body 전송완료(응답완료)	
			
			Staus
			200 : OK(처리완료)
			403 : 엑세스 거부
			404 : File Not Found
			405 : Servlet Error
			500 : 내부 서버 오류
		*/
		
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
	<input type="button" value="영문인자호출" onclick="sendProcess('honggil-dong')" />
	<input type="button" value="한글인자호출" onclick="sendProcess('홍길동')" />
	<input type="button" value="초기화" onclick="clearOnClick()"/>
</body>
</html>







