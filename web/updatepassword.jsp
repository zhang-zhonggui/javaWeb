<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/13
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<fieldset>
    <legend>密码修改</legend>
    ${code}
    <form class="form-horizontal" method="post" action="/javaWeb/admin/updatePassword">
        <div class="form-group">
            <label class="col-sm-2 control-label">旧密码</label>
            <div class="col-sm-10">
                <input class="form-control" placeholder="请输入旧密码" name="oldpassword">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">新密码</label>
            <div class="col-sm-10">
                <input class="form-control" placeholder="请输入新密码" id="pw" name="newpassword_one">
            </div>
        </div>
        <span id="tishi"></span>
        <div class="form-group">
            <label class="col-sm-2 control-label">确认新密码</label>
            <div class="col-sm-10">
                <input class="form-control" placeholder="请确认密码" id="repw"  name="newpassword_two">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" id="submit" onClick="checkpassword()" class="btn btn-default">修改</button>
            </div>
        </div>
    </form>
</fieldset>
<script>
    function checkpassword() {
        var password = document.getElementById("pw").value;
        var repassword = document.getElementById("repw").value;
        if(password == repassword) {
            document.getElementById("tishi").innerHTML="<br><font color='green'>两次密码输入一致</font>";
            document.getElementById("submit").disabled = false;
        }else {
            document.getElementById("tishi").innerHTML="<br><font color='red'>两次输入密码不一致!</font>";
            document.getElementById("submit").disabled = true;
        }
    }
</script>
</body>
</html>
