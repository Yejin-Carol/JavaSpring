<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm</title>
</head>
<body>
	<h1>registerForm</h1>
	
	<h4>register01</h4>
	<a href='/register01?userId=aloha&dateOfBirth=2022/10/24'>register01 url</a><br>
	
	<h4>register02</h4>
	<form action="/register02" method="post">
	 userId: <input type="text" name="userId">
     password: <input type="password" name="password">
     dateOfBirth: <input type="text" name="dateOfBirth">
     <input type="submit" value="전송">
   </form><br>
   
   
   <h4>register03</h4>
	<form action="/register03" method="post">
	 uid: <input type="text" name="uid">
	 userId: <input type="text" name="userId">
     password: <input type="password" name="password">
     coin: <input type="text" name="coin">
     <input type="submit" value="전송">
   </form><br>
	
		
</body>
</html>