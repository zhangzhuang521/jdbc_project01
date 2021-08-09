package com.itcast.dao;

import com.itcast.domian.Student;

import java.util.List;

//定义接口 dao层
public interface StudentDao {
    //查询全部
    public abstract List<Student> findAll();

    //根据id查询单个
    public abstract Student findById(int id);

    //添加数据
    public abstract int insert(Student stu);

    //修改数据
    public abstract int update(Student stu);

    //删除数据
    public abstract int update(int id);

}
