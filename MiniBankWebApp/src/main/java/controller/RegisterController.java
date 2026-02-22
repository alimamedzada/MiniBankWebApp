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
import jakarta.servlet.http.HttpSession;
import org.example.com.minibank.entity.Customers;
import org.example.com.minibank.exception.InputValidationException;
import org.example.com.minibank.service.impl.CustomerServiceImpl;
import org.example.com.minibank.service.inter.CustomerServiceInter;

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("loggedInCustomer") != null) {
            response.sendRedirect("CustomerDetailsController");
            return;
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CustomerServiceInter customerDao = new CustomerServiceImpl();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String azeID = request.getParameter("azeID");
        int age = Integer.parseInt(request.getParameter("age"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("password= " + password);

        Customers customer = Customers.createNewCustomer(name, surname, age, azeID, username, password);
        try {
            customerDao.addCustomer(customer);
            HttpSession session = request.getSession();

            session.setAttribute("loggedInCustomer", customer);
            response.sendRedirect("CustomerDetailsController");

            return;
        } catch (InputValidationException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
