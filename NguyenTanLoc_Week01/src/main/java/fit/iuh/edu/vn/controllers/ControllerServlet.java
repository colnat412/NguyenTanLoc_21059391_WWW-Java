package fit.iuh.edu.vn.controllers;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.services.AccountServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "control-servlet", value = "/control-servlet")
public class ControllerServlet extends HttpServlet {
    private AccountServices accountServices;
    @Override
    public void init() throws ServletException {
        super.init();
        accountServices = new AccountServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("login")){
            String email = req.getParameter("email");
            System.out.println("Email: " + email);
            String password = req.getParameter("password");
            Account account = accountServices.findAccountByEmail(email);
            if(account != null){
                if(account.getPassword().equals(password)){
                    req.getServletContext().setAttribute("account", account);
                    resp.sendRedirect("dashboard.jsp");
                }else{
                    req.setAttribute("message", "Incorrect email or password");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }else{
                req.setAttribute("message", "Incorrect email or password");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
    }
}
