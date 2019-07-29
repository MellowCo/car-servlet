package com.li.servlet.car;

import com.li.dao.impl.CarDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: CarChangeStatusServlet
 * @Description: ${description}
 * @Author: li
 * @Create: 2019-07-24 20:46
 */
@WebServlet("/CarChangeStatusServlet")
public class CarChangeStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        int status = Integer.parseInt(request.getParameter("status"));

        new CarDaoImpl().changeCarStatus(Integer.parseInt(cid),-status);
    }
}
