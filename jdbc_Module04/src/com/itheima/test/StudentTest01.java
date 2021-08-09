package com.itheima.test;

import com.itheima.domian.Student;
import com.itheima.utils.JdbcUtils;
import com.mysql.fabric.xmlrpc.base.Data;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentTest01 {
    //创建jdbcTemplate模板对象 ，参数数据源
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    //添加数据
    @Test
    public void insert() {
        //定义sql语句
        String s = "insert into student values(null,?,?,?,?)";
        int result = jdbcTemplate.update(s, "xiaoshiyi", 22, 89.6, "1995-01-01");
        if (result > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    //修改数据
    @Test
    public void update() {
        //定义sql语句
        String s = "update student set age=? where name=? ";
        int result = jdbcTemplate.update(s, 23, "xiaosis");
        if (result > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    //删除数据
    @Test
    public void delete() {
        //定义sql语句
        String s = "delete from student where sid=? ";
        int result = jdbcTemplate.update(s, 5);
        if (result > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    //查询一条数据，封装成map对象
    @Test
    public void queryForMap() {
        //定义sql语句
        String s = "select * from student where sid=? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(s, 2);
        System.out.println(map);
    }

    //查询多条数据，封装成list对象
    @Test
    public void queryForList() {
        //定义sql语句
        String s = "select * from student ";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(s);
        System.out.println(mapList);
    }

    //查询多条语句，封装成实体对象
    @Test
    public void query() {
        //定义sql语句
        String s = "select * from student ";
        List<Student> studentList = jdbcTemplate.query(s, new BeanPropertyRowMapper<>(Student.class));
        for (Student student : studentList) {
            Date date = student.getBrithday();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
            String brithday= simpleDateFormat.format(date);
            System.out.println(student.getSid()+" "+student.getName()+" "+student.getAge()+" "+student.getScore()+" "+brithday);
        }
    }

    //查询一条语句，封装成对象。主要查询单挑语句，字段所对应的单个值，或者统计之类的
    @Test
    public void queryForObject() {
        //定义sql语句
//        String s = "select count(*) from student";
//        Long aLong = jdbcTemplate.queryForObject(s, Long.class);
//        System.out.println(aLong);
        String s = "select brithday from student where sid=?";
        Date date = jdbcTemplate.queryForObject(s, Date.class, 3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-hh");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
