<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서삭제조회</h3>
    <form action="${pageContext.servletContext.contextPath }/searchBook.do" method="get">
        <input type="text" name="bookCode" id=""><br>
        <input type="hidden" name="job" value="remove">
        <input type="submit" value="조회">
    </form>
	
	<form action="${pageContext.servletContext.contextPath }/removeBook.do" method="post">
		<input type = "text" name="title" readonly="readonly" value=${book.bookTitle }><br>
    	<input type = "text" name="author" readonly="readonly" value=${book.bookAuthor }><br>
    	<input type = "text" name="press" readonly="readonly" value=${book.bookPress }><br>
    	<input type = "number" name="price" readonly="readonly" value=${book.bookPrice } ><br>
    	<input type = "hidden" name="code" value=${book.bookCode }>
    	<input type= "submit" value="삭제"> 	
	</form>

    <!-- 도서삭제를 위한 화면 작성코드를 입력하세요. -->

    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>