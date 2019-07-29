package com.li.servlet.car;

import com.li.domain.Order;
import com.li.domain.PageBean;
import com.li.services.IOrderServices;
import com.li.services.impl.OrderServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: PageOrderServlet
 * @Description: ${description}
 * @Author: li
 * @Create: 2019-07-24 22:11
 */
@WebServlet("/PageOrderServlet")
public class PageOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        IOrderServices services = new OrderServicesImpl();

        if(currentPage == null){
            currentPage = "1";
        }

        if(pageSize == null){
            pageSize = "5";
        }

        PageBean<Order> pageOrder = services.pageOrder(currentPage, pageSize,map);

        request.setAttribute("pu",pageOrder);
        request.setAttribute("mp",map);
        request.getRequestDispatcher("order-list.jsp").forward(request, response);
    }
}
