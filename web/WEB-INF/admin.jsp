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
        <h1>Home Inventory</h1>
        <h3>Menu</h3>
        <p><a href="/HomeInventory/inventory">Inventory</a></p>
        <p><a href="/HomeInventory/login">Logout</a></p>


        <h2>Manage Users</h2>
        <table cellpadding="6" border="1">

            <tr>
                <td>Username</td>
                <td>First Name</td>
                <td>Lase Name</td>
                <td>Active</td>
                <td>Admin</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>

            <tr>
            <form method="POST" action="admin">
                <c:forEach items="${users}" var="users">
                    <tr>
                        <td> <input name="uName" type="hidden" value="${users.username}">${users.username} </td> 
                        <td> <input name="fName" type="hidden" value="${users.firstName}">${users.firstName} </td>
                        <td> <input name="lName" type="hidden" value="${users.lastName}">${users.lastName} </td>

                        <td>
                            <c:if test="${users.active == true}">
                            <td>
                                <input type="checkbox" disabled checked>
                            </td>
                        </c:if>
                        </td>
                        <td>
                            <c:if test="${users.isAdmin == true}">
                            <td>
                                <input type="checkbox" disabled checked>
                            </td>
                        </c:if>
                        </td>
                        <td>
<!--                            <a href="admin?action=editUser&amp;uName=${users.username}">Edit</a>-->

                            <input type="submit" value="Edit"> 
                            <input type="hidden" name="action" value="editUser">
                            <input type="hidden" value="${users.username}">
                        </td>
                        <td>
                            <a href="admin?action=deleteUser&amp;uName=${users.username}">Delete</a>
                            <!--                            <input type="submit" value="Delete">
                                                        <input type="hidden" name="action" value="deleteUser">-->
                        </td>
                    </tr>
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
        Active:<input name="active" type="checkbox">
        <br>
        <input type="submit" value="Save">
        <input type="hidden" name="action" value="saveAdd">
    </form>

    <!--Edit user form-->  
    <form method="POST" action="admin">
        <h2>Edit User</h2>
        <c:if test="${editUsers != null}">
            Username:<input type="text" name="editUsername" value="${editUsers.username}">
            <br>
            Password:<input type="text" name="editPassword" value="${editUsers.password}">
            <br>
            Email:<input type="text" name="editEmail" value="${editUsers.email}">
            <br>
            First Name:<input type="text" name="editFirstname" value="${editUsers.firstName}">
            <br>
            Last Name:<input type="text" name="editLastname" value="${editUsers.lastName}">
            <br>
            Active:<input name="active" type="checkbox">
            <br>
            <input type="submit" value="Save Edits">
            <input type="hidden" name="action" value="saveEdit">
        </c:if>
    </form>
</body>
</html>
