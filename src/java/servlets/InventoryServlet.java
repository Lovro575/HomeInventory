package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Categories;
import models.Items;
import models.Users;
import services.CategoriesService;
import services.ItemsService;

public class InventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemsService is = new ItemsService();
        CategoriesService cs = new CategoriesService();

        try {
            List<Items> items = is.getAll();
            request.setAttribute("items", items);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<Categories> categories = cs.getAll();
            request.setAttribute("categories", categories);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String action = request.getParameter("action");

        //delete function
        if (action != null && action.equals("delete")) {

            try {
                int itemID = Integer.parseInt(request.getParameter("itemID"));
                is.delete(itemID);
                request.setAttribute("deleted", "Item successfully deleted");
            } catch (Exception ex) {
                Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //edit function
        if (action != null && action.equals("edit")) {
            HttpSession session = request.getSession();
            int itemID = Integer.parseInt(request.getParameter("itemID"));
            session.setAttribute("itemID", itemID);

            String categoryName = request.getParameter("categoryName");
            request.setAttribute("categoryName", categoryName);

            String itemName = request.getParameter("itemName");
            request.setAttribute("itemName", itemName);

            double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
            request.setAttribute("itemPrice", itemPrice);
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Users users = new Users();
        ItemsService is = new ItemsService();
        CategoriesService cs = new CategoriesService();

        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        //add function
        if (action != null && action.equals("saveAdd")) {

            try {
                int dropDownCategory = Integer.parseInt(request.getParameter("category"));
                String itemName = request.getParameter("name");
                double itemPrice = Double.parseDouble(request.getParameter("price"));
                String owner = (String) session.getAttribute("sessionUsername");

                if (dropDownCategory > 0 && itemName.length() > 0 && itemPrice > 0) {
                    is.insert(dropDownCategory, itemName, itemPrice, owner);
                }
            } catch (Exception ex) {
                Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //saving the edit function
        if (action != null && action.equals("saveEdit")) {
            try {
                int itemID = (int) session.getAttribute("itemID");
                int editCategory = Integer.parseInt(request.getParameter("editCategory"));
                String editItemName = request.getParameter("editItemName");
                double editItemPrice = Double.parseDouble(request.getParameter("editItemPrice"));
                String sessionUsername = (String) session.getAttribute("sessionUsername");
                is.update(itemID, editCategory, editItemName, editItemPrice, sessionUsername);

            } catch (Exception ex) {
                Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            List<Items> items = is.getAll();
            request.setAttribute("items", items);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<Categories> categories = cs.getAll();
            request.setAttribute("categories", categories);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
        return;
    }

}
