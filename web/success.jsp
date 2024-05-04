<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 张泽隆
  Date: 2024/3/10
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = (String) request.getAttribute("name");
        String password = (String) request.getAttribute("password");
        String hobby = (String) request.getAttribute("hobby");

    %>
<%--    <p>${name},恭喜你！你的邮箱账号为${zhanhao}</p>--%>
    <p>欢迎<%=name%>学习JavaWeb,你的密码是<%=password%>,爱好是：<%=hobby%></p>

</body>
</html>
