<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING MISSION 005</title>
</head>
<body>
	<h1>REMOVE</h1>
	<h2>삭제화면</h2>
<form action="/board/post" method="post">
    <button type="submit" name="remove">삭제</button>
</form>
   	<a href="/board/get?list">LIST</a>
	<a href="/">HOME</a>
</body>
</html>