package com.wind.service.Impl;

import com.wind.dao.BaseDao;
import com.wind.dao.Impl.UserDaoImpl;
import com.wind.dao.UserDao;
import com.wind.pojo.User;
import com.wind.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.zip.CheckedOutputStream;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月01日 10:53
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean registerUser(User user) throws SQLException {
        boolean flag = false;
        Connection connection = null;

        connection = BaseDao.getConnection();

        String email = user.getEmail();
        System.out.println("service" + email);
        if(userDao.getLoginUserByEmail(connection, email) == null) // 防止重复
        {
            try {
                    connection.setAutoCommit(false);//开启JDBC事务管理
                    int updateRows = userDao.addUser(connection,user);
                    connection.commit();
                    if(updateRows > 0){
                        flag = true;
                        System.out.println("add success!");
                    }else{
                        System.out.println("add failed!");
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
        }
        return flag;
    }

    @Override
    public User login(String email, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUserByEmail(connection, email);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }

        //匹配密码
        if(null != user){
            if(!user.getPassword().equals(password))
                user = null;
        }

        return user;
    }
}
