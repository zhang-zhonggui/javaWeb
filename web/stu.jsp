<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron" style="margin: 0 auto; text-align: center" >
    <h1>student表</h1>
    <p>增删改查</p>
    <p><a class="btn btn-primary btn-lg" href="/javaWeb/addstu.jsp" role="button">添加</a></p>
</div>
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
                <a type="button" href="/javaWeb/getStu?id=${m.id}"  class="btn btn-success">修改</a>
                <button onClick="delStu(${m.id})" type="button" class="btn btn-danger">删除</button>
            </td>

        </tr>
    </c:forEach>
</table>
<script>
    function delStu(id) {
        if (confirm("真的删除吗")) {
            window.location.href = "/javaWeb/s/delStu?id=" + id;
        }
    }
</script>

</body>
