<%@ page import="fit.iuh.edu.vn.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: TANLOC
  Date: 11/3/2024
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container h1 {
            text-align: center;
        }
        .container .info {
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .container .info label {
            display: block;
            font-weight: bold;
        }
        .container .info span {
            display: block;
            margin-top: 5px;
        }
        .container input[type="submit"] {
            width: 48%;
            padding: 10px;
            margin: 10px 1%;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        .container input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container .logout {
            background-color: #f44336;
        }
        .container .logout:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
    <div class="container">
        <% Account account = (Account) request.getServletContext().getAttribute("account");
            Boolean isAdmin = (Boolean) request.getServletContext().getAttribute("isAdmin");
        %>
        <h1>Profile Information</h1>
        <div class="info">
            <label>Full Name:</label>
            <span><%= account.getFullName() %></span>
        </div>
        <div class="info">
            <label>Email:</label>
            <span><%= account.getEmail()%></span>
        </div>
        <div class="info">
            <label>Phone:</label>
            <span><%= account.getPhone() %></span>
        </div>
        <form action="control-servlet" method="get">
            <input type="hidden" name="action" value="log">
            <input type="submit" value="View logs" class="log">
        </form>
        <form action="control-servlet" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" class="log">
        </form>
    </div>
</body>

</html>
