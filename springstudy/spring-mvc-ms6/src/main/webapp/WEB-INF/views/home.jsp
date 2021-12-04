<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {

   $("#putHeaderBtn").on("click", function() {
      var boardNo = $("#boardNo");
      var boardNoVal = boardNo.val();
      var boardObject = {
         boardNo : boardNoVal,
         
      };

      $.ajax({
         type : "put",
         url : "/board/" + boardNoVal,
         headers : {
            "X-HTTP-Method-Override" : "PUT"
         },
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

});
</script>
	
</head>
<body>

<h1>SPRING MISSION 006</h1>
   <h2>Ajax Request</h2>

   <form>
      boardNo: <input type="text" name="boardNo" value="" id="boardNo"><br>  
   </form>
  
   
   <div>
      <button id="putHeaderBtn">수정(put with header)</button>
   </div>


</body>
</html>

