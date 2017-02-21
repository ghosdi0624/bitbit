<%@page import="kr.co.bit.member.vo.BoardVO"%>
<%@page import="kr.co.bit.member.vo.ResvVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="/studyRoom/css/styles.css" rel="stylesheet" type="text/css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
<title>예약 현황</title>

</head>
<body>
	<header>
		<%@include file="/include/header.jsp"%>
	</header>
	<div align="center">
		<div class="page-title">예약 현황</div>
		<form name="refundHistory" method="post"
			action="${pageContext.request.contextPath }/refundSave.do">
			<table class="table table-striped">
				<tr>
					<th width="5%">예약번호</th>
					<th width="10%">아이디</th>
					<th width="10%">이름</th>
					<th width="10%">전화번호</th>
					<th width="5%">방번호</th>
					<th width="5%">인원수</th>
					<th width="5%">결제내역</th>
					<th width="15%">예약날짜</th>

				</tr>
				<%
					List<ResvVO> resv = (List<ResvVO>) request.getAttribute("list");
					List<BoardVO> board = (List<BoardVO>) request.getAttribute("boardMember");

					String payStatus = null;
					int status = 0;
					String date = null;

					for (int i = 0; i < resv.size(); i++) {

						status = resv.get(i).getStatus();
						date = "";
						date += resv.get(i).getDay().substring(0, 10);
						date += " ";
						date += String.valueOf(resv.get(i).getTime());
						date += "시~";
						date += String.valueOf(resv.get(i).getTime() + 1);
						date += "시 ";

						switch (status) {
						case 1:
							payStatus = "대기";
							break;
						case 2:
							payStatus = "결제완료";
							break;
						case 3:
							payStatus = "환불";
							break;
						}
				%>
				<tr>
					<input type="hidden" value="<%=resv.get(i).getRsv_no()%>" name="no" />
					<td><%=resv.get(i).getRsv_no()%></td>
					<td><%=resv.get(i).getMember_id()%></td>
					<%
						for (int j = 0; j < board.size(); j++) {
								if (board.get(j).getId().equals(resv.get(i).getMember_id())) {
					%>
					<td><%=board.get(j).getName()%></td>
					<td><%=board.get(j).getPhone()%></td>
					<%
						}
							}
					%>
					<td><%=resv.get(i).getRoom_name()%></td>
					<td><%=resv.get(i).getPersons_num()%></td>

					<td><select class="form-control selectWidth" name="payment">
							<%
								if (status == 1) {
							%>
							<option selected value="대기"><%=payStatus%></option>
							<option>결제완료</option>
							<option>환불</option>
							<%
								}
							%>
							<%
								if (status == 2) {
							%>
							<option>대기</option>
							<option selected value="결제완료"><%=payStatus%></option>
							<option>환불</option>
							<%
								}
							%>
							<%
								if (status == 3) {
							%>
							<option>대기</option>
							<option>결제완료</option>
							<option selected value="환불2">환불</option>
							<%
								}
							%>
					</select></td>
					<input type="hidden" value="<%=date%>" name="resvDate" />
					<td><%=date%></td>
				</tr>
				<%
					}
				%>
			</table>
			<br />
			
			
			<c:if test="${ pg > block }">
				<a href="${ pageContext.request.contextPath }/refund.do?pg=1">[◀◀]</a>
				<a
					href="${ pageContext.request.contextPath }/refund.do?pg=${ startpage-1 }">[◀전]</a>
			</c:if>
			<c:forEach var="i" begin="${ startpage }" end="${ endpage }">
				<c:if test="${ i == pg }">
                  [${ i }]
         </c:if>
				<c:if test="${ i != pg }">
					<a href="${ pageContext.request.contextPath }/refund.do?pg=${ i }">[${ i }]</a>
				</c:if>
			</c:forEach>
			<c:if test="${ endpage < allpage }">
				<a
					href="${ pageContext.request.contextPath }/refund.do?pg=${ endpage+1 }">[다음▶]</a>
				<a
					href="${ pageContext.request.contextPath }/refund.do?pg=${ allpage }">[▶▶]</a>
			</c:if>
			<br>

			 <input type="submit" value="저장" /> <input type="reset"
				value="되돌리기" />
		</form>
	</div>
	<footer>
		<%@include file="/include/footer.jsp"%>
	</footer>
</body>
</html>