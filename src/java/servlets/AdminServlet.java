package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;
import services.UsersService;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Users> users = null;
        UsersService us = new UsersService();

        String action = request.getParameter("action");
        String username = request.getParameter("uName");

//        if(action != null) {
//            switch(action) {
//                case "deleteUser":
//                    try {
//                        us.delete(username);
//                    }catch (Exception ex) {
//                        Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    break;
//            }
//        }
        try {
            users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Users> users = null;
        UsersService us = new UsersService();

        //getting the values
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        try {
            switch (action) {
                case "saveAdd":
                    if (username.length() > 0 && password.length() > 0 && email.length() > 0 && firstname.length() > 0 && lastname.length() > 0) {
                        us.insert(username, password, email, firstname, lastname, true, true);
                    }
                    break;
                case "deleteUser":
                    us.delete(username);
                    break;
                case "editUser":
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("email", email);
                    request.setAttribute("firstname", firstname);
                    request.setAttribute("lastname", lastname);
                    break;
                case "saveEdit":
                    //editUsername editEmail editFirstname editLastname
                    String editUsername = request.getParameter("editUsername");
                    String editPassword = request.getParameter("editPassword");
                    String editEmail = request.getParameter("editEmail");
                    String editFirstname = request.getParameter("editFirstname");
                    String editLastname = request.getParameter("editLastname");
                    us.update(editUsername, editPassword, editEmail, editFirstname, editLastname, true, true);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(InventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        return;
    }

}
