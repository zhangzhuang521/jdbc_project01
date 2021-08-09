package com.itcast.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourcesUtils {
    //私有构造方法
    private DataSourcesUtils() {
    }

    //私有成员变量
    private static Connection conn;
    private static PreparedStatement stat;
    private static ResultSet res;
    private static DataSource dataSource;

    //静态代码块
    static {

        try {
            //加载配置文件
            InputStream inputStream = DataSourcesUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pro = new Properties();
            pro.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //提供一个获取connection的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //提供一个获取dataSource的方法
    public static DataSource getDataSource() {
        return dataSource;
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
