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
 * @ClassName: UserLoginServlet
 * @Description: 用户登陆
 * @Author: li
 * @Create: 2019-07-24 10:47
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");

        IUserServices services = new UserServicesImpl();
        int i = services.userLogin(new User(email,pwd));

        //1:登陆成功
        if(i == 1){
            request.getSession().setAttribute("email",email);
        }
        response.getWriter().print(i);
    }
}
