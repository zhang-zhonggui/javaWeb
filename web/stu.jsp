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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<table class="table table-bordered table-hover active table-responsive">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>address</td>
        <td>操作</td>
    </tr>
    <c:forEach var="m" items="${stu}">
        <tr>
            <td>${m.id}</td>
            <td>${m.sname} </td>
            <td>${m.sage} </td>
            <td>${m.saddress}</td>
            <td>
                <button type="button" class="btn btn-success">修改</button>
                <button onClick="delStu(${m.id})"  type="button" class="btn btn-danger">删除</button>
            </td>

        </tr>
    </c:forEach>
</table>
<script>
    function delStu(id) {
        if (confirm("真的删除吗")){
            window.location.href="/javaWeb/delStu?id="+id;
        }
    }
</script>

</body>
