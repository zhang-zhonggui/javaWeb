<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/13
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<div class="row" style="height: 70px;line-height: 70px; font-size:18px; background-color: aqua;color:black">
    <div class="col-md-2">学生管理系统</div>
    <div class="col-md-2 col-md-offset-8">欢迎登录：${stu.nickname}</div>
</div>
<div class="row" style="border-top: 2px solid grey;">
    <div class="col-md-1" style="width:8%; background-color: beige;border:1px solid black; height:100%">
        <a type="button" class="btn btn-link" target="right" href="/javaWeb/s/inquireStu">学生管理</a>
        <a type="button" class="btn btn-link" target="right" href="/javaWeb/c/inquireClass">班级管理</a>
        <a type="button" class="btn btn-link" target="right" href="/javaWeb/updatepassword.jsp">修改密码</a>
        <a type="button" class="btn btn-link" target="right" href="/javaWeb/admin/update?id=${stu.id}">修改昵称</a>
        <a type="button" class="btn btn-link" href="/javaWeb/wd.jsp">注销</a>
    </div>
    <div class="col-md-11">
        <iframe src="" name="right" style="border:1px solid black;width:100%;height: 800px"></iframe>
    </div>
</div>

</body>
</html>
