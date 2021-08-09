package com.itcast.dao;

import com.itcast.domian.Student;
import com.itcast.utils.DataSourcesUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class StudentDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourcesUtils.getDataSource());

    @Test
    public void test01() {
        //添加数据
        String insert = "insert into student values(null,?,?,?,?)";
        int result = jdbcTemplate.update(insert, "lili", 18, 95.6, "1991-12-22");
        System.out.println(result);
    }

    @Test
    public void test02() {
        //添加数据
        String update = "update student set name=? where sid=?";
        int result = jdbcTemplate.update(update, "lizhi", 10);
        System.out.println(result);
    }

    @Test
    public void test03() {
        //添加数据
        String delete = "delete from student where  sid=?";
        int result = jdbcTemplate.update(delete, 16);
        System.out.println(result);
    }

    @Test
    public void test04() {
        //添加数据
        String select = "select * from student where sid>=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(select,0 );
        System.out.println(maps);
    }
    @Test
    public void test05() {
        //添加数据
        String select = "select * from student where sid=?";
        Map<String, Object> map = jdbcTemplate.queryForMap(select, 2);
        System.out.println(map);
    }
    @Test
    public void test06() {
        //添加数据
        String select = "select * from student";
        List<Student> students = jdbcTemplate.query(select, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(students);
    }

    @Test
    public void test07() {
        //添加数据
        String select = "select count(*) from student";
       /* String s = jdbcTemplate.queryForObject(select, String.class);*/
        Long aLong = jdbcTemplate.queryForObject(select, Long.class);
        System.out.println(aLong);
    }
}
