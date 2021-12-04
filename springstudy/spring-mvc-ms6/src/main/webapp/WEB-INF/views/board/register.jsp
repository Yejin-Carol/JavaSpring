<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING MISSION 005</title>
</head>
<body>
	<h1>REGISTER</h1>
	<h2>등록화면</h2>
	  
<form action="/board/post" method="post">
    <button type="submit" name="register">등록</button>
</form>

	<a href="/board/get?list">LIST</a>	
	<a href="/">HOME</a>
</body>
</html>