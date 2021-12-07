<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/7
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
</head>
<body>
<%   List<Map> stu    = (List<Map>) request.getAttribute("stu");
%>
<table border="1px" cellspacing="0" cellpadding="0" bordercolor="red" text-align="center">
<tr>
    <td>id</td>
    <td>name</td>
    <td>age</td>
    <td>address</td>
</tr>

<c:forEach var="m" items="${stu}">
    <tr>
    <td>${m.id}</td>
    <td>${m.sname} </td>
    <td>${m.sage} </td>
    <td>${m.saddress}</td>
    </tr>
    </c:forEach>
    </table>

    </body>
