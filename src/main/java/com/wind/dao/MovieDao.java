package com.wind.dao;

import com.wind.pojo.Movie;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface MovieDao {

    /**
     * 根据id获取电影信息
     * @param connection
     * @param id
     * @return
     */
    public Movie getMovieById(Connection connection, String id) throws SQLException;

    /**
     * 返回所有电影信息
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Movie> getMovieList(Connection connection) throws SQLException;

    /**
     * 新增电影信息
     * @param connection
     * @param movie
     * @return
     * @throws SQLException
     */
    public int addMovie(Connection connection, Movie movie) throws SQLException;
}
