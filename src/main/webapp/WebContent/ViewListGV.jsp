<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.BEAN.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h1>Thông tin các giảng viên</h1>
    <% int i=1; List<GV> list_gv = (List<GV>) request.getAttribute("ListGV");
            for(GV gv : list_gv)
            { %>
                <div>
                    <h3>
                        <%=i%>.<%=gv.getname() %>
                    </h3>
                </div>
                <table>
                    <tr>
                        <td>ID</td>
                        <td>
                            <%=gv.getid() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td>
                            <%=gv.getage() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Lesson</td>
                        <td>
                            <%=gv.getlesson() %>
                        </td>
                    </tr>
                </table>
            <% i++;} %>

</body>

</html>