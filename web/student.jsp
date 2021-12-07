<%@ page import="static java.awt.Color.red" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/7
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Map> stu = (List<Map>) request.getAttribute("stu"); %>
<table border="1" cellspacing="0" cellpadding="0" bordercolor="red">
    <% for (Map a : stu) { %>
    <tr>
        <td><%= a.get("id") %>
        </td>
        <td><%= a.get("sname") %>
        </td>
        <td><%= a.get("sage") %>
        </td>
        <td><%= a.get("saddress") %>
        </td>
    </tr>

    <% } %>
</table>

</body>
</html>
