<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/felizvida/resources/index.css">
<script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
svg {
	width: 320px;
	height: 240px;
	border: 5px solid black;
	margin-left: 20px;
}

.bar {
	fill: red;
}
</style>
</head>
<body>
<!-- 
	0 ~ 1
	0.00000001 * 300 = 0 + 1
	0.99999999 * 300 =300 + 1
 -->
	<form action="logincheck" method="post">
	<div>${ sessionScope.dto.id}님 환영 합니다.</div>
		<div id="root">
			<div class="container">
				<div class="left_panel"
					style="padding-top: 30px; padding-left: 10px;">
					<h1>데이터에 따른 그래프 표시</h1>
					<svg id="myGraph"></svg>
					<div>
						<button type="button" id="testBtn">Update</button>
					</div>					
<!-- 					<script src="/felizvida/resources/d3/sample01.js"></script> -->
						<script src="/felizvida/resources/d3/sample03.js"></script>
				</div>
				<div class="right_panel">
					<div class="right_panel_main">piechart</div>
				</div>
			</div>			
		</div>
	</form>
</body>
</html>