<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registeAllForm</title>
</head>
<body>

	<h1>registerAllForm</h1>
	<form action="/registerUser" method="post">
	 1. userId: <input type="text" name="userId"><br>
     2. password: <input type="password" name="password"><br>
     3. userName: <input type="text" name="userName"><br>
     4. email: <input type="text" name="email"><br>
	 5. dateOfBirth: <input type="text" name="dateOfBirth"><br>
     6. gender:<br>
     <label>
     <input type="radio" name="gender" value="male" checked> Male</label> <br>
  	 <label>
  	 <input type="radio" name="gender" value="female"> Female </label><br>
     7. developer:     
     <input type="checkbox" name="foreigner" value="Y" checked> 
  	<label for="developer">Y</label><br>
  	 8. foreigner:     
     <input type="checkbox" name="developer" value="false" checked> 
  	<label for="foreigner">false</label><br>
     9. nationality:
 	<select name="nationality" id="nationality" form="form">
	  <option value="Korea">Korea</option>
	  <option value="Japan">Japan</option>
	  <option value="China">China</option>
	</select><br>
	10. cars:
	<select name="cars" id="cars" form="carform">
	  <option value="volvo">Volvo</option>
	  <option value="saab">Audi</option>
	  <option value="opel">Genesis</option>
	</select><br>
	11. carArray:
	<select name="cars" id="cars" form="carform">
	  <option value="volvo">Volvo</option>
	  <option value="saab">Audi</option>
	  <option value="opel">Genesis</option>
	</select><br>
	12. carList:
     <select name="cars" id="cars" form="carform">
	  <option value="volvo">Volvo</option>
	  <option value="saab">Audi</option>
	  <option value="opel">Genesis</option>
	</select><br>
	13. hobby: <br>
	<input type="checkbox" id="hobby1" name="hobby1" value="Sports">
	<label for="vehicle1"> Sports </label><br>
	<input type="checkbox" id="hobby2" name="hobby2" value="Music">
	<label for="vehicle2"> Music </label><br>
	<input type="checkbox" id="hobby3" name="hobby3" value="Movie">
	<label for="vehicle3"> Movie </label><br>
	14. hobbyArray: <br>
	<input type="checkbox" id="hobby1" name="hobby1" value="Sports">
	<label for="vehicle1"> Sports </label><br>
	<input type="checkbox" id="hobby2" name="hobby2" value="Music">
	<label for="vehicle2"> Music </label><br>
	<input type="checkbox" id="hobby3" name="hobby3" value="Movie">
	<label for="vehicle3"> Movie </label><br>
	15. hobbyList: <br>
	<input type="checkbox" id="hobby1" name="hobby1" value="Sports">
	<label for="vehicle1"> Sports </label><br>
	<input type="checkbox" id="hobby2" name="hobby2" value="Music">
	<label for="vehicle2"> Music </label><br>
	<input type="checkbox" id="hobby3" name="hobby3" value="Movie">
	<label for="vehicle3"> Movie </label><br>
	16. address.postCode: <br>
	<input type="text" name="address.postCode"><br>
	17. address.location<br>
	<input type="text" name="address.location"><br>
	18. carList[0].no<br>
	<input type="text" name="carList[0].no"><br>
	19. carList[0].validMonth	<br>
	<input type="text" name="carList[0].validMonth"><br>
	20. carList[1].no<br>
	<input type="text" name="carList[1].no"><br>
	21. carList[1].validMonth	<br>
	<input type="text" name="carList[1].validMonth"><br>
	22. introduction <br>
	<input type="textarea" name="introduction"><br>
	23. 전송<br>
     <input type="submit" value="전송"><br>
   	24. 리셋<br>
   	<input type="reset" value="리셋"><br>
   	</form>   	
	
	<h1>Mission 26</h1>
	<form action="/registerFile01" method="post" enctype="multipart/form-data">
	<input type="file" name="picture">
	<input type="submit" value="전송"><br>
	</form>
	
</body>
</html>