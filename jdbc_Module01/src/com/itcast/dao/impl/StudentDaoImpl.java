package com.itcast.dao.impl;

import com.itcast.dao.StudentDao;
import com.itcast.domian.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {

        ArrayList<Student> students = new ArrayList<>();

        try {
//        1.导入jar包
//        2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//        3.获取数据库连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db2", "root", "itcast");
//        4.获取sql语句执行对象
            String SQL = "SELECT * FROM student";
            PreparedStatement statement = conn.prepareStatement(SQL);
//        5.执行sql语句 获取结果集 封装实体对象
            ResultSet resultSet = statement.executeQuery();
//        6.遍历对象
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setScore(resultSet.getDouble(4));
                student.setBrithday(resultSet.getDate(5));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return students;
    }

    @Override
    public Student findById(int id) {
        Student student=null;
        try {
//        1.导入jar包
//        2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//        3.获取数据库连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db2", "root", "itcast");
//        4.获取sql语句执行对象
            String SQL = "SELECT * FROM student where id=?";
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1,id);
//        5.执行sql语句 获取结果集 封装实体对象
            ResultSet resultSet = statement.executeQuery();
//        6.遍历对象

            while(resultSet.next()){
                 student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setAge(resultSet.getInt(3));
                student.setScore(resultSet.getDouble(4));
                student.setBrithday(resultSet.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return student;
    }

    @Override
    public int insert(Student stu) {
        return 0;
    }

    @Override
    public int update(Student stu) {
        return 0;
    }

    @Override
    public int update(int id) {
        return 0;
    }
}
