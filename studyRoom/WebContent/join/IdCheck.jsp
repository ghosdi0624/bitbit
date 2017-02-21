<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ not empty id }">
   <c:if test="${ b }">
      <div style="font-size:8pt; color:red">사용불가</div>
   </c:if>
   <c:if test="${ !b }">
      <div style="font-size:8pt">사용가능</div>
   </c:if>
</c:if>