<%-- 
    Document   : admin
    Created on : Nov 15, 2021, 5:00:48 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Inventory</title>
    </head>
    <body>
        <form method="GET" action="admin">
            <h1>Home Inventory</h1>
            <h3>Menu</h3>
            <p><a href="/HomeInventory/inventory">Inventory</a></p>
            <p><a href="/HomeInventory/login">Logout</a></p>
        </form>


        <h2>Manage Users</h2>
            <table cellpadding="6" border="1">

                <tr>
                    <td>Username</td>
                    <td>First Name</td>
                    <td>Lase Name</td>
                    <td>Delete</td>
                    <td>Edit</td>
                </tr>

                <tr>
                    <form method="POST" action="admin">
                        <c:forEach items="${users}" var="users">
                            <td name="uName" value="${users.username}">${users.username}</td>
                            <td name="fName" value="${users.firstName}">${users.firstName}</td>
                            <td name="lName" value="${users.lastName}">${users.lastName}</td>
                            <td>
                                <input type="submit" value="Edit"> 
                                <input type="hidden" name="action" value="editUser">
                            </td>
                            <td>
                                <input type="submit" value="Delete">
                                <input type="hidden" name="action" value="deleteUser">
                            </td>
                        </c:forEach>
                    </form>
                </tr>
            </table>

        <!--Add user form-->
        <form method="POST" action="admin">
            <h2>Add User</h2>
            <label>Username:</label>
            <input type="text" name="username" value="">
            <br>
            <label>Password:</label>
            <input type="text" name="password" value="">
            <br>
            <label>Email:</label>
            <input type="text" name="email" value="">
            <br>
            <label>First Name:</label>
            <input type="text" name="firstname" value="">
            <br>
            <label>Last Name:</label>
            <input type="text" name="lastname" value="">
            <br>
            <input type="submit" value="Save">
            <input type="hidden" name="action" value="saveAdd">
        </form>

        <!--Edit user form-->  
        <form method="POST" action="admin">
            <h2>Edit User</h2>
            <input type="text" name="editUsername" value="${username}">
            <br>
            <input type="text" name="editPassword" value="${password}"
            <br>
            <input type="text" name="editEmail" value="${email}">
            <br>
            <input type="text" name="editFirstname" value="${firstname}">
            <br>
            <input type="text" name="editLastname" value="${lastname}">
            <br>
            <input type="submit" value="Save">
            <input type="hidden" name="action" value="saveEdit">
        </form>
    </body>
</html>
