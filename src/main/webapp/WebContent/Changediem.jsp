<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Changediem" method="post">
		<input type="text" name="diem" value="<%=request.getAttribute("diem")%>">
		<input type="submit" name="change" value="Change"> 
	</form>
</body>
</html>