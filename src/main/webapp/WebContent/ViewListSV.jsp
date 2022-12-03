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
    <h1>Thông tin các sinh viên</h1>
    <div>Nhấn vào tên sinh viên để thực hiện chỉnh sửa</div>
    <% int i=1; List<SV> list_sv = (List<SV>) request.getAttribute("ListSV");
            for(SV sv : list_sv)
            { %>
            <form action="EditSVDetails" method="post">
                <div>
                    <h3>
                        <%=i%>.<%=sv.getname() %>
                    </h3>
                </div>
                <table>
                    <tr>
                        <td>ID</td>
                        <td>
                            <%=sv.getid() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td>
                            <%=sv.getage() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Diem</td>
                        <td>
                            <%=sv.getdiem() %>
                        </td>
                    </tr>
                </table>
                <input type="submit" name="edit" value="Edit">
                <input type="submit" name="delete" value="Delete">
                <!-- Click Edit button sẽ có Attribute edit = edit
    			Click Delete button sẽ có Attribute delete = Delete -->
            </form>
            <% i++;} %>

</body>

</html>