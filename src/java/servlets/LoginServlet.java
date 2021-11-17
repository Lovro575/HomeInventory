package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
         
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        session.setAttribute("sessionUsername", username);
        
        if(username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("errorMessage", "Please enter both the username and the password.");
            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if(username.equals("admin") && password.equals("password") || username.equals("admin2")) {
            response.sendRedirect("/HomeInventory/admin");
        } else if(username.equals("anne") && password.equals("password")) {
            response.sendRedirect("/HomeInventory/inventory");
        }
        
    }


}