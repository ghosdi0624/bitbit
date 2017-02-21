<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<script type="text/javascript">
	if("${msg}"){
		alert("${msg}");
	}
</script>

</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
		<aside>
		</aside>
	</header>
	
	<section>
	<div>
		<div style="position: absolute; width: 1000px">
			<c:import url="/include/sidemenu.do" />
		</div>
		<img src="${ pageContext.request.contextPath }/resources/images/main.jpg" width="100%" height="500px"/>
	</div>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>