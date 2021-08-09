package com.itcast.dao;

import com.itcast.domian.Student;

import java.util.ArrayList;

//Dao层接口
public interface StudentDao {
    //查询所有
    public abstract ArrayList<Student> findAll();

    //根据id查询
    public abstract Student findById(Integer id);

    //添加学生
    public abstract int insert(Student stu);

    //修改学生
    public abstract int update(Student stu);

    //根据id删除学生
    public abstract int delete(Integer id);
}
