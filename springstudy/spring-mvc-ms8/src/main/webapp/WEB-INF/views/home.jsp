<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<html>
<head>
   <title>SPRING MISSION 008</title>
</head>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script type="text/javascript">

	function method1() {
   		 var url = "/board/" + $('#boardNo1').val();
   
    $.ajax({
       url : url,
       type : "GET",
       success: function (result) {
             alert("result : " + result);
          }
    });
 }

   
	function method2() {
		var url = "/board/" + $('#boardNo2').val();
	    
	      $.ajax({
	    	  url : url,
	          type : "GET",
	    	  contentType : "application/json",
	         success : function(result) {
	               alert("result : " + result);
	            }
	      });
	   }   
</script>

<body>
<h1>SPRING MISSION 008</h1>
      <h2>Ajax Request</h2>

   <form>
     <input type="text" id="boardNo1">
      <button type="button" onclick="method1()">수정</button>
   </form>
	
   <form>
      <input type="text" id="boardNo2">
      <button type="button" onclick="method2()">수정</button>
   </form>
	
</body>
</html>
