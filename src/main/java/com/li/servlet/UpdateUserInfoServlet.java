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
 * @ClassName: UpdateUserInfoServlet
 * @Description: 更改用户信息
 * @Author: li
 * @Create: 2019-07-23 13:22
 */
@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        IUserServices services = new UserServicesImpl();
        User user = new User();
        user.setUsername(map.get("username")[0]);
        user.setSex(map.get("sex")[0]);
        user.setTel(map.get("tel")[0]);
        user.setAddress(map.get("address")[0]);
        user.setEmail(map.get("email")[0]);

        services.updateUserByEmail(user);

        response.getWriter().print("true");
    }
}
