<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.oreilly.servlet.MultipartRequest, 
    com.oreilly.servlet.multipart.DefaultFileRenamePolicy, java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	String savePath = application.getRealPath("/backup"); //파일저장
	int sizeLimit = 5*1024*1024; // 파일 최대 사이즈
	MultipartRequest mr = new MultipartRequest(request, savePath, sizeLimit, 
												"utf-8", new DefaultFileRenamePolicy());
	File file = mr.getFile("file");
	String fileName = file.getName();
	long fileSize = file.length();
	
	
	if(fileName == null){
		out.print("파일 업로드 실패");
	} else {
		out.println("파일명 : " + fileName + "<br/>");
		out.println("파일크기 : " + fileSize + "<br/>");
		out.println("설명 : " + mr.getParameter("desc") + "<br/>");
	}
%> --%>
</body>
</html>