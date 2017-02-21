<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSite</title>
</head>
<form method = "post">
<table bordercolor = "#32cd32" border = "1" width = "935"></table>
<h1 align = "center">Welcome WebSite</h1>
<body>
<table border = "1" width = "500" cellpadding = "5" align = "center">
<tr>
<td bgcolor = "#32cd32" colspan = "2"><jsp:include page="Top.jsp" flush="false"></jsp:include></td></tr>
<tr>
<td bgcolor = "#c0c0c0" valign = "top"><jsp:include page="Menu.jsp" flush="false"></jsp:include></td>
<td bgcolor = "#f5f5dc" width = "80%" valign = "middle">welcome...<br/><img src = "image/IMG_0106.JPG" width = "200" border="0"/>
</td></tr>
<tr>
<td bgcolor = "#cd853f" colspan = "2"><jsp:include page="Bottom.jsp" flush = "false"></jsp:include></td></tr>
</table>
<table bordercolor = "#32cd32" border = "1" width = "935">

</table>
<input type = "submit" value = "로그아웃" formaction = "logout.jsp">
</body>
</html>