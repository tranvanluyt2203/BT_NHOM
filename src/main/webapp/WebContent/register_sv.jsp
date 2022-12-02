<%@page import="Model.BEAN.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Xin chào <%=session.getAttribute("username") %></h2>
		<form action="RegisterSV" method="get">
			Id : <input type="text" value="<%=request.getAttribute("id") %>" name="id" readonly>
			<br>
			Name : <input type="text" name="name">
			<br>
			Age : <input type="text" name="age">
			<br>
			Teacher : <select name="GV">
			<% for (int i=0;i<Integer.parseInt(request.getAttribute("size").toString());i++)
			{%>
				<option value="<%=request.getAttribute("idgv"+String.valueOf(i)) %>">
					<%=request.getAttribute(String.valueOf(i)) %>
				</option>
			<%} %>
			</select>
			<input type="submit" value="Register">
		</form>
	</body>
</html>