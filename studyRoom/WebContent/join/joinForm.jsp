<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoomLBJ/css/styles.css" rel="stylesheet"
   type="text/css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   
   $(document).ready(function() {
      $('#id').keyup(function() {
         idCheck();
      });
   });
</script>
<script>
   var httpRequest = null;
   function getXMLHttpRequest(){
      if(window.XMLHttpRequest){
         return new XMLHttpRequest();
      } else if(window.ActiveXObject){
         return new ActiveXObject("Microsoft.XMLHTTP");
      } else {
         return null;
      }      
   }
   
   function idCheck(){
      
      httpRequest = getXMLHttpRequest();
      var id = document.inputForm.id;
      sendRequest("GET", "${ pageContext.request.contextPath }/IdCheck.do?id="+id.value, null, callback);
   }
   
   function sendRequest(method, url, params, callback){
      httpRequest.onreadystatechange = callback;
      
      httpRequest.open(method, url, true)
      httpRequest.send(null);
   }
   
   function callback(){
      if(httpRequest.readyState == 4){
         if(httpRequest.status == 200){
            var msgView = document.getElementById("msgView");
            console.log(httpRequest.responseText);
            msgView.innerHTML = httpRequest.responseText;
         }
      }
   }

   function goResister() {

      var form = document.inputForm;

      if (form.id.value == "") {
         alert("아이디를 입력하시오.");
         return false;
      }
      if(document.getElementById("msgView").innerText.substring(0,4) != '사용가능'){
         alert("아이디를 다시 확인하세요");
         form.id.focus();
         return false;
      }
      if (form.password.value == "") {
         alert("비밀번호를 입력하시오.");
         return false;
      }
      if (form.name.value == "") {
         alert("이름을 입력하시오.");
         return false;
      }
      if (form.phone.value == "") {
         alert("전화번호를 입력하시오.");
         return false;
      }
      if (form.password.value != form.password2.value) {
         alert("비밀번호를 확인하시오.");
         return false;
      }

      alert("회원가입을 축하합니다!!!");
      return true;

   }
</script>

</head>
<body>
<div class="wrapper">
<header>
      <%@include file="/include/header.jsp"%>
</header>
   <div class="text-center" style="padding: 50px 0">
      <div class="login-form-1">
      <h2>회원 가입</h2>
         <form id="register-form" class="text-left" name="inputForm"
            method="post" action="${ pageContext.request.contextPath }/join2.do"
            onsubmit="return goResister()">
            
            <div class="login-form-main-message"></div>
            <div class="main-login-form">
               <div class="login-group">
                  <div class="form-group">
                  <input type="text" class="form-control" name="id" id="id" placeholder="아이디">
                  <span id = "msgView"></span>   
                  </div>
                  <span name="duplicate" id="duplicate" style="font-size: 15px"></span>


                  <div class="form-group">
                     <input type="password" class="form-control" name="password"
                        placeholder="비밀번호">
                  </div>

                  <div class="form-group">
                     <input type="password" class="form-control" name="password2"
                        placeholder="비밀번호 확인">
                  </div>
                  <div class="form-group">
                     <input type="text" class="form-control" name="name"
                        placeholder="이름">
                  </div>
                  <div class="form-group">
                     <input type="tel" class="form-control" name="phone"
                        placeholder="전화번호">
                  </div>
               </div>
               <button type="submit" class="login-button">
                  <i class="fa fa-chevron-right"></i>
               </button>
            </div>
         </form>
      </div>
   </div>
</div>
<footer>
      <%@include file="/include/footer.jsp"%>
</footer>
</body>
</html>