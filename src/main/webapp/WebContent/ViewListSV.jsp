<%@page import="java.util.ArrayList"%>
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
    <form action="ViewListSV" method="post">
    <%  ArrayList<SV> list_sv = (ArrayList<SV>) request.getAttribute("ListSV");
            for(int i=0;i<list_sv.size();i++)
            { %>
                <div>
                    <h3>
                        SV thứ <%=i%> : <%=list_sv.get(i).getname() %>
                    </h3>
                </div>
                <table>
                    <tr>
                        <td>ID : </td>
                        <td>
                            <%=list_sv.get(i).getid() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Age : </td>
                        <td>
                            <%=list_sv.get(i).getage() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Diem : </td>
                        <td>
                            <%=list_sv.get(i).getdiem() %>
                        </td>
                    </tr>
                </table>
                <input type="submit" name="edit<%=i%>" value="Edit">
                <!-- Click Edit button sẽ có Attribute edit = edit
    			Click Delete button sẽ có Attribute delete = Delete -->
            <% } %>
             </form>

</body>

</html>