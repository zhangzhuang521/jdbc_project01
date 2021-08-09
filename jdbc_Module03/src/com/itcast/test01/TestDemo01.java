package com.itcast.test01;

import com.itcast.utils.DataSourcesUtils;
import org.springframework.jdbc.core.JdbcTemplate;



public class TestDemo01 {
    public static void main(String[] args) {
        //添加数据
        //删除
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourcesUtils.getDataSource());
        String sql="delete FROM student where sid=?";
        int result = jdbcTemplate.update(sql, 13);
        System.out.println(result);

    }
}
