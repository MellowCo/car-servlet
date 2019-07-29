package com.li.servlet.car;

import com.li.domain.Car;
import com.li.services.impl.CarServicesImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Program: exam
 * @ClassName: CarSearchServlet
 * @Description: 车辆模糊查询
 * @Author: li
 * @Create: 2019-07-24 14:17
 */
@WebServlet("/CarSearchServlet")
public class CarSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        List<Car> cars = new CarServicesImpl().fuzzyQueryByCar(cname);
        JSONArray js = JSONArray.fromObject(cars);

        response.getWriter().print(js);
    }
}
