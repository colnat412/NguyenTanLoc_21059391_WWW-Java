<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Welcome!!!</h1>
    <br/>
    <form action="control-servlet" method="post">
        <input type="hidden" name="action" value="login">
        <input style="width: 200px" type="text" name="email" placeholder="Email" required> <br>
        <input style="width: 200px" type="password" name="password" placeholder="Password" required> <br>
        <input style="width: 100px;" type="submit" value="Login">
    </form>
</body>
</html>