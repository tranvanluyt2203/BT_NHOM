<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>Insert title here</title>	
	</head>
	<body>
		<form action="Register" method="post" >
			Username : <input type="text" name="usernamer">
			Password : <input type="text" name="passwordr">
			<p>
			<label for="admin">Admin</label>
			<input type="radio" name="type" id="admin" value="admin">
			</p>
			<p>
			<label for="user">User</label>
			<input type="radio" name="type" id="user" value="user">
			</p>
			<input type="submit" value="Register">
		</form>
	</body>
</html>