<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
</head>
<body>
	${error }
	<h3>회원삭제검색</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get">
		조회 아이디 : <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="Search"><br>
	</form>
	
	<h3>회원삭제</h3>
	<form action="${pageContext.servletContext.contextPath }/memberDelete.do" method="post">
		조회 아이디 : <input type="text" name="id" value="${member.id }"><br>
		<input type="submit" value="삭제"><br>	
	</form>
	<jsp:include page="/memberResult/home.jsp"></jsp:include>
		
</body>
</html>