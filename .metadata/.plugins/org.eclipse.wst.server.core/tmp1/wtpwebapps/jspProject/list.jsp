<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
	Statement stat = conn.createStatement();
	Statement stat1 = conn.createStatement();
	ResultSet rs = stat.executeQuery("SELECT borno,title,author,bordate,hit FROM border1 order by borno DESC");
	ResultSet rs1 = stat1.executeQuery("SELECT borno,title,author,bordate,hit FROM border1 order by borno DESC");
	rs1.next();
	int i = rs1.getInt("borno"); 
	session.setAttribute("row", i+1);
%>
<%//답글 달기
	Statement reply = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	ResultSet rsReply = reply.executeQuery("select * from reply1 order by bordate");
%>	
	
<%	
	Statement stat2 = conn.createStatement();
	ResultSet rs2 = stat2.executeQuery("select count(*) from border1"); rs2.next();
	
	int totalboard = rs2.getInt(1); //총 게시물수
	int rowpage = 5; // 한 페이지에 보일 게시물 수
	int block = 5; // 하단에 보일 페이지 번호 갯수
	int pg = 1; // 기본 페이지 값
	if(request.getParameter("pg")!=null){ //받아온 pg값이 있을때, 다른페이지일때
		pg = Integer.parseInt(request.getParameter("pg")); // pg값을 저장
	}
	int start = (pg*rowpage) - (rowpage - 1); // 첫 페이지 
	int end = (pg*rowpage); // 끝 페이지
	
	int allpage = (totalboard/rowpage)+1; // 전체 페이지 수
	int startpage = ((pg-1)/block*block)+1; // 시작블럭숫자 (1~5페이지일경우 1, 6~10일경우 6)
	int endpage = 0;
	if((totalboard/block)+1 < ((pg-1)/block*block)+block){
		endpage = (totalboard/block)+1;
	}
	else{
		endpage = ((pg-1)/block*block)+block;		// 끝 블럭 숫자 (1~5일 경우 5, 6~10일경우 10)
	}
%>
<form method = "post">
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<th><span style = "font-size:30pt;">게시판 목록</span></th>
</table>
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<tr>
<td align = "right">
총 게시물 : <%=totalboard %>개 
<input type = "submit" value = "글쓰기" formaction = "post.jsp"></td>
</tr>
</table>
<table border = "1" width = "850" align = "center">
<tr>
<td align = "center" width = "10" bgcolor = "#D2E9F9"><b>No</b></td>
<td width = "500" align = "center" bgcolor = "#D2E9F9"><b>제목</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성자</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>작성일</b></td>
<td align = "center" bgcolor = "#D2E9F9"><b>조회수</b></td></tr>

<%
	int count = 0;
	while(rs.next()){ 
	count++;
	if(count == (pg * rowpage) - (rowpage-1)){
	%>
<tr>
<td align = "center">  <%out.println(rs.getInt("borno"));%></td>
<td><a href = "read.jsp?borno=<%=rs.getInt("borno")%>&id=<%=rs.getString("author")%>"><%out.println(rs.getString("title"));%></a></td>		
<td align = "center">  <%out.println(rs.getString("author"));%></td>
<td align = "center">  <%out.println(rs.getString("bordate"));%></td>
<td align = "center">  <%out.println(rs.getString("hit"));%></td>
</tr><%	
	while(rsReply.next()){
	if(rs.getInt("borno")==rsReply.getInt("borno")){%>
<tr><td></td>
<td><a href = "replyread.jsp?borno=<%=rsReply.getInt("borno")%>&id=<%=rsReply.getString("author")%>"><%out.println("ㄴre:"+rsReply.getString("title"));%></a></td>
<td align = "center"><%	out.println(rsReply.getString("author"));%></td>
<td align = "center"><%	out.println(rsReply.getString("bordate"));%></td>
<td align = "center"><%	out.println(rsReply.getString("hit"));%></td>
</tr><%
	
	}}
	rsReply.beforeFirst();
	if(rowpage==1)
		break;
	rowpage--;	}
	}
%>
</table><br/>
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<tr><td colspan="4" height="5"></td></tr>
<tr><td align = "center">
<%
			if(pg>block) {
		%>
			[<a href="list.jsp?pg=1">◀◀</a>]
			[<a href="list.jsp?pg=<%=startpage-1%>">◀</a>]
		<%
			}
		%>
		
		<%
			for(int j=startpage; j<= endpage; j++){
				if(j==pg){
		%>
					<b>[<%=j %>]</b>
		<%
				}else{
		%>
					[<a href="list.jsp?pg=<%=j %>"><%=j %></a>]
		<%
				}
			}
		%>
		
		<%
			if(endpage<allpage){
		%>
			[<a href="list.jsp?pg=<%=endpage+1%>">▶</a>]
			[<a href="list.jsp?pg=<%=allpage%>">▶▶</a>]
		<%
			}
		%>
		</td>
		</tr>

</table>
<table border = "0" width = "850" align = "center" cellpadding = "0" cellspacing = "0">
<tr>
<td align = "center">
<SELECT NAME = "search">
<option value = "이름">이름으로</option>
<option value = "제목">제목으로</option>
<option value = "날짜">날짜로</option>
</SELECT>
<input type = "text" name = "keyword">
<input type = "submit" value = "검색" formaction = "search.jsp">
</td>
</tr>
</table>


</form>
</body>
</html>