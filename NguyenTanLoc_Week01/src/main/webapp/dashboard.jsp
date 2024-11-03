<%--
  Created by IntelliJ IDEA.
  User: TANLOC
  Date: 11/3/2024
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Dashboard</h1>
    <form action="control-servlet" method="post">
        <input type="hidden" name="action" value="logout">
        <input style="width: 100px;" type="submit" value="Logout">
    </form>
</body>
</html>
