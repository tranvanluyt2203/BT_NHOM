<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/index.css">
	</head>
	<body>
		<div class="top">
			<%if (session.getAttribute("username")!=null) {%>
			<a href="WebContent/logout.jsp" target="page">Logout</a>
			<%}
			else 
			{%>
			<form action="LoginServlet" method="post" target="page">
				<input type="submit" value="Login">
			</form>
			<%} %>
			<form action="Register" method="post" target="page">
				<input type="submit" value="Register">
			</form>
		</div>
		<div class="bottom">
		<%if (session.getAttribute("username")!=null){ %>
			<iframe class="list" name="list" src="<%=session.getAttribute("type")%>">
		<%}
		else 
		{ %>
			<p class="list txt">Hãy đăng nhập để hiển thị mục này</p>
		<%} %>
			</iframe>
			<iframe class="page" name="page">
			</iframe>
			<iframe class="infor" name="infor" src="infor.html">
			</iframe>
		</div>
	</body>
</html>