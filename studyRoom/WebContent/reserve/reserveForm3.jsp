<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/70213049c5.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">

<!-- // jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- // jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- // jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   
   // 날짜 셋팅
   window.onload = function(){
       var today = new Date();
      var dd = addZero(today.getDate());
      var mm = addZero(today.getMonth()+1); 
      var yyyy = today.getFullYear();
      today = yyyy+'-'+mm+'-'+dd;
      if('${date}'==""){
         document.getElementById("testDatepicker").setAttribute("value", today);
      } else {
         document.getElementById("testDatepicker").setAttribute("value", '${date}');
      }
      // 오늘부터 1달후 말일
      var newDt = new Date(today);
      newDt.setMonth( newDt.getMonth() + 2 );
      newDt.setDate(0); 

      // 불러온 데이터로 테이블(td) 셋팅
      <c:forEach var="list" items="${ list }">
         var roomNo = 0;
         var time = "";
         switch('${list.roomName}'){
            case "검찰청" : roomNo = 1; break;
            case "관세청" : roomNo = 2; break;
            case "대통령" : roomNo = 3; break;
            case "국세청" : roomNo = 4; break;
            case "교육청" : roomNo = 5; break;
            case "경찰청" : roomNo = 6; break;
            case "소방청" : roomNo = 7; break;
         }
         if('${list.time}'=='9'){
            time ='09';
         }else{
            time = '${list.time}';
         }         
         var id =time+'td'+roomNo;
         var ids = document.getElementById(id);
         if('${list.status}'=='1'){
            ids.style.backgroundColor = "#fafafa";
            ids.innerHTML = "<span style='background:#0000ae; color:white'>예약대기</span>";
            ids.setAttribute('onclick','disabled');
         } else if('${list.status}'=='2'){
            ids.style.backgroundColor = "#fafafa";
            ids.innerHTML = "<span style='background:#c60000; color:white'>예약완료</span>";
            ids.setAttribute('onclick','disabled');
         }   
      </c:forEach>
   }
   
   $(function() {
       $( "#testDatepicker" ).datepicker({
            changeMonth: false, 
            dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
            dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
            monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)','7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
            monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
           minDate: 0, 
             maxDate: "+2M",
                dateFormat: "yy-mm-dd",
               showOn: "both",
               buttonImage: "${pageContext.request.contextPath}/img/button.gif", 
             buttonImageOnly: true
     });
   });

   var count = 0;
   // 상단 테이블(td) 클릭시 선택 여부 체크
   function checked(id2){
      var id = document.getElementById(id2);
      if(id.innerHTML == "선택"){
         count--;
         id.style.backgroundColor = "transparent";
         id.innerHTML = "";
         $('.'+id2).remove();
      
      } else{
         if(count > 3){
            alert("한번에 너무 많이 선택할 수 없습니다.");
            return;
         }
         id.style.backgroundColor = "#dee2e7";
         id.innerHTML = "선택";
         var getId = id.getAttribute('id');
         var time = getId.substring(0,2);
         var roomNo = getId.substring(4,5);
         $.ajax({
            url : "${ pageContext.request.contextPath }/reserveResponse.do",
            type : "GET",
            data : {
               id : getId,
               jTime : time,
               jRoomNo : roomNo
            },
            success : callback
         });
         count++;
      }
   }
   
   function callback(data){
      var list = eval(data.trim());
      var id = list[0].id;
      var time = parseInt(list[0].time);
      var roomName = list[0].roomName;
      var option = "<select name = "+id+" class = 'p_select form-control selectWidth2'><option value = '1'>1명</option><option value = '2'>2명</option><option value = '3' selected>3명</option><option value = '4'>4명</option><option value = '5'>5명</option><option value = '6'>6명</option></select>"
      
      $('#tblResult > tbody:last').append('<tr class = '+id+'><td align = "center">'+time+":00 ~ " + 
            (time+1)+':00</td><td align = "center">'+roomName+
            '</td><td align = "center">'+option+'</td><td align = "center"><input type = "button" value = " 선택취소 " class = "trcancel btn btn-default" /></td></tr>');   
   }
   
   // 하단 취소버튼 클릭시 상단 테이블(td) 선택 취소
   $(document).ready(function(){
      $(document).on("click",'.trcancel',function(){
         count--;
         var id = $(this).parent().parent().attr("class");
         var ids = document.getElementById(id);
         ids.style.backgroundColor = "white";
         ids.innerHTML = "";
         $(this).parent().parent().remove();
      }); 
   });
   
   // 예약하기 버튼 누르면 하단에 기록된 값 던지기 (시간, 방이름, 인원수)
   function goReserveProc(){
      var time = new Array();
      var roomName = new Array();
      var people = new Array();
      
      var array = $('#tbodyResult').children();

       for(var i=0; i<array.length; i++){
          var charray = $(array[i]).children();
          var parray = $(charray[2]).children();
          
          time[i] = ($(charray[0]).html().split(":")[0]); 
          roomName[i] = $(charray[1]).html(); 
          var peo = $(charray[2]).children();
          var name = $(peo).attr("name");
          people[i] = $("select[name="+name+']').val();
          
      } 
      document.reserveform.time.value = time;
      document.reserveform.roomName.value = roomName;
      document.reserveform.people.value = people;
      document.reserveform.action = "${ pageContext.request.contextPath }/reserveProc.do";
      document.reserveform.method = "POST";
      document.reserveform.submit();
   }

   //메인화면으로 취소버튼
   function goBack(){
      location.href = "${ pageContext.request.contextPath }/main.do";
   }
   
   // 월, 일에 0추가하기
   function addZero(i){ 
      var rtn = i + 100; 
      return rtn.toString().substring(1,3); 
   }
   
   
   function goMyForm(){
      var date = document.getElementById("testDatepicker").value;
      document.reserveform.action = "${ pageContext.request.contextPath }/reserveForm.do";
      document.reserveform.method = "POST";
      document.reserveform.submit();
   }
</script>
</head>
<body>
<div class="wrapper">
   <form name = "reserveform">
   <header>
      <%@include file="/include/header.jsp"%>
   </header>
   <section>
   <input type="hidden" name="time">
   <input type="hidden" name="roomName">
   <input type="hidden" name="people">
   <div align = "center">
   <h2>예약 정보</h2>
   <div align = "right" style = "width:80%">
   예약일 <input type="text" id="testDatepicker" name = "date" onchange="goMyForm()" readonly="readonly" size = "12">
   </div><br/>
      <table class="rsvTable">
         <tr>
            <th></th>
            <th>검찰청</th>
            <th>관세청</th>
            <th>대통령</th>
            <th>국세청</th>
            <th>교육청</th>
            <th>경찰청</th>
            <th>소방청</th>
         </tr>
         <tr>
            <th>09:00~10:00</th>
            <td class="sel" id = "09td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "09td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "09td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "09td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "09td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "09td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "09td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>10:00~11:00</th>
            <td class="sel" id = "10td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "10td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "10td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "10td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "10td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "10td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "10td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>11:00~12:00</th>
            <td class="sel" id = "11td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "11td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "11td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "11td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "11td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "11td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "11td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>12:00~13:00</th>
            <td class="sel" id = "12td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "12td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "12td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "12td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "12td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "12td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "12td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>13:00~14:00</th>
            <td class="sel" id = "13td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "13td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "13td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "13td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "13td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "13td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "13td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>14:00~15:00</th>
            <td class="sel" id = "14td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "14td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "14td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "14td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "14td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "14td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "14td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>15:00~16:00</th>
            <td class="sel" id = "15td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "15td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "15td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "15td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "15td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "15td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "15td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>16:00~17:00</th>
            <td class="sel" id = "16td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "16td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "16td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "16td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "16td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "16td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "16td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>17:00~18:00</th>
            <td class="sel" id = "17td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "17td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "17td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "17td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "17td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "17td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "17td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>18:00~19:00</th>
            <td class="sel" id = "18td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "18td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "18td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "18td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "18td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "18td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "18td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>19:00~20:00</th>
            <td class="sel" id = "19td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "19td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "19td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "19td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "19td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "19td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "19td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>20:00~21:00</th>
            <td class="sel" id = "20td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "20td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "20td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "20td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "20td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "20td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "20td7" onclick="checked(this.id)"></td>
         </tr>
         <tr>
            <th>21:00~22:00</th>
            <td class="sel" id = "21td1" onclick="checked(this.id)"></td>
            <td class="sel" id = "21td2" onclick="checked(this.id)"></td>
            <td class="sel" id = "21td3" onclick="checked(this.id)"></td>
            <td class="sel" id = "21td4" onclick="checked(this.id)"></td>
            <td class="sel" id = "21td5" onclick="checked(this.id)"></td>
            <td class="sel" id = "21td6" onclick="checked(this.id)"></td>
            <td class="sel" id = "21td7" onclick="checked(this.id)"></td>
         </tr>
      </table> <br/>
      <table class = "rsvTable" id = "tblResult">
         <tr>
            <th>Time</th>
            <th>RoomName</th>
            <th>People</th>
            <th>Cancel</th>
         </tr>
         <tbody id = "tbodyResult"></tbody>
      </table>
      <br/>
      <input type = "button" class="btn btn-default" value = " 예약하기 " onclick = "goReserveProc()"/>&nbsp;
      <input type = "button" class="btn btn-default" value = " 취소 " onclick = "goBack()"/><br/>
   </div>
   <br/>
   </section>
</div>
   </form>
	<footer>
		<%@include file="/include/footer.jsp"%>
	</footer>
</body>
</html>