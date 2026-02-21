/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthServiceInter authServiceInter = new AuthServiceImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customers customer = authServiceInter.login(username, password);
        System.out.println("username= " + username);
        if (customer != null) {
            request.getSession().setAttribute("loggedInCustomer", customer);
            response.sendRedirect("CustomerDetailsController");
        } else {
            request.setAttribute("errorMessage", "İstifadeçi adı veya şifre sehvdir!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
