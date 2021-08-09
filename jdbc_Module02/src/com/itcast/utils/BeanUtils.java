package com.itcast.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//工具类
public class BeanUtils {


    //定义私有构造方法
    private BeanUtils() {
    }

    //定义静态私有成员变量
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    //静态代码块
    static {
        try {
            //通过字节码对象获取流对象
            InputStream resource = BeanUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(resource);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            //注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获取数据库连接对象
    public static Connection getConnection() {
        try {
             conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放资源
    public static void colse01(Connection conn, PreparedStatement stam, ResultSet res) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stam != null) {
            try {
                stam.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void colse02(Connection conn, PreparedStatement stam) {

        colse01(conn, stam, null);

    }

}
