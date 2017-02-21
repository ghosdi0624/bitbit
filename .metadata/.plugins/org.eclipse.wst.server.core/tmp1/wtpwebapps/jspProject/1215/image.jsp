<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!BufferedOutputStream bos;
	FileInputStream fis;%>
	<%
		String Filename = application.getRealPath("/image/");

		try {
			response.setContentType("image/jpg");
			response.addHeader("Content-Transfer-Encoding", "binary");
			Filename += "IMG_0106.jpg";
			String filename = new String(Filename.getBytes("ISO-8859-1"), "utf-8");
			fis = new FileInputStream(filename);
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buf = new byte[1024];
			for (int i = 0; (i = fis.read(buf)) != -1;) {
				bos.write(buf, 0, i);
			}
			bos.flush();
		} catch (IOException e) {
			response.setContentType("text/html;charset=utf-8");
			out.println("Error: " + e.getMessage());
		} finally {
			bos.close();
			fis.close();
		}
	%>
</body>
</html>