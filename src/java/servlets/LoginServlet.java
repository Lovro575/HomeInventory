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

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Users> users = null;
        UsersService us = new UsersService();

        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users user = new Users();
        session.setAttribute("sessionUsername", user.getFirstName());

        //error cheching and login validation
        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("errorMessage", "Please enter both the username and the password.");
            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (username.equals("admin") && password.equals("password") || username.equals("admin2")) {
            response.sendRedirect("/HomeInventory/admin");
        } else {
            if (username.equals("barb") && password.equals("password")) {
                    response.sendRedirect("/HomeInventory/inventory");
                }
            //getting the users from the database
//            try {
//                users = us.getAll();
//                if (users.getClass().equals(username.getClass()) && password.equals("password")) {
//                    response.sendRedirect("/HomeInventory/inventory");
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
    }

}
