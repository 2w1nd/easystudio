package com.wind.dao;

import com.wind.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    /**
     * 增加用户信息
     * @param connection
     * @param user
     * @return
     */
    public int addUser(Connection connection, User user) throws SQLException;

    /**
     * 根据邮箱获取用户信息
     * @param connection
     * @param email
     * @return
     */
    public User getLoginUserByEmail(Connection connection, String email) throws SQLException;

    /**
     * 修改用户信息
     * @param connection
     * @param user
     * @return
     */
    public int modifyUser(Connection connection, User user);
}
