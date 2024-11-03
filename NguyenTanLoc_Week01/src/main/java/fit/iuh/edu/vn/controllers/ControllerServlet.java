package fit.iuh.edu.vn.controllers;

import fit.iuh.edu.vn.entities.Account;
import fit.iuh.edu.vn.entities.Log;
import fit.iuh.edu.vn.entities.Role;
import fit.iuh.edu.vn.services.AccountServices;
import fit.iuh.edu.vn.services.LogServices;
import fit.iuh.edu.vn.services.RoleServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "control-servlet", value = "/control-servlet")
public class ControllerServlet extends HttpServlet {
    private AccountServices accountServices;
    private RoleServices roleServices;
    private LogServices logServices;
    @Override
    public void init() throws ServletException {
        super.init();
        accountServices = new AccountServices();
        roleServices = new RoleServices();
        logServices = new LogServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("log")){
            Log log = logServices.findIdLast();
            List<Log> logs = logServices.findLogByAccountId(log.getAccountId());
            req.getServletContext().setAttribute("logs", logs);
            req.getRequestDispatcher("log.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("login")){
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Account account = accountServices.findAccountByEmail(email);
            List<Role> rolesOfAccount = roleServices.findRolesOfAccount(email);
            if(account != null){
                if(account.getPassword().equals(password)){
                    Log log = new Log();
                    log.setAccountId(account.getId());
                    log.setLoginTime(LocalDateTime.now());
                    log.setNote("Login successfully");
                    logServices.create(log);
                    req.getServletContext().setAttribute("account", account);
                    boolean isAdmin = rolesOfAccount.stream().anyMatch(role -> role.getRoleName().equalsIgnoreCase("ADMIN"));
                    req.getServletContext().setAttribute("isAdmin", isAdmin);
                    if(isAdmin){
                        req.getServletContext().setAttribute("roles", rolesOfAccount);
                        req.getServletContext().setAttribute("accounts", accountServices.findAll());
                        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
                    }else
                        resp.sendRedirect("profile.jsp");
                }else{
                    req.setAttribute("message", "Incorrect email or password");
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }else{
                req.setAttribute("message", "Incorrect email or password");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
        else if(action.equalsIgnoreCase("logout")){
            Log log = logServices.findIdLast();
            log.setLogoutTime(LocalDateTime.now());
            log.setNote("Logout successfully");
            logServices.update(log);
            req.getServletContext().removeAttribute("account");
            resp.sendRedirect("index.jsp");
        }
        else if(action.equalsIgnoreCase("delete")){
            String emailDelete =req.getParameter("emailDelete");
            Account account = accountServices.findAccountByEmail(emailDelete);
            accountServices.delete(account);
            req.getServletContext().setAttribute("accounts", accountServices.findAll());
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        }
        else if(action.equalsIgnoreCase("grant")){
            String emailGrant = req.getParameter("emailGrant");
        }

    }
}
