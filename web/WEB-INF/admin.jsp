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
        <form>
        <table cellpadding="5" border="1">

            <tr>
                <td>Username</td>
                <td>First Name</td>
                <td>Lase Name</td>
                <td>Delete</td>
                <td>Edit</td>
            </tr>
            
           
            <form method="POST" action="admin">
                    <c:forEach items="${users}" var="users">
                        
                        <input name="uName" value="${users.username}"> asd
                        <input name="fName" value="${users.firstName}">
                        <input name="lName" value="${users.lastName}">      
                        
                        <input type="submit" value="Edit"> 
                        <input type="hidden" name="action" value="editUser">
                    
                        <input type="submit" value="Delete">
                        <input type="hidden" name="action" value="deleteUser">
                    
                    </c:forEach>
                </form>
                  
    </table>
</form>
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
        <input type="text" name="editUsername" value="">
        <br>
        <input type="text" name="eidtEmail" value="">
        <br>
        <input type="text" name="editFirstname" value="">
        <br>
        <input type="text" name="editLastname" value="">
        <br>
        <input type="submit" value="Save">
        <input type="hidden" name="action" value="saveAdd">
        <input type="submit" value="Cancel">
        <input type="hidden" name="action" value="cancelEdit">
    </form>
</body>
</html>
