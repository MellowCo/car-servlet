package com.li.servlet;

import com.li.domain.User;
import com.li.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: ChangePwdServlet
 * @Description: 根据email改密码
 * @Author: li
 * @Create: 2019-07-23 14:03
 */
@WebServlet("/ChangePwdServlet")
public class ChangePwdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= new User();
        user.setEmail(request.getParameter("email"));
        user.setPwd(request.getParameter("pwd"));
        new UserServicesImpl().changePwdByEmail(user);
        System.out.println(user);

        response.getWriter().print("true");
    }
}
