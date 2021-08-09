package com.itcast.service.impl;

import com.itcast.dao.StudentDao;
import com.itcast.dao.impl.StudentDaoImpl;
import com.itcast.domian.Student;
import com.itcast.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAll() {

        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {

        return studentDao.findById(id);
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
