package com.itcast.collecter;


import com.itcast.domian.Student;
import com.itcast.service.StudentService;
import com.itcast.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class TsetController {
    StudentService studentService = new StudentServiceImpl();
    @Test
    public void test01() {

        List<Student> studentList = studentService.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    @Test
    public void test02(){
        Student student = studentService.findById(3);
        System.out.println(student);
    }
}
