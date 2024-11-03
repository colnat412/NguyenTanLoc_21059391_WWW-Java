<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.edu.vn.entities.Log" %>
<html>
<head>
    <title>Log</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Logs</h1>
    <table>
        <thead>
        <tr>
            <th>LoginTime</th>
            <th>LogoutTime</th>
            <th>Account</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Log> logs = (List<Log>) request.getServletContext().getAttribute("logs");
            if (logs != null) {
                for (Log log : logs) {
        %>
        <tr>
            <td><%= log.getLoginTime() %></td>
            <td><%= log.getLogoutTime() %></td>
            <td><%= log.getAccountId() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</body>
</html>