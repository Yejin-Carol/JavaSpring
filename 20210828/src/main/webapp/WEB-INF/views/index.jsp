<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/20210828/resources/index.css">
<title>Insert title here</title>
</head>
<body>
	<form action="loginchk" method="post">
		<div id="root">
			<div class="container">
				<div class="left_panel">
					<img src="/20210828/resources/images/sloth3.jpg">
				</div>
				<div class="right_panel">
					<div class="right_panel_main">
						<div>
							<h3>로그인</h3>
						</div>
						<div>
							<h5>ID</h5>
						</div>
						<div>
							<input type="text" name="id">
						</div>
						<div>
							<h5>비밀번호</h5>
						</div>
						<div>
							<input type="text" name="pw">
						</div>
						<div>
							<input type="submit" value="로그인">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>