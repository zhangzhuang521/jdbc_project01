package com.itcast.dao.impl;

import com.itcast.dao.StudentDao;
import com.itcast.domian.Student;
import com.itcast.utils.BeanUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class StudentDaoImpl implements StudentDao {
    Connection conn = null;
    PreparedStatement stam = null;
    ResultSet res = null;

    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            //获取数据库连接
            conn = BeanUtils.getConnection();
            //获取执行sql语句对象
            String sql = "SELECT * FROM student";
            stam = conn.prepareStatement(sql);
            //执行sql语句，返回结果集，封装对象
            res = stam.executeQuery();
            while (res.next()) {
                int sid = res.getInt("sid");
                String name = res.getString("name");
                int age = res.getInt("age");
                double score = res.getDouble("score");
                Date brithday = res.getDate("brithday");
                Student student = new Student(sid, name, age, score, brithday);
                studentArrayList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BeanUtils.colse01(conn, stam, res);
        }

        return studentArrayList;
    }

    @Override
    public Student findById(Integer id) {
        Student student = null;
        try {
            //获取数据库连接
            conn = BeanUtils.getConnection();
            //获取执行sql语句对象
            String sql = "SELECT * FROM student where sid=?";
            stam = conn.prepareStatement(sql);
            stam.setInt(1, id);
            //执行sql语句，返回结果集，封装对象
            res = stam.executeQuery();
            while (res.next()) {
                int sid = res.getInt("sid");
                String name = res.getString("name");
                int age = res.getInt("age");
                double score = res.getDouble("score");
                Date brithday = res.getDate("brithday");
                student = new Student(sid, name, age, score, brithday);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BeanUtils.colse01(conn, stam, res);
        }

        return student;

    }

    @Override
    public int insert(Student stu) {
        int result = 0;
        try {
            //获取数据库连接
            conn = BeanUtils.getConnection();
            //获取执行sql语句对象
            String sql = "insert into student values (null,?,?,?,?)";
            stam = conn.prepareStatement(sql);
//            stam.setInt(1, stu.getId());
            stam.setString(1, stu.getName());
            stam.setInt(2, stu.getAge());
            stam.setDouble(3, stu.getScore());
            java.util.Date date = stu.getBrithday();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String brithday = simpleDateFormat.format(date);
//            stam.setDate(4, new Date(stu.getBrithday().getTime()));
            stam.setDate(4, Date.valueOf(brithday));
            //执行sql语句，返回结果集，封装对象
            result = stam.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BeanUtils.colse02(conn, stam);
        }

        return result;
    }

    @Override
    public int update(Student stu) {
        int result = 0;
        try {
            //获取数据库连接
            conn = BeanUtils.getConnection();
            //获取执行sql语句对象
            String sql = "update student set name=?,age=?,score=?,brithday=? where sid=?";
            stam = conn.prepareStatement(sql);
            ParameterMetaData metaData = stam.getParameterMetaData();
            int parameterCount = metaData.getParameterCount();
//            stam.setInt(1, stu.getId());
            stam.setString(1, stu.getName());
            stam.setInt(2, stu.getAge());
            stam.setDouble(3, stu.getScore());
            java.util.Date date = stu.getBrithday();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String brithday = simpleDateFormat.format(date);
            stam.setDate(4, Date.valueOf(brithday));
            stam.setInt(5, stu.getId());
            //执行sql语句，返回结果集，封装对象
            result = stam.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BeanUtils.colse02(conn, stam);
        }

        return result;
    }

    @Override
    public int delete(Integer id) {
        int result = 0;
        try {
            //获取数据库连接
            conn = BeanUtils.getConnection();
            conn.setAutoCommit(false); //开启事务
            //获取执行sql语句对象
            String sql = "delete from student where sid=?";
//            int a = 1 / 0;
            stam = conn.prepareStatement(sql);
            stam.setInt(1, id);
            //执行sql语句，返回结果集，封装对象
            result = stam.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            BeanUtils.colse02(conn, stam);
        }

        return result;
    }
}
