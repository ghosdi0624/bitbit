<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<!-- Smart Editor -->
<script type="text/javascript" src="/studyRoom/se2/js/jindo.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="/studyRoom/se2/js/HuskyEZCreator.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript"
	src="/studyRoom/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js"
	charset="utf-8"></script>

<script type="text/javascript">
	function doList() {
		location.href = "${pageContext.request.contextPath}/list.do";
	}
	function doWrite() {
		var form = document.writeForm;
		if (form.title.value == "") {
			alert("제목을 입력해 주세요");
			form.title.focus();
			return false;
		}
		if (form.content.value == "") {
			alert("내용을 입력하세요");
			form.content.focus();
			return false;
		}
		return true;
	}
	//전역변수선언
	var editor_object = [];
		$(function() {
			nhn.husky.EZCreator.createInIFrame({
				oAppRef : editor_object,
				elPlaceHolder : "content",
				sSkinURI : "/studyRoom/se2/SmartEditor2Skin.html",
				htParams : {
					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseToolbar : true,
					// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true,
					// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true,
				}
			});
			//전송버튼 클릭이벤트
			$("#submitBtn").click(
					function() {
						//id가 smarteditor인 textarea에 에디터에서 대입
						editor_object.getById["content"].exec(
								"UPDATE_CONTENTS_FIELD", []);
						// 이부분에 에디터 validation 검증
						//폼 submit
						$("#writeForm").submit();
					});
		});

		// textArea에 이미지 첨부
		function pasteHTML(fname) {
			var sHTML = '<img src="<%=request.getContextPath()%>/upload/'+ fname + '" width="300px;">';
			<%--  var sHTML = '<img src="<%=request.getContextPath()%>/upload/'+ fname + '" width="300px;">';  --%>
		editor_object.getById["content"].exec("PASTE_HTML", [ sHTML ]);
		document.frm2.ss2.value = sHTML;
		document.frm.smarteditor.innerHTML = sHTML;

	}
</script>
</head>
<body>
	<div class="wrapper">
		<header>
			<%@include file="/include/header.jsp"%>
		</header>
		<section>
			<div align="center">
				<h2>글 쓰기</h2>
				<br />
				<form name="writeForm" id="writeForm" method="post"
					action="${pageContext.request.contextPath}/write.do"
					onsubmit="return doWrite()">
					<table border="1">
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" style="width: 766px;" /></td>
						</tr>
						<tr>
							<th>글쓴이</th>
							<td><c:out value="${sessionScope.id }" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td width="766px"><textarea name="content" id="content"
									rows="10" cols="100" style="width: 766px; height: 412px;"></textarea></td>
						</tr>
					</table>
					<input type="hidden" name="writer" value="${sessionScope.id }">
					<input type="hidden" name="reply" value="${reply }">
					<%-- 답글여부 --%>
					<c:choose>
						<c:when test="${sessionScope.id eq 'admin'}">
							<input type="hidden" name="type" value="n">
						</c:when>
						<c:otherwise>
							<input type="hidden" name="type" value="q">
						</c:otherwise>
					</c:choose>
					<br /> <input type="button" value="등록" id="submitBtn" />&nbsp;&nbsp;
					<input type="button" value="목록" onclick="doList()" />
				</form>
			</div>
		</section>
	</div>
	<footer>
		<%@include file="/include/footer.jsp"%>
	</footer>
</body>
</html>