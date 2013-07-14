<%@ page import="com.akshay.tutorials.UserBean" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success!</title>
</head>
<body>
<% UserBean currentUser = (UserBean)(session.getAttribute("currentSessionUser"));%>

Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
</body>
</html>