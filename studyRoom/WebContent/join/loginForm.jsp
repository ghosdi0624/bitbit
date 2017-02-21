<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link href="/studyRoomLBJ/css/styles.css" rel="stylesheet"
	type="text/css">
<title>Insert title here</title>

<script>
	function goLogin() {
		var form = document.LoginForm;

		if (form.id.value == "") {
			alert("아이디를 입력하시오.");
			return false;
		}
		if (form.password.value == "") {
			alert("비밀번호를 입력하시오.");
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<div class="wrapper">
		<header>
			<%@ include file="/include/header.jsp"%>
		</header>
		<section>
			<div class="text-center" style="padding: 50px 0">
				<div class="login-form-1">
					<h2>로그인</h2>
					<c:if test="${ empty sessionScope.id }">
						<form name="LoginForm" id="login-form" class="text-left"
							method="post"
							action="${ pageContext.request.contextPath }/login.do"
							onsubmit="return goLogin()">
							<div class="login-form-main-message"></div>
							<div class="main-login-form">
								<div class="login-group">
									<div class="form-group">
										<input type="text" class="form-control" name="id"
											placeholder="아이디">
									</div>
									<div class="form-group">
										<input type="password" class="form-control" name="password"
											placeholder="비밀번호">
									</div>
								</div>
								<button type="submit" class="login-button">
									<i class="fa fa-chevron-right"></i>
								</button>
							</div>
						</form>
					</c:if>
					<c:if test="${ not empty sessionScope.id }">
      ${ sessionScope.id }님이 로그인 중입니다.
   </c:if>
				</div>
		</section>
	</div>
	</div>
	<footer>
		<%@ include file="/include/footer.jsp"%>
	</footer>
</body>
</html>