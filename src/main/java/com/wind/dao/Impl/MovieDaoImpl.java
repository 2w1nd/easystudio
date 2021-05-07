package com.wind.dao.Impl;

import com.wind.dao.BaseDao;
import com.wind.dao.MovieDao;
import com.wind.pojo.Movie;
import com.wind.pojo.User;

import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月02日 12:56
 */
public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie getMovieById(Connection connection, String id) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Movie movie = null;
        if(connection != null){
            String sql = "select * from movie where id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, rs, sql, params);
            if(rs.next()) {
                movie = new Movie();
                movie.setId(rs.getString("id"));
                System.out.println("DAO" + rs.getString("id"));
                movie.setName(rs.getString("name"));
                movie.setYears(rs.getString("years"));
                movie.setImage(rs.getString("image"));
                movie.setUrl(rs.getString("url"));
                movie.setPoster(rs.getString("poster"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return movie;
    }

    @Override
    public List<Movie> getMovieList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Movie> movieList = new ArrayList<Movie>();
        if(connection != null){
            String sql = "select * from movie";
            Object[] params = {};
            rs = BaseDao.execute(connection, rs, sql, params);
            while(rs.next()){
                Movie _movie = new Movie();
                _movie.setId(rs.getString("id"));
                _movie.setName(rs.getString("name"));
                _movie.setYears(rs.getString("years"));
                _movie.setImage(rs.getString("image"));
                _movie.setUrl(rs.getString("url"));
                _movie.setPoster(rs.getString("poster"));
                movieList.add(_movie);
            }
            BaseDao.closeResource(null, pstm, rs);
        }

        return movieList;
    }

    @Override
    public int addMovie(Connection connection, Movie movie) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if(connection != null){
            String sql = "insert into movie (id, name, url, years,image, poster) " +
                    "values (?, ?, ?, ?, ?, ?);";
            Object[] params = {movie.getId(),movie.getName(), movie.getUrl(),movie.getYears(),movie.getImage(),movie.getPoster()};
            updateRows = BaseDao.execute(connection, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }
}
