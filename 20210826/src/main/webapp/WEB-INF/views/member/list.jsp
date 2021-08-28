<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List title here</title>
<style type="text/css">
	table,tr{
		border: 1px solid black;
	}
	td{
		padding: 3px;
	}

	a{
		background-color: #aaa;
		padding: 3px;
/* 		margin: 2px; inline 태그라 margin 안먹힘*/
		border-radius: 5px;
		text-decoration: none;
		color: #ddd;
	}
	a:visited {
		color: #ddd;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$('document').ready( function(){
		
		//$('#update').on('click', function(){ alert('누름'); } );
	
	} );
</script>
</head>
<body>
<h1>list</h1><br>
<%-- ${aa}<br> --%>
<%-- ${alist}<br> --%>
<%-- <c:forEach items="${alist}" var="dto"> --%>
<%-- 	${dto}<br> <!-- toString에 해당 --> --%>
<%-- </c:forEach><br> --%>
<div style="margin-bottom: 30px;"><a href="/review">home</a></div>
<div>
	<table>
		<tr>
			<th>idx</th>
			<th>id</th>
			<th>pw</th>
			<th>age</th>
			<th>gender</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${alist}" var="dto">
			<tr>
				<td>${dto.idx}</td>
				<td>${dto.id}</td>
				<td>${dto.pw}</td>
				<td>${dto.age}</td>
				<td>${dto.gender}</td>
				<td>
					<a href="memberupdateform?idx=${dto.idx}">수정</a>
<!-- 				<button id="update">수정</button> -->
				</td>
				<td>
					<a href="memberdelete?idx=${dto.idx}">삭제</a>
<!-- 				<button id="delete">삭제</button> -->
				</td> 
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>