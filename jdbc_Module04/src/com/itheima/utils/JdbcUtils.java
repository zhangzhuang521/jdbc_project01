package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.PreparedStatement;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//工具类
public class JdbcUtils {
    //私有构造方法
    private JdbcUtils() {
    }

    //私有声明变量
    private static DataSource dataSource;
    private static Connection conn;
    private static PreparedStatement stat;
    private static ResultSet res;
    //静态代码块
    static {
        try {
            //读取配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //创建配置文件对象，加载配置文件
            Properties pro = new Properties();
            pro.load(inputStream);
            //获取数据库连接对象
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义一个方法获取数据库对象
    public static DataSource getDataSource() {
        return dataSource;
    }

    //定义一个方法获取数据库连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
