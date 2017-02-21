<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>


$(document).ready(function(){
	$("#mon").change(function(){
		var mon=document.doc.mon.value;	
		$.ajax({
			url : "/studyRoom/money.do",
			type : "get",
			data : {money : $("#mon").val()},
			success : callback
		});	
		
	});
		
});

function callback(data){
	
	var data = eval(data);	
	/* $('div').append("<h1>" + data[0].paidTotal + "</h1>"); */
	
	$("#paid").hide;
	$("#refund").hide;
	
	$("#paid").html(data[0].paidTotal+"원");
	$("#refund").html(data[1].refundTotal+"원");
	$("#margin").html(data[2].margin+"원");
	
}
</script>
</head>
<header>
		<%@include file="/include/header.jsp"%>
</header>
<body>
<div class="wrapper">
	<div align="center">
		<div class="page-title">월별 정산금액 보기</div>
		<form name="doc" >
		<select title="선택하세요" class="selectpicker" id="mon" name="mon">
			<option></option>
			<option>1월</option>
			<option>2월</option>
			<option>3월</option>
			<option>4월</option>
			<option>5월</option>
			<option>6월</option>
			<option>7월</option>
			<option>8월</option>
			<option>9월</option>
			<option>10월</option>
			<option>11월</option>
			<option>12월</option>		
		</select>
		</form>
	</div>
	
	<div align="center">
		<table class="moneyTable">
			<tr>
				<td class="title">결제금액</td>
				<td><div class="money"><span id="paid"></span></div></td>
			</tr>
			<tr>
				<td class="title">환불금액</td>
				<td><div class="money"><span id="refund"></span></div></td>
			</tr>
			<tr>
				<td class="title">이익금</td>
				<td><div class="money"><span id="margin"></span></div></td>
			</tr>
		</table>
		<br/>
		<a href="${ pageContext.request.contextPath }/adminPage.do" class="btn btn-default btn-admin">뒤로가기</a>
	</div>
</div>
<footer>
      <%@include file="/include/footer.jsp"%>
</footer>
</body>
</html>