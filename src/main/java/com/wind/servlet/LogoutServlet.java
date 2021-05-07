package com.wind.servlet;

import com.wind.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月04日 19:20
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //清除session
        req.getSession().removeAttribute(Constants.USER_SESSION);
//        System.out.println(req.getSession().getAttribute(Constants.USER_SESSION));
        resp.sendRedirect(req.getContextPath()+"/login");
    }
}
