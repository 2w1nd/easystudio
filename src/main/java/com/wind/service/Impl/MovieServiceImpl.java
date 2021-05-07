package com.wind.service.Impl;

import com.wind.dao.BaseDao;
import com.wind.dao.Impl.MovieDaoImpl;
import com.wind.dao.MovieDao;
import com.wind.pojo.Movie;
import com.wind.service.MovieService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月02日 13:05
 */
public class MovieServiceImpl implements MovieService {

    private MovieDao movieDao;
    public MovieServiceImpl(){ movieDao = new MovieDaoImpl(); }

    @Override
    public Movie getMovieInfo(String id) {
        Connection connection = null;
        Movie movie = null;
        try {
            connection = BaseDao.getConnection();
            movie = movieDao.getMovieById(connection, id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }

        return movie;
    }

    @Override
    public List<Movie> getMovieList() {
        Connection connection = null;
        List<Movie> movieList = null;
        try {
            connection = BaseDao.getConnection();
            movieList = movieDao.getMovieList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return movieList;
    }

    @Override
    public boolean uploadMovie(Movie movie) {
        boolean flag = false;
        Connection connection = null;
        connection = BaseDao.getConnection();

        try {
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = movieDao.addMovie(connection, movie);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("upload success!");
            }else{
                System.out.println("upload failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }
}
