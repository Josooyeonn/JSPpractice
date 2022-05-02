<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>

<body>
	<h3>반갑습니다.</h3>

	<%
		//자바코드 : % 선언
		String name = "홍길동";
		out.println("<h3>" + name + "</h3>"); // 내장객체, jsp 파일 안에서 사용이 가능하도록 선언된 객체
		
		String id = request.getParameter("user_id");
		String name2 = request.getParameter("user_name");
		out.println("<h4>입력값 : "+ id + ", name : " + name2 + "</h4>");
		// parameter : input속성의 name 이름으로 지정.
	%>
	
	<a href="./student/student.do">Student Servlet</a>
</body>

</html>