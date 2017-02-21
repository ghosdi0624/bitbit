<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function doList() {
		location.href = "${ pageContext.request.contextPath }/board/list.do";
	}
	
	function doWrite() {
		var form = document.writeForm;
		if(form.title.value == ""){
			alert("제목을 입력해 주세요");
			form.title.focus();
			return false;
		}
		if(form.content.value == ""){
			alert("내용을 입력해 주세요");
			form.content.focus;
			return false;
		}
/* 		
		//파일 확장자 체크
		if(checkExt(form.attachfile1)){
			return false;
		}
		if(checkExt(form.attachfile2)){
			return false;
		}
*/		
		return true; 
	}
	
	function checkExt(obj){
		var forbidName = ['java','exe','js','jsp','class'];
		var fileName = obj.value;
		var ext = fileName.substring(fileName.lastIndexOf('.')+1);
		
		for(var i=0; i<forbidName.length; i++){
			if(forbidName[i] == ext){
				alert(ext+"확장자는 파일업로드 정책에 위배 됩니다.");
				return true;
			}
		}
		return false;
	}
</script>
</head>
<body>
	<header>
		<c:import url="/include/topMenu.do" />
	</header>
	<section>
		<div align="center">
		<h2>게시물 등록</h2>
		<hr width = "80%" />
		<br/>
		<form:form method="post" commandName="boardVO" action="${ pageContext.request.contextPath }/board/write.do">
			<table border="1" width="100%">
				<tr>
					<th width="25%">제목</th>
					<td>
						<form:input path="title" />
						<form:errors path="title" />
					</td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td>
						<form:hidden path="writer" />
						${ userVO.id }
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<form:textarea path="content" rows="15" cols="100%"/>
					</td>
				</tr>
			</table>
				<input type="submit" value=" 등록 "/>
		</form:form>
<%-- 	
		<form name = "writeForm" method = "post" action = "${ pageContext.request.contextPath }/board/write.do" onsubmit = "return doWrite()" 
				enctype = "multipart/form-data">
			<input type = "hidden" name = "writer" value = "${ userVO.id }"/>
			<table border = "1" width = "100%">
				<tr>
					<th width = "23%">제목</th>
					<td>
						<input type = "text" name = "title" size = "50"/>
					</td>
				</tr>
				<tr>
					<th width = "23%">글쓴이</th>
					<td>
						${ userVO.id }
					</td>
				</tr>
				<tr>
					<th width = "23%">내용</th>
					<td>
						<textarea rows="15" cols="100%" name = "content"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type = "file" name = "attachfile1"/>
						<input type = "file" name = "attachfile2"/>
					</td>
				</tr>
			</table>
			<br/>
			<input type = "submit" value = " 등록 " />&nbsp;&nbsp;
			<input type = "button" value = " 목록 " onclick = "doList()"/>
		</form> --%>
	</div>
	</section>
	<footer>
		<c:import url="/include/footer.do" />
	</footer>
</body>
</html>