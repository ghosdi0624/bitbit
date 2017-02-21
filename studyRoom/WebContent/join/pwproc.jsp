<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
   function changePW(){
      var form = document.pwForm;
      if(form.oldpw.value==""){
         alert("기존 비밀번호를 입력하세요");
         form.oldpw.focus();
         return false;
      }
      if(form.newpw.value==""){
         alert("새로운 비밀번호를 입력하세요");
         form.newpw.focus();
         return false;
      }
      if(form.oldpw.value != '${pw}'){
         alert("기존 비밀번호가 일치하지 않습니다.");
         form.oldpw.focus();
         return false;
      } 
         
      return true;

   }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css" />
<link rel="stylesheet" href="/Mission-Web/css/board.css" />
</head>
<body>
<div align = "center">
<form name = "pwForm" onsubmit = "return changePW()" action = "${ pageContext.request.contextPath }/changePW.do" method = "post">
   <h3>비밀번호 변경</h3><br/>
   <table border = "0">
      <tr>
         <td>기존 비밀번호 : </td>
         <td><input type = "password" name = "oldpw"/></td>
      </tr>
      <tr>
         <td>새로운 비밀번호 : </td>
         <td><input type = "password" name = "newpw"/></td>
      </tr>      
   </table>
   <br/>
   <input type = "submit" value = " 변경 " />&nbsp;
   <input type = "button" value = " 취소 " onclick = "javascript:window.close()"/>
</form>
</div>
</body>
</html>