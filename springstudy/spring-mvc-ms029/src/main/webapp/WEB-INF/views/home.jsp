<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>Hello Spring~!</h1>
<p> Server Time: ${serverTime}</p>

<table border="1">
<tr>
	<td width="100" align="center"><strong>no</strong></td>
	<td width="300" align="center"><strong>url</strong></td>
	<td width="200" align="center"><strong>title</strong></td>

</tr>

<tr>
	<td width="100" align="center"><strong>1</strong></td>
	<td width="300"><a href="/read01">/read01</a></td>
	<td width="200" align="center">Mission 30</td>
</tr>

<tr>
	<td width="100" align="center"><strong>2</strong></td>
	<td width="300"><a href="/read02">/read02</a></td>
	<td width="200" align="center">Mission 30</td>
</tr>

<tr>
	<td width="100" align="center"><strong>3</strong></td>
	<td width="300"><a href="/registerForm">/registerForm</a></td>
	<td width="200" align="center">Mission 31 & 32</td>
</tr>


</table>


</body>
</html>
