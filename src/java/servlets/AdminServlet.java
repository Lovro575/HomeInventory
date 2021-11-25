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
import models.Users;
import services.UsersService;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsersService us = new UsersService();

        HttpSession session = request.getSession();
        session.invalidate();

        try {
            List<Users> users = us.getAll();
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
        boolean active = Boolean.parseBoolean(request.getParameter("active"));

        try {
            switch (action) {
                case "Save":
                    String addUsername = request.getParameter("username");
                    String addPassword = request.getParameter("password");
                    String addEmail = request.getParameter("email");
                    String addFirstname = request.getParameter("firstname");
                    String addLastname = request.getParameter("lastname");
                    if (addUsername.length() > 0 && addPassword.length() > 0 && addEmail.length() > 0 && addFirstname.length() > 0 && addLastname.length() > 0) {
                        us.insert(addUsername, addPassword, addEmail, addFirstname, addLastname, active, active);
                        //users = us.getAll();
                        request.setAttribute("users", users);
                    }
                    break;
                    
                case "editUser":
                    String usernameEdit = request.getParameter("uName");
                    Users editUsers = us.get(usernameEdit);
                    request.setAttribute("editUsers", editUsers);
                    break;
                case "saveEdit":
                    String editUsername = request.getParameter("editUsername");
                    String editPassword = request.getParameter("editPassword");
                    String editEmail = request.getParameter("editEmail");
                    String editFirstname = request.getParameter("editFirstname");
                    String editLastname = request.getParameter("editLastname");
                    if (editUsername.length() > 0 && editPassword.length() > 0 && editEmail.length() > 0 && editFirstname.length() > 0 && editLastname.length() > 0) {
                        us.update(editUsername, editPassword, editEmail, editFirstname, editLastname, active, active);
                    }
                    break;
                    
                case "deleteUser":
                    String usernameDelete = request.getParameter("uName");
                    Users deleteUsers = us.get(usernameDelete);
                    String deleteUser = deleteUsers.toString();
                    us.delete(deleteUser);
                    break;
                }
//            request.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
//            return;
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
    }

}
