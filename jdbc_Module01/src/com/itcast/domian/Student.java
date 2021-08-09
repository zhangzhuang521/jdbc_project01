package com.itcast.domian;

import java.sql.Date;

//Student 实体类
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Double score;
    private Date Brithday;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Double score, Date brithday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        Brithday = brithday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getBrithday() {
        return Brithday;
    }

    public void setBrithday(Date brithday) {
        Brithday = brithday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", Brithday=" + Brithday +
                '}';
    }
}
