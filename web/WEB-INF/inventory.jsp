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
<!--            <p><a href="/HomeInventory/admin">Admin</a></p>-->
            <p><a href="/HomeInventory/login">Logout</a></p>
        </form>
        
        
            <h2>Inventory for ${sessionUsername}</h2>
            <table cellpadding="5" border="1">
                
                <tr>
                    <td>Category</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Delete</td>
                </tr>
                
                <tr>
                    <form action="inventory" method="POST">
                        <c:forEach var="items" items="${items}">
                            <td name="itemCategoty" value="${items.category}">${items.category}</td>
                            <td name="itemName" value="${items.itemName}">${items.itemName}</td>
                            <td name="itemPrice" value="${items.price}">${items.price}</td>
                            <td>
                                <input type="submit" value="Delete">
                                <input type="hidden" name="action" value="delete">
                            </td>
                        </c:forEach>
                    </form>
                </tr>
            </table>
            
        <!--Add item form-->
        <form> 
            <h2>Add Item</h2>
            <select name="category">
                <option value="Kitchen">Kitchen</option>
                <option value="Bathroom">Bathroom</option>
                <option value="Living room">Living room</option>
                <option value="Basement">Basement</option>
                <option value="Bedroom">Bedroom</option>
                <option value="Garage">Garage</option>
                <option value="Office">Office</option>
                <option value="Utility room">Utility room</option>
                <option value="Storage">Storage</option>
            </select>
            
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
