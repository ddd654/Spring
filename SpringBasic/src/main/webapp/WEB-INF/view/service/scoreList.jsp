<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

스코어

<br>


<!-- 23. 리스트 vo에 넣어서 하나하나 출력 -->
<c:forEach var="vo" items="${list }">
	${vo.name }<br>
	${vo.kor }<br>
	${vo.eng }<br>
	${vo.math }<br>
	<br>
</c:forEach>


<a href="scoreRegist">추가등록하기</a>



</body>
</html>