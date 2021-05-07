package com.wind.servlet;

import com.wind.pojo.Movie;
import com.wind.pojo.User;
import com.wind.service.Impl.MovieServiceImpl;
import com.wind.service.Impl.UserServiceImpl;
import com.wind.service.MovieService;
import com.wind.service.UserService;
import com.wind.util.Constants;
import com.wind.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月01日 11:05
 * */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        System.out.println("method ----->" + method);

        if(method != null && method.equals("register")){
            // 注册操作
            try {
                this.add(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(method != null && method.equals("login")){
            // 登陆操作
            this.getMovieList(req, resp);
            this.login(req, resp);
        }else if(method != null && method.equals("query")){
            this.getMovieList(req, resp);
        }
    }

    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        System.out.println("register =======");
//        String id = request.getParameter("userid");
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("pwd");
        String email = request.getParameter("email");

        User user = new User();
        user.setId(new UUID().getId());
        user.setUsername(userName);
        user.setPassword(userPassword);
        user.setEmail(email);

        UserService userService = new UserServiceImpl();
        if(userService.registerUser(user)){
            request.setAttribute("info","注册成功");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        }else{
            request.setAttribute("info","注册失败");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        }
    }

    /**
     * 登陆
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("login ========");
        // 获取用户名和密码
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        // 调用service方法,进行用户匹配
        UserService userService = new UserServiceImpl();
        User user = userService.login(email, password);
        if(null != user){//登录成功
            System.out.println("login success!");
            //放入session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            //页面跳转（frame.jsp）
//            response.sendRedirect("/view/home.jsp");
            request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request,response);
        }else{
            System.out.println("login fail");
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "邮箱或密码不正确");
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        }
    }

    /**
     * 加载电影资源
     * @param request
     * @param response
     */
    private void getMovieList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("load movie...");
        MovieService movieService = new MovieServiceImpl();
        List<Movie> movieList = movieService.getMovieList();
        System.out.println("有" + movieList.size() + "部电影");
        request.setAttribute("movies",movieList);
//        request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
    }
}
