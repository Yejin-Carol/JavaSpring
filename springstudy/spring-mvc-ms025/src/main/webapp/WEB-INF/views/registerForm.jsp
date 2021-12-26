<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

   $("#registerBtn01").on("click",function(){
		$.get("/register/test", function(result){
			console.log("result:" + result);
			if(result === "SUCCESS") {
				alert("SUCCESS");
			}
		});
	});


	$("#registerBtn02").on("click".function(){
		
		let userId = $("#userId");
		let password = $("#password");
		let userIdVal = userId.val();
		let passwordVal = password.val();
		
		var userObject = {userId: userIdVal, password: passwordVal};
		
		$.ajax({
			type:"post"
			url: "/register02?userId=user01",
					data:JSON.stringify(userObject),
					contentType: "application/json; charset=utf-8",
					success: function(result) {
						console.log("result: " + result);
						if(result === "success") {
							alert("success");
						}
					}
				});
			});
			
 		
	$("#inputFile").on("change", function(event){
		
		
		console.log("change");

		let files = event.target.files;
		let file = files[0];
		let formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			type: "post",
			url: "/uploadAjax",
			data: formData,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			success: function (data) {
			alert(data);
			}
		});
	});
 
});
</script>

<body>
	<h1>Mission 27</h1>

	<button id="registerBtn01">registerBtn01</button>
	<br>
	<button id="registerBtn02">registerBtn02</button>
	<br>


	<h1>Mission 28</h1>

	<input type="file" id="inputFile">
</body>

</html>