package com.apptodo.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apptodo.dao.UsersDao;


@WebServlet(name = "ValidadorLogin", urlPatterns = {"/ValidadorLogin"})
public class ValidadorLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDao usersDao = UsersDao.getLogin(req.getParameter("inputUser"), req.getParameter("inputPassword"));
        if(usersDao == null) { 
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            req.setAttribute("error", "Your login was bad!");
            rd.forward(req, resp);
            return;
        }
         
        req.getSession().setAttribute("login", usersDao);
        req.getSession().setMaxInactiveInterval(60 * 60 * 24 * 7 * 2); //seg, min, horas, dias, semanas.
        
        Cookie cookie = new Cookie("userName", usersDao.userFirstName);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        resp.addCookie(cookie);
        
        RequestDispatcher rd = req.getRequestDispatcher("continuacao.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }
}
