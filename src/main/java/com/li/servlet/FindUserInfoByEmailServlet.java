package com.li.servlet;

import com.li.domain.User;
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
 * @ClassName: FindUserInfoByEmailServlet
 * @Description: 根据邮箱，返回User的信息
 * @Author: li
 * @Create: 2019-07-23 13:34
 */
@WebServlet("/FindUserInfoByEmailServlet")
public class FindUserInfoByEmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        IUserServices services = new UserServicesImpl();

        User user = services.queryUserInfoByEmail(email);
        request.setAttribute("user",user);
        request.getRequestDispatcher("member-edit.jsp").forward(request, response);
    }
}
