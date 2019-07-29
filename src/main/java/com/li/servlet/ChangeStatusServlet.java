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
 * @ClassName: ChangeStatusServlet
 * @Description: 更改用户的状态，拉黑，可用
 * @Author: li
 * @Create: 2019-07-23 16:37
 */
@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new UserServicesImpl().changStatus(request.getParameter("email"),Integer.parseInt(request.getParameter("status")));
    }
}
