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
    <h1>Thông tin giảng viên</h1>
    <% GV gv = (GV) request.getAttribute("gv"); %>
    <div>
        <h3>
        	Name : <%=gv.getname() %>
        </h3>
    </div>
    <table>
           <tr>
               <td>Age : </td>
               <td>
                   <%=gv.getage() %>
               </td>
           </tr>
           <tr>
               <td>Lesson : </td>
               <td>
                   <%=gv.getlesson() %>
               </td>
           </tr>
     </table>

</body>

</html>