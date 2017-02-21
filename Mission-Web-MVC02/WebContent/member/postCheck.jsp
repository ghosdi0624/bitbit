
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkDone(zipcode, area1, area2, area3, area4){
		var addr = area1 +" "+ area2 +" "+ area3 +" "+ area4;
		opener.document.inputForm.post.value = zipcode;
		opener.document.inputForm.basic_addr.value = addr;
		window.close();
	}
</script>
</head>
<body>
<form>
	<c:forEach var="list" items="${ list }">
		<a href = "#" onclick = "checkDone('${ list.zipcode }','${ list.area1 }','${ list.area2 }','${ list.area3 }','${ list.area4 }')">
		${ list.zipcode }&nbsp;${ list.area1 }&nbsp;
		${ list.area2 }&nbsp;${ list.area3 }&nbsp;
		${ list.area4 }</a><br/>
	</c:forEach>
</form>
</body>
</html>