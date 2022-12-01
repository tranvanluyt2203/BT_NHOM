<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=IOS-8859-1">
		<title>Welcome</title>
	</head>
	<body>
		HELLO <%=session.getAttribute("username") %>
	</body>
</html>