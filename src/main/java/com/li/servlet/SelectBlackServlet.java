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
 * @ClassName: SelectBlackServlet
 * @Description: 将选中User，移除黑名单
 * @Author: li
 * @Create: 2019-07-24 08:53
 */
@WebServlet("/SelectBlackServlet")
public class SelectBlackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailsStr = request.getParameter("emails");

        String[] emails = emailsStr.split(",");
        IUserServices services = new UserServicesImpl();

        for (String email : emails) {
            System.out.println(email);
            services.changStatus(email,-1);
        }

        response.sendRedirect("BlackListServlet");
    }
}
