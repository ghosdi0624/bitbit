<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      $('#btn').click(function(){
         if(confirm("정말 탈퇴 하시겠습니까?")){
            location.href = '${ pageContext.request.contextPath }/resign.do';
         }
      });
   });

   function changePW(){
      window.open("${ pageContext.request.contextPath }/pwproc.do","비밀번호 변경","width=400, height=200");
   }
</script>
</head>
<body>
<div class="wrapper">
<header>
		<%@include file="/include/header.jsp"%>
</header>
<div align="center">
   <h2 class="header">나의 상태보기</h2>
   <br/>
   
   <h3>${sessionScope.name} 님의 예약현황</h3><br/>
   <h3>예약상태 보기</h3>
   <br/>
         <table class="rsvTable">
            <tr>               
               <th width="25%">방이름</th>
               <th width="25%">인원수</th>
               <th width="25%">결제내역</th>            
               <th width="25%">예약날짜</th>      
            </tr>   
            <c:forEach var="info" items="${ info }">
            <tr>
               <td>${ info.room_name }</td>   
               <td>${ info.persons_num }</td>   
               <c:if test="${ info.status eq 1}">
               <td>대기</td></c:if>   
               <c:if test="${ info.status eq 2}">
               <td>결제완료</td></c:if>   
               <c:if test="${ info.status eq 3}">
               <td>환불</td></c:if>   
               <td>${ info.day }&nbsp;&nbsp;${ info.time }:00 ~ ${ info.time +1 }:00</td>   
            </tr>
            </c:forEach>            
         </table><br/>   
   <input class="btn btn-default" type= "hidden" value="${sessionScope.id}"  name="id" />
   <input class="btn btn-default" type ="button" value =" 비밀번호 변경 " onclick = "changePW()"/>
   <input class="btn btn-default" type= "button" value="회원탈퇴" id="btn" />
</div>
</div>
<footer>
      <%@include file="/include/footer.jsp"%>
</footer>
</body>
</html>