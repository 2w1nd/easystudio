package com.wind.service;

import com.wind.pojo.Movie;

import java.util.List;

public interface MovieService {

    /**
     * 获得对应电影信息
     * @param id
     * @return
     */
    public Movie getMovieInfo(String id);

    /**
     * 获取所有电影信息
     * @return
     */
    public List<Movie> getMovieList();

    public boolean uploadMovie(Movie movie);
}
