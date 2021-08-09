package com.itheima.service;

import com.itheima.domian.Student;

import java.util.List;

public interface StudentService {

    //查询所有
    public abstract List<Student> findAll();

    //根据id查询单条语句
    public abstract Student findBysId(Integer sid);

    //添加语句
    public abstract int insert(Student str);

    //修改语句
    public abstract int update(Student str);

    //删除语句
    public abstract int delete(Integer sid);
}
