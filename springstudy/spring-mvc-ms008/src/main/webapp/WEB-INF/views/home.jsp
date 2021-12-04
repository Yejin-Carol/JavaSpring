<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">

   <title>SPRING MISSION 008</title>
</head>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script type="text/javascript">

$(document).ready(function() {
	
	
	$("#postBtn").on("click", function() {
	      var boardNo = $("#boardNo");
	      var title = $("#title");
	      var content = $("#content");
	      var writer = $("#writer");

	      var boardNoVal = boardNo.val();
	      var titleVal = title.val();
	      var contentVal = content.val();
	      var writerVal = writer.val();

	      var boardObject = {
	         boardNo : boardNoVal,
	         title : titleVal,
	         content : contentVal,
	         writer : writerVal
	      };

	      $.ajax({
	         type : "get",
	         url : "/board/" + boardNoVal,
	         data : JSON.stringify(boardObject),
	         contentType : "application/json; charset=utf-8",
	         success : function(result) {
	            console.log("result: " + result);
	            if (result === "SUCCESS") {
	               alert("SUCCESS");
	            }
	         }
	      });
	   });
	

   $("#getBtn").on("click", function() {
      var boardNo = $("#boardNo");
      var boardNoVal = boardNo.val();
      
      console.log(boardNoVal);
      
      alert(JSON.stringify(data));
   });

	
   $("#geJsonBtn").on("click", function() {
	      var boardNo = $("#boardNo");
	      var boardNoVal = boardNo.val();
	      
	      console.log(boardNoVal);
	     
   $.ajax({
	          type : "get",
	          url : "/board/" + boardNoVal,
	          headers : {
	          "Accept" : "application/json"
	          },
	          success : function(result) {
	          console.log("result:" + result);
	          alert(JSON.stringify(result));
	          }
	          });
	       
   });

});





 /*     $.ajax({
         type : "POST",
         url : "/board/" + boardNoVal,
         success : function(result) {
            console.log("result: " + result);
            if (result === "SUCCESS") {
               alert("SUCCESS");
            }
         }
      });
   });

   
   $("#method2").on("click", function() {
	      var boardNo = $("#boardNo");
	      var title = $("#title");
	      var content = $("#content");
	      var writer = $("#writer");

	      var boardNoVal = boardNo.val();
	      var titleVal = title.val();
	      var contentVal = content.val();
	      var writerVal = writer.val();

	      var boardObject = {
	         boardNo : boardNoVal,
	         title : titleVal,
	         content : contentVal,
	         writer : writerVal
	      }; 
   
      $.ajax({
         type : "PUT",
         url : "/board/" + boardNoVal,
         data : JSON.stringify(boardObject),
         contentType : "application/json; charset=utf-8",
         success : function(result) {
            console.log("result: " + result);
            if (result === "SUCCESS") {
               alert("SUCCESS");
            }
         }
      });
   });

   $("#method3").on("click", function() {
	      var boardNo = $
	      ("#boardNo");
	      var title = $("#title");
	      var content = $("#content");
	      var writer = $("#writer");

	      var boardNoVal = boardNo.val();
	      var titleVal = title.val();
	      var contentVal = content.val();
	      var writerVal = writer.val();

	      var xmlData = "<Board>";
	         xmlData += "<boardNo>0</boardNo>";
	         xmlData += "<title>title1</title>";
	         xmlData += "<content>content1</content>";
	         xmlData += "<writer>writer1</writer>";
	         xmlData += "<regDate>2021-11-14</regDate>";
	         xmlData += "</Board>";

	      $.ajax({
	         type : "PUT",
	         url : "/board/" + boardNoVal,
	         data : JSON.stringify(boardObject),
	         contentType : "application/xml; charset=utf-8",
	         success : function(result) {
	            console.log("result: " + result);
	            if (result === "SUCCESS") {
	               alert("SUCCESS");
	            }
	         }
	      });
	   });
   
   
});*/
</script>

<body>
<h1>SPRING MISSION 008</h1>
      <h2>Ajax Request</h2>

   <form>
      boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
      title: <input type="text" name="title" value="" id="title"><br>
      content: <input type="text" name="content" value="" id="content"><br>
      writer: <input type="text" name="writer" value="" id="writer"><br>
   </form>

   <div>
      <button id="getBtn">수정</button>
      <button id="getJsonBtn">수정(Json)</button>
   </div>
</body>
</html>

