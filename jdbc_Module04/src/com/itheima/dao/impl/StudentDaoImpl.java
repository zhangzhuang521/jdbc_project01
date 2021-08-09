package com.itheima.dao.impl;

import com.itheima.dao.StudentDao;
import com.itheima.domian.Student;
import com.itheima.utils.JdbcUtils01;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
        ArrayList<Student> arrayList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        try {
            //导入jar包
            //注册驱动
            //获取数据库连接对象
            conn = JdbcUtils01.getConnection();
            //获取执行sql语句对象
            //定义sql 语句
            String s = "select * from student";
            stat = conn.prepareStatement(s);
            //执行sql语句
            res = stat.executeQuery();
            while (res.next()) {
                int sid = res.getInt("sid");
                String name = res.getString("name");
                int age = res.getInt("age");
                double score = res.getDouble("score");
                Date brithday = res.getDate("brithday");
                Student student = new Student(sid, name, age, score, brithday);
                arrayList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils01.close(conn, stat, res);
        }
        return arrayList;
    }

    @Override
    public Student findBysId(Integer sid) {
        Student student = null;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        try {
            //导入jar包
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db3", "root", "itcast");
            //获取执行sql语句对象
            //定义sql 语句
            String s = "select * from student where sid=?";
            stat = conn.prepareStatement(s);
            stat.setInt(1, sid);
            //执行sql语句
            res = stat.executeQuery();
            while (res.next()) {
                int sid1 = res.getInt("sid");
                String name = res.getString("name");
                int age = res.getInt("age");
                double score = res.getDouble("score");
                Date brithday = res.getDate("brithday");
                student = new Student(sid1, name, age, score, brithday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils01.close(conn, stat, res);
        }

        return student;
    }

    @Override
    public int insert(Student str) {
        int result = 0;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        try {
            //导入jar包
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db3", "root", "itcast");
            //获取执行sql语句对象
            //定义sql 语句
            String s = "insert INTO student values(null,?,?,?,?)";
            stat = conn.prepareStatement(s);
            stat.setString(1, str.getName());
            stat.setInt(2, str.getAge());
            stat.setDouble(3, str.getScore());
            java.util.Date date = str.getBrithday();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-hh");
            String brithday = format.format(date);
            stat.setDate(4, Date.valueOf(brithday));
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils01.close(conn, stat);
        }

        return result;
    }

    @Override
    public int update(Student str) {
        int result = 0;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        try {
            //导入jar包
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db3", "root", "itcast");
            //获取执行sql语句对象
            //定义sql 语句
            String s = "update student set name=? where sid=?";
            stat = conn.prepareStatement(s);
            stat.setString(1, str.getName());
            stat.setInt(2, str.getSid());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils01.close(conn, stat);
        }

        return result;
    }

    @Override
    public int delete(Integer sid) {
        int result = 0;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet res = null;

        try {
            //导入jar包
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db3", "root", "itcast");
            conn.setAutoCommit(false);
//            int a = 1 / 0;
            //获取执行sql语句对象
            //定义sql 语句
            String s = "delete from student where sid=?";
            stat = conn.prepareStatement(s);
            stat.setInt(1, sid);
            result = stat.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JdbcUtils01.close(conn, stat);
        }

        return result;
    }
}
