<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%session.invalidate();
	if (request.getAttribute("mess")!=null)
	{ %>
	<p><%=request.getAttribute("mess") %></p>
	<%} else {%>
	<p>Đã đăng xuất</p>
	<%} %>
	<p>Refresh để tải lại trang</p>
</body>
</html>