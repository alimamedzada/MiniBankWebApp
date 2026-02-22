/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.com.minibank.entity.Customers;
import org.example.com.minibank.service.impl.AuthServiceImpl;
import org.example.com.minibank.service.inter.AuthServiceInter;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("rememberedUsername")) {
                    request.setAttribute("cookieUsername", c.getValue());
                    break;
                }
            }
        }

        if (request.getSession().getAttribute("loggedInCustomer") != null) {
            response.sendRedirect("CustomerDetailsController");
            return;
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthServiceInter authServiceInter = new AuthServiceImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        try {
            Customers customer = authServiceInter.login(username, password);
            if (customer != null) {

                request.getSession().setAttribute("loggedInCustomer", customer);

                Cookie cookie = new Cookie("rememberedUsername", username);
                cookie.setPath("/");
                if (rememberMe != null) {
                    cookie.setMaxAge(60 * 60 * 24 * 1);
                } else {
                    cookie.setMaxAge(0);
                }
                response.addCookie(cookie);
                response.sendRedirect("CustomerDetailsController");
                return;
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
