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

/**
 * @Program: exam
 * @ClassName: PutOrderServlet
 * @Description: ${description}
 * @Author: li
 * @Create: 2019-07-24 16:02
 */
@WebServlet("/PutOrderServlet")
public class PutOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String crent = request.getParameter("crent");
        String takeTime = request.getParameter("takeTime");
        String getTime = request.getParameter("getTime");
        String email = (String)request.getSession().getAttribute("email");
        String cname = request.getParameter("cname");

        Order order = new Order(Integer.parseInt(cid),cname,email,Double.parseDouble(crent),takeTime,getTime,1);

        IOrderServices services = new OrderServicesImpl();
        services.addOrder(order);

        response.sendRedirect("OrderPageServlet?status=1");

    }
}
