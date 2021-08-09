package com.itheima.controller;

import com.itheima.domian.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ControllerTest01 {
    private StudentService studentService=new StudentServiceImpl();
    //findAll()
    @Test
    public void test01(){
        List<Student> studentsList = studentService.findAll();
        System.out.println(studentsList);
    }
    @Test
    public void test02(){
        Student student = studentService.findBysId(2);
        System.out.println(student);
    }
    @Test
    public void test03(){
        String S="1991-12-22";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-hh");
        Date date = null;
        try {
            date = format.parse(S);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(null, "xiaowu", 18, 95.6, date);
        int result = studentService.insert(student);
        System.out.println(result);
    }
    @Test
    public void test04(){
        Student student = studentService.findBysId(8);
        student.setName("xiaoliu");
        int result = studentService.update(student);
        System.out.println(result);
    }
    @Test
    public void test05(){
        int result= studentService.delete(8);
        System.out.println(result);


    }
}
