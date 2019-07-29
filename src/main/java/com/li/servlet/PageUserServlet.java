package com.li.servlet;

import com.li.domain.PageBean;
import com.li.domain.User;
import com.li.services.IUserServices;
import com.li.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: PageUserServlet
 * @Description: 分页加模糊查询User
 * @Author: li
 * @Create: 2019-07-23 19:29
 */
@WebServlet("/PageUserServlet")
public class PageUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();

        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        IUserServices services = new UserServicesImpl();

        if(currentPage == null){
            currentPage = "1";
        }

        if(pageSize == null){
            pageSize = "5";
        }

        PageBean<User> pageUser = services.pageUser(currentPage, pageSize,map);

        request.setAttribute("pu",pageUser);
        request.setAttribute("mp",map);
        request.getRequestDispatcher("member-list.jsp").forward(request, response);
    }
}
