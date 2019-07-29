package com.li.servlet.car;

import com.li.domain.Order;
import com.li.services.IOrderServices;
import com.li.services.impl.OrderServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Program: exam
 * @ClassName: HistoryOrderServlet
 * @Description: 历史订单
 * @Author: li
 * @Create: 2019-07-24 19:10
 */
@WebServlet("/HistoryOrderServlet")
public class HistoryOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOrderServices services = new OrderServicesImpl();
        String email = (String)request.getSession().getAttribute("email");
        String status = request.getParameter("status");

        List<Order> orders = services.queryOrderByEmail(email,Integer.parseInt(status));

        request.setAttribute("list", orders);
        request.getRequestDispatcher("uorder-history.jsp").forward(request, response);
    }
}
