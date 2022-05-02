<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>


	<%-- 
		http://localhost/JSPProject/index.jsp?user_id=hong&user_name=홍길동
		get 방식

		http://localhost/JSPProject/index.jsp
		post 방식
		
		webapp 폴더가 제일 최상위.
	--%>
	
	<form name="frm" action="StudentGetServlet" method="get">
		<input type="hidden" name="cmd" value="search">
		ID : <input type="number" name="user_id" value="111"><br>
		Name : <input type="text" name="user_name" value="홍길동"><br>
		Eng : <input type="number" name="eng_score"><br>
		Kor : <input type="number" name="kor_score"><br>
		<input type="submit" value="조회">	<%-- 조회의 경우 doGet 방식 많이 이용, 그 외 doPost --%>
		<input id="listBtn" type="button" value="전체조회">
		<input id="addBtn" type="button" value="입력">
		<input id="modBtn" type="button" value="수정">
		<input id="delBtn" type="button" value="삭제"> <%-- Post형식 --%>
	</form>
	<hr>
	<a href="studentList.jsp">학생목록</a>
	
	
	<script>
	
		let modBtn = document.getElementById('modBtn');
		modBtn.addEventListener('click', function(){
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "mod";
			frm.submit(); // submit 버튼을 클릭.
		});
		
		let delBtn = document.getElementById('delBtn')
		delBtn.addEventListener('click', function(){
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "del";
			frm.submit(); // submit 버튼을 클릭.
			
		});
	
		let btn = document.querySelector('#addBtn');
		btn.addEventListener('click', function(){
			let frm = document.forms.frm;

			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add";
			
			frm.submit(); // form의 submit.
		});
		
		let listBtn = document.getElementById('listBtn');
		listBtn.addEventListener('click', function(){
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "listBtn";
			frm.submit();
		
		})
		
	</script>
	
</body>
</html>