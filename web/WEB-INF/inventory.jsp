<%-- 
    Document   : inventory
    Created on : Nov 15, 2021, 5:11:34 PM
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
        <form>
            <h1>Home Inventory</h1>
            <h3>Menu</h3>
            <p><a href="/HomeInventory/inventory">Inventory page link goes here</a></p>
            <p><a href="/HomeInventory/admin">Admin page link goes here</a></p>
            <p><a href="/HomeInventory/login">Logout link goes here</a></p>
        </form>
        
        
            <h2>Inventory for (username goes here)</h2>
            <table cellpadding="5" border="1">
                
                <tr>
                    <td>Category</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Delete</td>
                </tr>
                
                <form>
                    <c:forEach var="???" items="???">
                        <td name="itemCategoty">category here</td>
                        <td name="itemName">name here</td>
                        <td name="itemPrice">price here</td>
                        
                        <td>
                            <input type="submit" value="Save">
                            <input type="hidden" name="action" value="saveAdd">
                        </td>
                    </c:forEach>
                </form>
                    
            </table>
            
        <!--Add item form-->
        <form>
            <h2>Add Item</h2>
            <label>Category:</label>
            <input type="text" name="category" value="">
            <br>
            <label>Name:</label>
            <input type="text" name="name" value="">
            <br>
            <label>Price:</label>
            <input type="text" name="price" value="">
            <br>
            <input type="submit" value="Save">
            <input type="hidden" name="action" value="saveAdd">
        </form>
        
    </body>
</html>
