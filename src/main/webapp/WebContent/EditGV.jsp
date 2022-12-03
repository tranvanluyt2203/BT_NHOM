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
	<form action="EditGVDetails" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="ID" id="ID"
					value="<%=gv.getid()%>"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="Name" id="Name"
					value="<%=gv.getname()%>"></td>
			</tr>

			<tr>
				<td>Age</td>
				<td><input type="text" name="Age" id="Age"
					value="<%=gv.getage()%>"></td>
			</tr>
			<tr>
				<td>Lesson</td>
				<td><input type="text" name="Diem" id="Diem"
					value="<%=gv.getlesson()%>"></td>
			</tr>
		</table>
		<input type="submit" name="edit" value="Edit">
	</form>
</body>
</html>