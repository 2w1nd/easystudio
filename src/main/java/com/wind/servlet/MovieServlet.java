package com.wind.servlet;

import com.wind.pojo.Movie;
import com.wind.service.Impl.MovieServiceImpl;
import com.wind.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月02日 13:09
 */
public class MovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        String id = request.getParameter("id");
        MovieService movieService = new MovieServiceImpl();
        Movie movie = movieService.getMovieInfo(id);
        if(movie != null){ // 如果有该影片
            System.out.println("find out movie");
            request.setAttribute("movie",movie);
            request.getRequestDispatcher("/WEB-INF/view/video.jsp").forward(request,response);
        }else { // 如果没有该影片
            System.out.println("not find movie");
            request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request,response);
        }
    }
}
