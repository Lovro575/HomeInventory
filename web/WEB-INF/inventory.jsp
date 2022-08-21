<%-- 
    Document   : inventory
    Created on : Nov 15, 2021, 5:11:34 PM
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
        <form>
            <h1>Home Inventory</h1>
            <h3>Menu</h3>
            <p><a href="/HomeInventory/login">Logout</a></p>
        </form>


        <h2>Inventory for ${sessionUsername}</h2>
        <table cellpadding="5" border="1">

            <tr>
                <td>Category</td>
                <td>Name</td>
                <td>Price</td>
                <td>Delete</td>
                <td>Edit</td>
            </tr>

            <!--item table-->

            <c:forEach var="items" items="${items}">
                <tr> 
                    <td>${items.category.categoryName}</td>
                    <td>${items.itemName}</td>
                    <td>${items.price}</td>

                    <td>
                        <a href="inventory?action=delete&amp;itemID=${items.itemID}">Delete</a>
                    </td>

                    <td>
                        <a href="inventory?action=edit&amp;itemID=${items.itemID}&amp;
                           categoryName=${items.category.categoryName}
                           &amp;itemName=${items.itemName}&amp
                           &amp;itemPrice=${items.price}">Edit</a>
                    </td>

                </tr>
            </c:forEach>


        </table>

        <!--Add item form-->
        <form method="POST" action="inventory"> 
            <h2>Add Item</h2>
            <select name="category">
                <c:forEach items="${categories}" var="categories">
                    <option name="itemid" value="${categories.categoryID}">${categories.categoryName}</option>
                </c:forEach>
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

        <br>
        <br>

        <!--Edit item form-->
        <form methon="POST" action="inventory">
            <select name="editCategory">
                <c:forEach var="categories" items="${categories}">
                    <option value="${categories.categoryID}">${categories.categoryName}</option>
                </c:forEach>
            </select> 
            <br>  
            <label>Name:</label>
            <input type="text" name="editItemName" value="${itemName}">
            <br>
            <label>Price:</label>
            <input type="text" name="editItemPrice" value="${itemPrice}">
            <br>
            <input type="submit" value="Save">
            <input type="hidden" name="action" value="saveEdit">
        </form>

        <p>${deleted}</p> 

    </body>
</html>
