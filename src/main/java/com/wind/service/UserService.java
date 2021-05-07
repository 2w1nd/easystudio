package com.wind.service;

import com.wind.pojo.User;

import java.sql.SQLException;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean registerUser(User user) throws SQLException;

    /**
     * 用户登陆
     * @param email
     * @param password
     * @return
     */
    public User login(String email, String password);
}
