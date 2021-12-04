<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm</title>
</head>
<body>
	<h1>registerForm</h1>
	<li>
	<a href='register?userId=test&password=123456'>method2 url</a><br>
	</li><br>
	<li>
	<a href='register/test'>method3 url</a><br>
	</li><br>
	
	<h4>method4 & 5 & 6</h4>
	<form action="/register01" method="post">
	 userId: <input type="text" name="userId">
     password: <input type="password" name="password">
     <input type="submit" value="전송">
   </form><br>   
		
	<h4>method7</h4>
	<form action="/register02" method="post">
	 userId: <input type="text" name="userId">
     password: <input type="password" name="password">
     coin: <input type="text" name="coin">
     <input type="submit" value="전송">
   </form><br>
   
</body>
</html>