<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.BEAN.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Chỉnh sửa thông tin sinh viên</h1>
	<form action="AddSV" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="ID" id="ID" value="" readonly></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="Name" id="Name" value=""></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="Age" id="Age" value=""></td>
			</tr>
			<tr>
				<td>Diem</td>
				<td><input type="text" name="Diem" id="Diem" value=""></td>
			</tr>
		</table>
		<input type="submit" name="add" value="Add">
	</form>
</body>
</html>