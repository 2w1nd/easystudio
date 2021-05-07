package com.wind.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description: 乱码过滤
 * @author: w1nd
 * @date: 2021年05月02日 10:24
 */
public class CharacterEncoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        System.out.println("characterencoding ======");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
