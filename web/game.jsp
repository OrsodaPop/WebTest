<%@ page import="java.util.Random" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 张泽隆
  Date: 2024/3/16
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>猜数游戏</title>
</head>
<body>

    <p>请你猜一个数字从1-100之间，有5次机会</p>
    <form action="game" method="post">
        <input placeholder="请输入" type="text" name="number">
        <button>确认</button>
    </form>


</body>
</html>
