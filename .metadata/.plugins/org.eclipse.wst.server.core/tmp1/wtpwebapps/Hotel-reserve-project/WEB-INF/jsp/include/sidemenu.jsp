<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- // jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- // jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- // jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<script type="text/javascript">
	$(function() {
	    $( "#check-in, #check-out" ).datepicker({
	         changeMonth: false, 
	         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
	         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
	         monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)','7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
	         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	       	 minDate: 0, 
	         maxDate: "+5M",
	         dateFormat: "yy-mm-dd",
	         showOn: "both",
	         buttonImage: "${pageContext.request.contextPath}/resources/images/button.gif", 
	         buttonImageOnly: true
	  });
	});
	
	function searchCheck(){
		
		var form = document.searchform;
		if(form.checkIn.value==""){
			alert("출발일을 입력하세요");
			return false;
		}
		if(form.checkOut.value==""){
			alert("퇴실일을 입력하세요");
			return false;
		}
	}
	
</script>
<form name="searchform" method="post" action="${ pageContext.request.contextPath }/hotel/searchhotel.do" onsubmit="return searchCheck()">

<div id="maincheck" align="center">
	<h2>호텔 검색</h2>
	<div align="left" style="width: 80%">
		<div style="size: 10px">체크인</div>
		<input type="text" id="check-in" name="checkIn" readonly="readonly" size="13">
	</div>
	<br />
	<div align="left" style="width: 80%">
		<div style="size: 10px">체크아웃</div>
		<input type="text" id="check-out" name="checkOut" readonly="readonly" size="13">
	</div>
	<br /> <input type="submit" value="  검색  " style="background-color: #73F25C" />
</div>
</form>