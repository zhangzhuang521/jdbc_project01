package com.itcast.controller;

import com.itcast.domian.Student;
import com.itcast.service.StudentService;
import com.itcast.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestContoller {

    private StudentService studentService=new StudentServiceImpl();

    @Test
    public void testFindAll(){
        ArrayList<Student> studentArrayList = studentService.findAll();
        for (Student student : studentArrayList) {
            System.out.println(student);
        }
    }

    @Test
    public void testFindById(){
        Student student = studentService.findById(3);
        System.out.println(student);
    }
    @Test
    public void testInsert() throws ParseException {
//        String s="2010-08-10";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse(s);
        Student student = new Student(null ,"xiaowu", 20, 95.4, new Date());
        int result = studentService.insert(student);
        System.out.println(result);

    }
    @Test
    public void testUpdate() throws ParseException {
        String s="2010-08-10";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        Student student = new Student(10 ,"xiaoshiyi", 12, 90.4, date);
        int result = studentService.update(student);
        System.out.println(result);

    }
    @Test
    public void testDelete() throws ParseException {
//        String s="2010-08-10";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse(s);
        int result = studentService.delete(14);
        System.out.println(result);

    }
}
