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
</head>
<body>
	<header>
		<c:import url="/include/topmenu.do" />
	</header>
	
	<section>
	<form method="post" action="${ pageContext.request.contextPath }/company/fileupload.do" enctype="multipart/form-data">
	<input type="hidden" name="hotelName" value="${ hotelName }"/>
	<div align="center">
		<h2>숙소 등록</h2>
		<hr width="80%" /><br/>
		<table>
			<tr>
				<th>메인에 등록할 사진</th>
				<td><input type="file" name="mainfile" value=" 사진 등록 "/></td>
			</tr>
			<tr>
				<th>기본 사진</th>
				<td><input type="file" name="file1" value=" 사진 등록 "/></td>
			</tr>
			<tr>
				<th>기본 사진</th>
				<td><input type="file" name="file2" value=" 사진 등록 "/></td>
			</tr>
			<tr>
				<th>기본 사진</th>
				<td><input type="file" name="file3" value=" 사진 등록 "/></td>
			</tr>
			<tr>
				<th>기본 사진</th>
				<td><input type="file" name="file4" value=" 사진 등록 "/></td>
			</tr>
		</table>
		<br/><br/>
		<input type="submit" value=" 등록완료 "/>
	</div>
	</form>
	</section>
	
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>