<%--
  Created by IntelliJ IDEA.
  User: 张泽隆
  Date: 2024/3/2
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="hello" method="post">
        名称：<input type="text" name="name">
        密码：<input type="password" name="password">
        性别 <input id="man" type="radio" checked="checked" name="sex">男
        <input type="radio" id="woman" name="sex">女<br><br>
        <input type="button" value="重新开始" id="button">
        <button>登陆</button>
    </form>
</body>
</html>
