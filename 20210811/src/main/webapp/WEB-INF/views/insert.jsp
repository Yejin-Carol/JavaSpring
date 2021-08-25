<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>insert/delete/update</h1>

<form id=frm action="insertproc" method="post">
	<input type="text" name="para1"/>
	<input type="text" name="para2"/>
	<input type="submit" value="입력"/>	
</form>
<div id="send">aaa</div>



<form action="deleteproc" method="post">
	<input type="text" name="para1"/>
	<input type="submit" value="삭제"/>	
</form>


<form action="updateproc" method="post">
	<input type="text" name="para1"/>
	<input type="text" name="para2"/>
	<input type="submit" value="수정"/>	
</form>

</body>
</html>