package com.li.servlet.car;

import com.li.domain.Car;
import com.li.services.ICarServices;
import com.li.services.impl.CarServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Program: exam
 * @ClassName: OrderServlet
 * @Description: 车辆订单页面
 * @Author: li
 * @Create: 2019-07-24 15:45
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");

        ICarServices services = new CarServicesImpl();
        Car car = services.queryCarById(Integer.parseInt(cid));

        //取车时间加2天
        Calendar ca = Calendar.getInstance();
        Date time = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String takeTime = formatter.format(new Date());

        ca.add(Calendar.DATE,2);

        String getTime = formatter.format(ca.getTime());

        request.setAttribute("car", car);
        request.setAttribute("takeTime", takeTime);
        request.setAttribute("getTime", getTime);
        request.getRequestDispatcher("user-order.jsp").forward(request,response);

    }
}
