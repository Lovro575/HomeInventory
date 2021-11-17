<%-- 
    Document   : admin
    Created on : Nov 15, 2021, 5:00:48 PM
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
        <form method="GET" action="admin">
            <h1>Home Inventory</h1>
            <h3>Menu</h3>
            <p><a href="/HomeInventory/inventory">Inventory page link goes here</a></p>
            <p><a href="/HomeInventory/admin">Admin page link goes here</a></p>
            <p><a href="/HomeInventory/login">Logout link goes here</a></p>
        </form>
        
        
            <h2>Manage Users</h2>
            <table cellpadding="5" border="1">
                
                <tr>
                    <td>Username</td>
                    <td>First Name</td>
                    <td>Lase Name</td>
                    <td>Delete</td>
                    <td>Edit</td>
                </tr>
                
                <form method="POST" action="admin">
                    <c:forEach var="???" items="???">
                        <td name="uName">username here</td>
                        <td name="fName">firstname here</td>
                        <td name="lName">lastname here</td>
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
            <input type="text" name="editUsername" value="">
            <br>
            <input type="text" name="eidtEmail" value="">
            <br>
            <input type="text" name="editFirstname" value="">
            <br>
            <input type="text" name="editLastname" value="">
            <input type="submit" value="Save">
            <input type="hidden" name="action" value="saveAdd">
            <br>
            <input type="submit" value="Save">
            <input type="hidden" name="action" value="saveEdit">
            <input type="submit" value="Cancel">
            <input type="hidden" name="action" value="cancelEdit">
        </form>
    </body>
</html>