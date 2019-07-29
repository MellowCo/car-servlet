package com.li.servlet.car;

import com.li.domain.Car;
import com.li.domain.PageBean;
import com.li.services.ICarServices;
import com.li.services.impl.CarServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: PageCarServlet
 * @Description: 分页加模糊查询Car
 * @Author: li
 * @Create: 2019-07-24 20:03
 */
@WebServlet("/PageCarServlet")
public class PageCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        ICarServices services = new CarServicesImpl();

        if(currentPage == null){
            currentPage = "1";
        }

        if(pageSize == null){
            pageSize = "5";
        }

        PageBean<Car> pageCar = services.pageCar(currentPage, pageSize,map);

        request.setAttribute("pu",pageCar);
        request.setAttribute("mp",map);
        request.getRequestDispatcher("car-list.jsp").forward(request, response);
    }
}
