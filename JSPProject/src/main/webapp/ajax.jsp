<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax.jsp</title>
</head>
<body>
	<script>
		// Asynchronous Javascript And Xml : AJAX : 처리 방식이 비동기 방식
		let url = 'StudentGetServlet';
		fetch(url)
			.then(result => {
				console.log(result);
				return result.json(); // {"id":23,"name":"hong"} : json 타입.
									  // fetch : return값을 promise 값으로 반환.
			})
			.then(result => { 
				console.log(result);
			})
			.catch(error =>{
				console.log(error);
			})
		
	</script>
</body>
</html>