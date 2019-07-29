package com.li.servlet;

import com.li.domain.User;
import com.li.services.IUserServices;
import com.li.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Program: exam
 * @ClassName: CheckPwdServlet
 * @Description: 更改密码时，输入旧密码，检查密码是否正确
 * @Author: li
 * @Create: 2019-07-23 14:19
 */
@WebServlet("/CheckPwdServlet")
public class CheckPwdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPwd(request.getParameter("oldPwd"));
        IUserServices services = new UserServicesImpl();


        response.getWriter().print(services.queryPwdByEmail(user));
    }
}
