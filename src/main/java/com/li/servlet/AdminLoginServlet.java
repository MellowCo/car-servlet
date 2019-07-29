package com.li.servlet;

import com.li.domain.Admin;
import com.li.services.IAdminServices;
import com.li.services.impl.AdminServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: AdminLoginServlet
 * @Description: 管理员登陆
 * @Author: li
 * @Create: 2019-07-24 09:37
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usename = request.getParameter("username");
        String pwd = request.getParameter("password");

        IAdminServices services = new AdminServicesImpl();
        response.getWriter().print(services.Login(new Admin(usename,pwd)));

    }
}
