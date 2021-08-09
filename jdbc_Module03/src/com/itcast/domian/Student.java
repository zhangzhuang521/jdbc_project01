package com.itcast.domian;

import java.util.Date;

//学生实体类
public class Student {

    private Integer sid;
    private String name;
    private Integer age;
    private Double score;
    private Date brithday;

    public Student() {
    }

    public Student(Integer sid, String name, Integer age, Double score, Date brithday) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.score = score;
        this.brithday = brithday;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", brithday=" + brithday +
                '}';
    }
}
