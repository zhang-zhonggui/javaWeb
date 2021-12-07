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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>

<table class="table table-striped">
    <tr>
        <td>id</td>
        <td>名字</td>
        <td>年龄</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach var="stu" items="${students}">

        <tr>
            <td>${stu.id}</td>
            <td>${stu.sname}</td>
            <td>${stu.sage}</td>
            <td>${stu.saddress}</td>
            <td>
                <button onClick="del(${stu.id})">删除</button>
                <button>修改</button>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    function del(id) {
        alert(1)
        if (confirm("真的删除吗")){
            window.location.href="/javaWeb/del?id="+id;
        }
    }
</script>

</body>
</html>
