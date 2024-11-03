package fit.iuh.edu.vn.controllers;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.entities.Log;
import fit.iuh.edu.vn.services.AccountServices;
import fit.iuh.edu.vn.services.LogServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "control-servlet", value = "/control-servlet")
public class ControllerServlet extends HttpServlet {
    private AccountServices accountServices;
    private LogServices logServices;
    @Override
    public void init() throws ServletException {
        super.init();
        accountServices = new AccountServices();
        logServices = new LogServices();
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
            String password = req.getParameter("password");
            Account account = accountServices.findAccountByEmail(email);
            if(account != null){
                if(account.getPassword().equals(password)){
                    Log log = new Log();
                    log.setAccountId(account.getId());
                    log.setLoginTime(LocalDateTime.now());
                    log.setNote("Login successfully");
                    logServices.create(log);
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
        }else if(action.equalsIgnoreCase("logout")){
            Log log = logServices.findIdLast();
            log.setLogoutTime(LocalDateTime.now());
            log.setNote("Logout successfully");
            logServices.update(log);
            req.getServletContext().removeAttribute("account");
            resp.sendRedirect("index.jsp");
        }
    }
}
