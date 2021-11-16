<%-- 
    Document   : login
    Created on : Nov 15, 2021, 4:43:22 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Inventory</title>
    </head>
    <body>
        <form method="POST" action="login">
            <h1>Home Inventory</h1>
            <h2>Login</h2>
            <label>Username:</label>
            <input type="text" name="username" value="">
            <br>
            <label>Password:</label>
            <input type="text" name="password" value="">
            <br>
            <input type="submit" name="login" value="Login">
            <br>
            <p>${errorMessage}</p>
        </form>
    </body>
</html>
