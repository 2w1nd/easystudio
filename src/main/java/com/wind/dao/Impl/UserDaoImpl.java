package com.wind.dao.Impl;

import com.wind.dao.BaseDao;
import com.wind.dao.UserDao;
import com.wind.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(Connection connection, User user) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if(connection != null){
            String sql = "insert into user (id, username, password, email) " +
                    "values (?, ?, ?, ?);";
            Object[] params = {user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
            updateRows = BaseDao.execute(connection, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public User getLoginUserByEmail(Connection connection, String email) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if(connection != null){
            String sql = "select * from user where email = ?";
            Object[] params = {email};
            rs = BaseDao.execute(connection, rs, sql, params);
            if(rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    @Override
    public int modifyUser(Connection connection, User user) {
        return 0;
    }
}
