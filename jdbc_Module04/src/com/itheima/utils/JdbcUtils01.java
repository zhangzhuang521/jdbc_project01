package com.itheima.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//工具类
public class JdbcUtils01 {
    //私有构造方法
    private JdbcUtils01() {
    }

    //私有声明变量
    private static String driver;
    private static String url;
    private static String name;
    private static String password;
    private static Connection conn;

    //静态代码块
    static {
        try {
            //读取配置文件
            InputStream inputStream = JdbcUtils01.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //创建配置文件对象，加载配置文件
            Properties pro = new Properties();
            pro.load(inputStream);
            //获取配置文件中的内容
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            name = pro.getProperty("name");
            password = pro.getProperty("password");
            //注册驱动
            Class.forName(driver);
            //获取数据库连接对象
            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义一个方法获取数据库连接
    public static Connection getConnection() {
        return conn;
    }

    //释放资源
    public static void close(Connection conn, PreparedStatement stat, ResultSet res) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
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

    public static void close(Connection conn, PreparedStatement stat) {
        close(conn, stat, null);
    }
}
