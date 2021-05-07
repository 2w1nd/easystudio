package com.wind.servlet;

import com.wind.pojo.Movie;
import com.wind.pojo.User;
import com.wind.service.Impl.MovieServiceImpl;
import com.wind.service.MovieService;
import com.wind.util.Constants;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月04日 9:59
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        System.out.println("method ----->" + method);
        String poster_url = req.getParameter("poster");
        String back_url = req.getParameter("back");
        String movie_url = req.getParameter("movie");
        System.out.println(poster_url);
        System.out.println(back_url);
        System.out.println(movie_url);
        if(method != null && method.equals("enter")){   // 进入
//            User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
//            System.out.println("upload : " + user.getId());
            req.getRequestDispatcher("/WEB-INF/view/upload.jsp").forward(req,resp);
        } else if(method != null && method.equals("upload")){

            this.upload(req, resp);
        } else if (method != null && method.equals("query")){

        }
    }

    /**
     * 上传资源
     * @param request
     * @param response
     */
    private void upload(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        //        设置编码方式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

//        设置输出
        PrintWriter outprint = response.getWriter();

//        设置文件目录
        String webroot = this.getServletContext().getRealPath("/");
        File temppath = new File(webroot + "fileuploadtemp");
        String dir = webroot+ File.separator + "/static/images"; // 图片目录
        String dir1 = webroot+ File.separator + "/static/video"; // 视频目录
        File path = new File(webroot+ File.separator + "/static/images"); // 图片
        File path1 = new File(webroot+ File.separator + "/static/video"); // 视频

        if (!temppath.exists()) {
            temppath.mkdir();
        }
        if (!path.exists()) {
            path.mkdir();
        }
        if (!path1.exists()){
            path.mkdir();
        }

//      设置文件类型(后期可新增文件类型)
        String[] type= new String[]{".jpg",".png",".jpeg",".gif",".mp4"};

//      创建文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024,
                temppath);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024 * 1024 * 10);
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            Iterator<FileItem> it = fileItems.iterator();
            Movie movie = new Movie();
            movie.setId(String.valueOf(System.currentTimeMillis()));
            int cnt = 0; // 记录当前是第几张图
//            遍历request file
            while (it.hasNext()) {
                FileItem fi = it.next();
//                判断该表单为普通表单类型
                if (fi.isFormField()) {
                    System.out.println("字段名：" + fi.getFieldName());
                    System.out.println("字段值：" + fi.getString());
                    if (fi.getFieldName().equals("method")){
                        continue;
                    } else if (fi.getFieldName().equals("name")){
                        movie.setName(fi.getString("utf-8"));
                    } else if (fi.getFieldName().equals("years")){
                        movie.setYears(fi.getString());
                    }
                } else {
                    InputStream in = fi.getInputStream();
                    String name = fi.getName();//获得文件原名
                    System.out.println("文件原名：" + name);
//                    得到文件后缀名
                    int index = name.lastIndexOf(".");
                    String endWith = name.substring(index);

//                    判断是否符合类型
                    boolean TypeExists = Arrays.asList(type).contains(endWith);
                    if (!TypeExists) {
                        outprint.print("<script>\n" +
                                "alert(\"文件类型错误，只允许jpg,png,jpeg,gif,mp4\");location=\"fileup.html\";\n" +
                                "</script>");
                        return;
                    }

                    String newFimeName = System.currentTimeMillis() + endWith;//新文件名

                    FileOutputStream out = null;
                    System.out.println(endWith);
                    if(endWith.equals(".mp4")){  // 如果视频文件
                        //创建上传文件
                        out = new FileOutputStream(new File(
                                dir1 + "/" + newFimeName));
                        movie.setUrl(newFimeName);
                    }else{
                        //创建上传文件
                        out = new FileOutputStream(new File(
                                dir + "/" + newFimeName));
                        if (cnt == 0){
                            movie.setImage(newFimeName);
                            cnt ++;
                        }else {
                            movie.setPoster(newFimeName);
                        }
                    }

                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);//写入大小
                    }
                    in.close();
                    out.close();
                    fi.delete();
                }
            }
            // 上传到数据库
            MovieService movieService = new MovieServiceImpl();
            if(movieService.uploadMovie(movie)){
                this.getMovieList(request,response);
                request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request,response);
            }else{
                request.setAttribute("info","上传失败");
            }
        } catch(FileUploadException e){
            response.getWriter().write(e.toString());
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
        request.setAttribute("movies",movieList);
//        request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
    }
}
