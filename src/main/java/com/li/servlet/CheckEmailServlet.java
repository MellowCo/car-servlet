package com.li.servlet;

import com.li.services.IUserServices;
import com.li.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: CheckEmailServlet
 * @Description: 检查邮箱是否可用
 * @Author: li
 * @Create: 2019-07-23 12:14
 */
@WebServlet("/CheckEmailServlet")
public class CheckEmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        IUserServices services = new UserServicesImpl();

        Boolean flag = services.checkEmail(email);

        response.getWriter().print(flag);
    }
}
