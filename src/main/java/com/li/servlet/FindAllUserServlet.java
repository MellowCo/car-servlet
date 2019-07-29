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
import java.util.List;

/**
 * @Program: exam
 * @ClassName: FindAllUserServlet
 * @Description: 查找所有User
 * @Author: li
 * @Create: 2019-07-23 10:05
 */
@WebServlet("/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserServices services = new UserServicesImpl();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


        response.getWriter().print("aaaaaaaaaaaaa");

        List<User> users = services.queryAllUser();
        request.setAttribute("list",users);
        request.getRequestDispatcher("member-list.jsp").forward(request,response);
    }
}
