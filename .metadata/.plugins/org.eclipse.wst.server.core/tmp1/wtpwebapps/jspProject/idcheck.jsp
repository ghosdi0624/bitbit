<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String newId = request.getParameter("newid");
		String query = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			Statement stat = conn.createStatement();
			query = String.format("select memid from member1 where memid = '%s'", newId);
			ResultSet rs = stat.executeQuery(query);
			if (rs.next()) {
	%>
			사용할수 없는 ID입니다..
			<button type="button" onclick="fn_back();">닫기</button>
	<%
		} else {
	%>
			사용 가능한 ID 입니다
		<%--<a href = "url" target="_blank">확인하기</a>--%>
		<!-- <a href="javascript:history.go(-1)">계속하기</a> -->
			<button type="button" onclick="fn_back();">닫기</button>
	<%
		}
		} catch (Exception e) {
			e.getMessage();
		}
	%>

</body>
</html>

<script type="text/javascript">
function fn_back(){
	self.close();
}
</script>