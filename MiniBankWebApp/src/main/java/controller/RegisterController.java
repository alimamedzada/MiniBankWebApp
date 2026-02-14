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
import org.example.com.minibank.dao.impl.CustomerDaoImpl;
import org.example.com.minibank.dao.inter.CustomerDaoInter;
import org.example.com.minibank.model.account.Account;
import org.example.com.minibank.model.user.Customer;

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CustomerDaoInter customerDaoInter = new CustomerDaoImpl();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String azeID = request.getParameter("azeID");
        int age = Integer.parseInt(request.getParameter("age"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Customer customer = Customer.createNewCustomer(new Account(), name, surname, age, azeID, username, password);

        customerDaoInter.addCustomer(customer);
        HttpSession session = request.getSession();
        session.setAttribute("loggedInCustomer", customer);

        response.sendRedirect("customer.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
