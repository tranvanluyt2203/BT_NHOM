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
	<%
	GV gv = (GV) request.getAttribute("gv");
	%>
	<h1>Chỉnh sửa thông tin giảng viên</h1>
	<form action="EditDetails" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" id="id"
					value="<%=gv.getid()%>" readonly></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name"
					value="<%=gv.getname()%>"></td>
			</tr>

			<tr>
				<td>Age</td>
				<td><input type="text" name="age" id="age"
					value="<%=gv.getage()%>"></td>
			</tr>
			<tr>
				<td>Lesson</td>
				<td><input type="text" name="lesson" id="lesson"
					value="<%=gv.getlesson()%>"></td>
			</tr>
		</table>
		<input type="submit" name="edit" value="Edit">
	</form>
</body>
</html>