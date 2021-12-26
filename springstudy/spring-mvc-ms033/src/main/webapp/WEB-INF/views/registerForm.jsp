<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<html>
<head>
	<title>Mission 33~</title>
</head>
<body>

<h3>Register Form</h3>

<form:form modelAttribute="member" action="/register" method="post">
	<table border="1">
		<tbody>
		<tr>
			<th>유저ID</th>
			<td>
				<input type=text id="userId" name="userId" />
				<!-- <form:errors path="userId" cssClass="error" /> -->
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type=password id="password" name="password" />
				<!-- <form:errors path="password" cssClass="error" /> -->
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="username" id="username" name="username" />
				<!-- <form:errors path="username" cssClass="error" /> -->
			</td>
		</tr>
		<tr>
			<th>Email</th>
			<td>
				<input type="email" id="email" name="email" />
				<!-- <form:errors path="email" cssClass="error" /> -->
			</td>
		</tr>	
		<tr>
			<th>Gender</th>
			<td>
				<input type="radio" name="gender" value="Male">
				<label for="Male">Male</label>
				<input type="radio" name="gender" value="Female">
				<label for="Female">Female</label>
				<input type="radio" name="gender" value="Other">
				<label for="Other">Other</label>

			</td>
		</tr>	
		</tbody>
	</table>
</form:form>
<input type="submit" value="등록"/>
</body>
</html>
