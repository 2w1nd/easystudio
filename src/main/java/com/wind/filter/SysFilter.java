package com.wind.filter;

import com.wind.pojo.User;
import com.wind.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 过滤未登录用户
 * @author: w1nd
 * @date: 2021年05月02日 10:27
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        System.out.println("SysFilter doFilter()===========");
        HttpServletRequest rq = (HttpServletRequest)request;
        HttpServletResponse rp = (HttpServletResponse)response;
        User userSession = (User)rq.getSession().getAttribute(Constants.USER_SESSION);
        System.out.println("sysfilter：" + userSession);
        if(null == userSession){
            rp.sendRedirect(((HttpServletRequest) request).getContextPath() + "/error");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
