package com.li.servlet;

import com.li.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: DelUserByEmailServlet
 * @Description: 根据email，删除用户
 * @Author: li
 * @Create: 2019-07-23 16:19
 */
@WebServlet("/DelUserByEmailServlet")
public class DelUserByEmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new UserServicesImpl().delUserByEmail(request.getParameter("email"));
        response.getWriter().print("true");
    }
}
