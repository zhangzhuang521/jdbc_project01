package com.itcast.controller;




import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        Date date = new Date(new Date().getTime());
        System.out.println(date);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.update()

    }

}
