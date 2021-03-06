//修改跳转页面
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<fieldset  style="margin:100px auto;padding:30px;width:50%;">
    <legend>学生修改</legend>
    <form class="form-horizontal" action="/javaWeb/s/updateStu" method="post" >
        <input type="hidden" class="form-control" name="id"  value="${stu.id}">
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input  class="form-control" name="name" value="${stu.sname}" placeholder="请输入学生姓名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input  class="form-control" name="age" value="${stu.sage}" placeholder="请输入学生年龄">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">地址</label>
            <div class="col-sm-10">
                <input  class="form-control" name="address"  value="${stu.saddress}" placeholder="请输入学生地址">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加</button>
                <a href="/javaWeb/s/inquireStu" class="btn btn-default">返回</a>
            </div>
        </div>
    </form>
</fieldset>
</body>
</html>
