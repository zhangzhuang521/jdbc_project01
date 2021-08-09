package com.itcast.service.impl;

import com.itcast.dao.StudentDao;
import com.itcast.dao.impl.StudentDaoImpl;
import com.itcast.domian.Student;
import com.itcast.service.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public ArrayList<Student> findAll() {

        return studentDao.findAll();
    }

    @Override
    public Student findById(Integer id) {

        return studentDao.findById(id);
    }

    @Override
    public int insert(Student stu) {

        return studentDao.insert(stu);
    }

    @Override
    public int update(Student stu) {

        return studentDao.update(stu);
    }

    @Override
    public int delete(Integer id) {

        return studentDao.delete(id);
    }
}
