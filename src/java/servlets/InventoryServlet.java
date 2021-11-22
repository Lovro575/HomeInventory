package servlets;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
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
import services.CategoriesService;
import services.ItemsService;

public class InventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // List<Items> items = null;
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

        request.getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ItemsService is = new ItemsService();
        CategoriesService cs = new CategoriesService();

        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "saveAdd":
                    int dropDownCategory = Integer.parseInt(request.getParameter("category"));
                    String itemName = request.getParameter("name");
                    double itemPrice = Double.parseDouble(request.getParameter("price"));
                    Items itemToAdd = new Items();
                    String owner = (String) session.getAttribute("sessionUsername");
                    if (dropDownCategory > 0 && itemName.length() > 0 && itemPrice > 0) {
                        is.insert(itemToAdd.getItemID(), dropDownCategory, itemName, itemPrice, owner);
//                        List<Items> items = is.getAll();
//                        request.setAttribute("items", items);
                    }
                    break;
                case "delete":
                    Items itemToDelete = new Items();
                    int itemId = itemToDelete.getItemID();
                    is.delete(itemId);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
