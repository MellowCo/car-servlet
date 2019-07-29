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
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: RegisterServlet
 * @Description: 添加用户
 * @Author: li
 * @Create: 2019-07-23 10:18
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserServices services = new UserServicesImpl();
        Map<String, String[]> map = request.getParameterMap();

        User user = new User(map.get("email")[0],map.get("username")[0],map.get("pwd")[0],map.get("sex")[0],map.get("tel")[0],map.get("address")[0],1);
        System.out.println(user);
        services.register(user);
        response.getWriter().print("true");
    }
}
