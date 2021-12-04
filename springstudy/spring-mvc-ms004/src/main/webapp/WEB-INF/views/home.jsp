<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING MISSION 004</title>
</head>
<body>
<h1>SPRING MISSION 004</h1>

	<form action="/board/register" method="get">
      <input type="submit" value="register (GET)">
   </form>

   <form action="/board/register" method="post">
      <input type="submit" value="register (POST)">
   </form>
   
   <form action="/board/modify"  method="get">
      <input type="submit" value="modify (GET)">
   </form>
   
   <form action="/board/modify" method="post">
      <input type="submit" value="modify (POST)">
   </form>
   
   <!-- 4번 read부분 어떻게? -->
   <form action="/board/read" method="get">
   	  <input type="text" name="boardNo">
      <input type="submit" value="read (GET)">
   </form>   
   
   <form action="/board/list" method="get">
      <input type="submit" value="list (GET)">
   </form>
    
   <form action="/board/remove" method="post">
      <input type="submit" value="remove (POST)">
   </form>

</body>
</html>
