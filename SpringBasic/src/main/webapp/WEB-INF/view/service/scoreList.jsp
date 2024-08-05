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
<c:forEach var="vo" items="${list }" varStatus="a"> 

<!-- 5) varStatus > 아래 location에 ${a.index} 추가 > 컨 -->
	${a.index}
	${a.count}
	
	${vo.name }<br>
	${vo.kor }<br>
	${vo.eng }<br>
	${vo.math }<br>
	<br>
	<!--2) onclick 붙이기 location.href가 요청 > 컨
		4) 키=값
	-->
	<button type="button" onclick="location.href='deleteScore?sno=${vo.sno}';">1) 삭제기능</button>
	<!-- 원래는 POST 지금은 겟 -->
	<hr>
</c:forEach>


<a href="scoreRegist">추가등록하기</a>



</body>
</html>