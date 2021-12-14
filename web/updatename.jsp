<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/13
  Time: 21:12
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
<fieldset>
    <legend>昵称修改</legend>
    <form class="form-horizontal" method="post" action="/javaWeb/admin/updatename">

        <div class="form-group">
            <input type="hidden" class="form-control" value="${id}" name="id">
            <label class="col-sm-2 control-label">昵称</label>
            <div class="col-sm-10">
                <input class="form-control" placeholder="请输入新昵称" name="name">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" id="submit" onClick="checkpassword()" class="btn btn-default">修改</button>
            </div>
        </div>
    </form>
</fieldset>

</body>
</html>
