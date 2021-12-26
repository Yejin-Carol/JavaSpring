<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<html>
<head>
	<title>Mission 31</title>
</head>
<body>

<h3>Register Form</h3>

<h4>Mission31-1</h4>
<form action="register1" method="post">
     1. userId : <input type="text" name="userId" id="userId"><br>
     2. password : <input type="text" name="password" id="password"><br>
<input type="submit" value="제출">
</form>

<h4>Mission31-2</h4>
<form action="register2" method="post">
<div>1. userId : <input type="text" name="userId" value="test"></div>
<div>2. password : <input type="text" name="password" value="1234"></div>
<input type="submit" value="제출">
</form>

<h4>Mission32</h4>
<form action="register3" method="post">
<div>1. userId : <input type="text" name="userId"></div>
<div>2. password : <input type="text" name="password"></div>
<input type="submit" value="제출">
</form>


</body>
</html>
