<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
tr {
	align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/Lecture-Web/jquery/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	
	
	function selectText(){
		var text = document.getSelection();
		return text;
	}
	document.onmouseup = function() {
		document.getElementById("textArea").innerHTML = selectText();
	}
	
	$(document).ready(function(){
		if($('#color2')){
			document.getElementById("textArea").innerHTML.style.color = "blue";
		}
	});
	
	function leftClick(){
		document.inputForm.value
	}
</script>
</head>
<body>
	<form name="inputForm">
		<div align="center">
			<table border="1" width="50%">
				<tr style="background-color: lightblue">
					<td align="center">글자크기<select name="fontSize">
							<option value="10pt">10pt</option>
							<option value="12pt">12pt</option>
							<option value="14pt">14pt</option>
					</select></td>
					<td align="center">글자색깔<select name="fontColor">
							<option value="red" id="color1">빨강</option>
							<option value="blue" id="color2">파랑</option>
							<option value="green" id="color3">초록</option>
					</select></td>
					<td align="center">글자모양<select name="fontStyle">
							<option value="normal">normal</option>
							<option value="italic">italic</option>
							<option value="oblique">oblique</option>
					</select></td>
				</tr>
				<tr>
					<td align="center"><input type="button" value="왼쪽정렬" onclick = "leftClick()"></td>
					<td align="center"><input type="button" value="가운데정렬" onclick = "centerClick()"></td>
					<td align="center"><input type="button" value="오른쪽정렬" onclick = "rightClick()"></td>
				</tr>
				<tr>
					<td colspan="3"><textarea rows="10%" cols="100%"
							name="textArea" id="textArea"></textarea></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>