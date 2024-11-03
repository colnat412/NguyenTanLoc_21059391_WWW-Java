<%@ page import="fit.iuh.edu.vn.entities.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.edu.vn.entities.Role" %><%--
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            font-size: 18px;
            text-align: left;
        }
        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        table th {
            background-color: #f2f2f2;
        }
        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        table tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center">Dashboard</h1>
    <div class="container">
        <% Account account = (Account) request.getServletContext().getAttribute("account");
            Boolean isAdmin = (Boolean) request.getServletContext().getAttribute("isAdmin");
            List<Role> roles = (List<Role>) request.getServletContext().getAttribute("roles");
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
        <div class="info">
            <label>Roles:</label>
            <span>
                <% for (Role role : roles) { %>
                        <%= role.getRoleName() %> <br>
                <% } %>
            </span>
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
    <% List<Account> accounts = (List<Account>) request.getServletContext().getAttribute("accounts");%>
    <table>
        <thead>
        <tr>
            <th></th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <% for (Account acc : accounts) { %>
        <tr>
            <td>
                <input type="checkbox" name="selectedAccounts" value="<%= acc.getEmail() %>">
            </td>
            <td><%= acc.getFullName() %></td>
            <td><%= acc.getEmail() %></td>
            <td><%= acc.getPhone() %></td>
            <td>
                <form action="control-servlet" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="emailDelete" value="<%= acc.getEmail() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form action="control-servlet" method="post">
                    <input type="hidden" name="action" value="grant">
                    <input type="hidden" name="emailGrant" value="<%= acc.getEmail() %>">
                    <input type="submit" value="Grant">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
