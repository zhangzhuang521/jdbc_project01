package com.itheima.service.impl;

import com.itheima.dao.StudentDao;
import com.itheima.dao.impl.StudentDaoImpl;
import com.itheima.domian.Student;
import com.itheima.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findBysId(Integer sid) {
        return studentDao.findBysId(sid);
    }

    @Override
    public int insert(Student str) {
        return studentDao.insert(str);
    }

    @Override
    public int update(Student str) {
        return studentDao.update(str);
    }

    @Override
    public int delete(Integer sid) {
        return studentDao.delete(sid);
    }
}
