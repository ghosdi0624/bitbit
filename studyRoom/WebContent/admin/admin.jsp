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
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>

</head>
<body>
<div class="wrapper">
<header>
		<%@include file="/include/header.jsp"%>
</header>
	<div class="text-center" style="padding: 50px 0">
		<div class="page-group">
			<div class="page-title">관리자 페이지</div>
			<div class="selection">
				<a href="${ pageContext.request.contextPath }/refund.do" class="btn btn-default btn-admin">예약현황</a>		
			</div>
			<div class="selection">
				<a href="${ pageContext.request.contextPath }/moneyForm.do" class="btn btn-default btn-admin">월별 정산금액 보기</a>		
			</div>
		</div>
	</div>
</div>
<footer>
      <%@include file="/include/footer.jsp"%>
</footer>
</body>
</html>