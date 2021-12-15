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
    <h1>日志表</h1>
</div>
<table class="table table-bordered table-hover active table-responsive">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>date</td>
        <td>way</td>
        <td>ip</td>
        <td>wayId</td>
    </tr>
    <c:forEach var="l" items="${log}">
        <tr>
            <td>${l.id}</td>
            <td>${l.name} </td>
            <td>${l.date} </td>
            <td>${l.way}</td>
            <td>${l.ip} </td>
            <td>${l.wayId}</td>
        </tr>
    </c:forEach>
</table>

</body>
