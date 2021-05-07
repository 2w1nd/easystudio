package com.wind.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *  操作数据库的基类
 */
public class BaseDao {
    static { // 静态代码块，在类加载时候执行
        init();
    }

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    // 初始化连接参数，在配置文件中获得
    public static void init(){
        Properties properties = new Properties();
        String configFile = "database.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        user=properties.getProperty("username");
        password=properties.getProperty("password");
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 更新操作
     * @param connection
     * @param sql
     * @param params
     * @return
     */
    public static int execute(Connection connection, String sql, Object[] params) throws SQLException {
        int updateRows = 0;
        PreparedStatement pstm = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        return updateRows;
    }

    /**
     * 查询操作
     * @param connection
     * @param rs
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public static ResultSet execute(Connection connection, ResultSet rs,
                                    String sql, Object[] params) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        rs = pstm.executeQuery();
        return rs;
    }

    /**
     * 释放资源
     * @param connection
     * @param pstm
     * @param rs
     * @return
     */
    public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;
        if(rs != null){
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(pstm != null){
            try {
                pstm.close();
                pstm = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                connection = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        Connection connection = baseDao.getConnection();
        if (connection != null) System.out.println("success");
        else System.out.println("no");
    }
}
