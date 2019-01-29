package com.orgjson.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class WangXiaoEr {

    @SerializedName("NAME")//通过该注解，在GSON解析成json格式的时候会将该key变成（）里指定的值
    private String name;
    private String school;
    private boolean has_g;
    private double age;
    private Object car;
    private Object house;
    private String[] major;
    private String comment;
    private String birthday;
    //加上transient修饰后，在用GSON解析成json格式的时候，将不会显示该属性
    private transient String igrone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isHas_g() {
        return has_g;
    }

    public void setHas_g(boolean has_g) {
        this.has_g = has_g;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Object getCar() {
        return car;
    }

    public void setCar(Object car) {
        this.car = car;
    }

    public Object getHouse() {
        return house;
    }

    public void setHouse(Object house) {
        this.house = house;
    }

    public String[] getMajor() {
        return major;
    }

    public void setMajor(String[] major) {
        this.major = major;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIgrone() {
        return igrone;
    }

    public void setIgrone(String igrone) {
        this.igrone = igrone;
    }

    @Override
    public String toString() {
        return "WangXiaoEr{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", has_g=" + has_g +
                ", age=" + age +
                ", car=" + car +
                ", house=" + house +
                ", major=" + Arrays.toString(major) +
                ", comment='" + comment + '\'' +
                ", birthday='" + birthday + '\'' +
                ", igrone='" + igrone + '\'' +
                '}';
    }
}
