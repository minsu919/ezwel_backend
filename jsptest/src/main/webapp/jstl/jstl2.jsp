<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- el,jstl 만 사용 
1> ...jstl2.jsp?num1=100&num2=200
2> 요청파라미터 2개 입력받아서 param내장객체
 합계 계산 <c:set  
 <c:if 또는 <c:choose
3> 200 이상이면 최상급니다 파랑색 글씨로 출력
4> 100 이상 200미만이면 중상급입니다 녹색 글씨로 출력
5> 100 미만이면 중하위급니다 빨강색 글씨로 출력

--%>
<c:set var="sum" value="${param.num1 + param.num2 }" />
${sum }

<c:choose>
	<c:when test="${ sum >= 200}">
	 	<h3 style="color:blue">최상급입니다.</h3>
	</c:when>
	<c:when test="${ sum >= 100 }">
 		<h3 style="color:green">중상급입니다.</h3>	
	</c:when>
	<c:otherwise>
 	 <h3 style="color:red">중하급입니다.</h3>
	</c:otherwise>
</c:choose>



<%-- 
<c:if test="${ sum >= 200}">
 <h3 style="color:blue">최상급입니다.</h3>
</c:if>
<c:if test="${ sum >= 100 && sum < 200}">
 <h3 style="color:green">중상급입니다.</h3>
</c:if>
<c:if test="${ sum < 100}">
 <h3 style="color:red">중하급입니다.</h3>
</c:if>
--%>

<%--
<% if(request.getParameter("num1") != null){
	Integer.parseInt(request.getParameter("num1"));
	}
if(request.getParameter("num2") != null){
	Integer.parseInt(request.getParameter("num2"));
	}
	%>
}
--%>




</body>
</html>










