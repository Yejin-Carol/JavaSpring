<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<html>
<head>
   <title>SPRING MISSION 007</title>
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
         type : "post",
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

   
   $("#putJsonBtn").on("click", function() {
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
	         type : "put",
	         url : "/board/" + boardNoVal,
	         contentType : "application/json; charset=utf-8",
	         data : JSON.stringify(boardObject),
	         success : function(result) {
	            console.log("result: " + result);
	            if (result === "SUCCESS") {
	               alert("SUCCESS");
	            }
	         }
	      });
	   });
   
  
   
});
</script>

<body>
<h1>SPRING MISSION 007</h1>
      <h2>Ajax Request</h2>

   <form>
      boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>
      title: <input type="text" name="title" value="" id="title"><br>
      content: <input type="text" name="content" value="" id="content"><br>
      writer: <input type="text" name="writer" value="" id="writer"><br>
   </form>

   <div>
      <button id="postBtn">수정</button>
      <button id="putJsonBtn">수정(Json)</button>
   </div>
</body>
</html>
