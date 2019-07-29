package com.li.servlet.car;

import com.li.services.ICarServices;
import com.li.services.impl.CarServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: CarChangeSelectServlet
 * @Description: ${description}
 * @Author: li
 * @Create: 2019-07-24 20:57
 */
@WebServlet("/CarChangeSelectServlet")
public class CarChangeSelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _cids = request.getParameter("cids");
        int status = Integer.parseInt(request.getParameter("status"));

        System.out.println(status);

        ICarServices services = new CarServicesImpl();

        String[] ids = _cids.split(",");

        for (String id : ids) {
            services.changeCarStatus(Integer.parseInt(id),status);
        }

        response.sendRedirect("PageCarServlet");
    }
}
