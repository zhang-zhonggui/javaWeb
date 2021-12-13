<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/4
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<style>
    fieldset{
        width: 600px;
        margin: 100px auto;
        border: 3px solid green;
        border-radius: 25px;
    }
</style>
<body>
<fieldset>
    <legend>登录</legend>
    <span class="btn btn-danger">${msg}</span>
    <form class="form-horizontal" method="post" action="/javaWeb/admin/login">
        <div class="form-group">
            <label class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" placeholder="请输入账号" name="username">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" placeholder="请输入密码" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</fieldset>
</body>
</html>
