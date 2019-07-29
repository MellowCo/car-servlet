package com.li.servlet.car;

import com.li.domain.Car;
import com.li.services.ICarServices;
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
 * @ClassName: CarServlet
 * @Description: ${description}
 * @Author: li
 * @Create: 2019-07-24 13:25
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取排序方式
        String sort = request.getParameter("sort");
        ICarServices services = new CarServicesImpl();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");


        if ("desc".equals(sort)) {
            //按租金降序
            List<Car> cars = services.sortCars(-1);
            JSONArray js = JSONArray.fromObject(cars);
            response.getWriter().print(js);
        } else if ("asc".equals(sort)) {
            //按租金升序
            List<Car> cars = services.sortCars(1);
            JSONArray js = JSONArray.fromObject(cars);
            response.getWriter().print(js);
        } else if ("default".equals(sort)) {
            //按cname排序
            List<Car> cars = services.sortCars(0);
            JSONArray js = JSONArray.fromObject(cars);
            response.getWriter().print(js);
        }else{
            List<Car> cars = services.sortCars(0);
            request.setAttribute("cars",cars);
            request.getRequestDispatcher("car.jsp").forward(request, response);
        }

    }
}
