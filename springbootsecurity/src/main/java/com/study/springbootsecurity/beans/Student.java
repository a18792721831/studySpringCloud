package com.study.springbootsecurity.beans;

/**
 * @author jiayq
 * @Date 2020-03-19
 */
public class Student {

    private String name;

    private int age;

    private String like;

    private Student(){

    }

    public static Student getBuild(){
        return new Student();
    }

    public Student name(String name){
        this.name = name;
        return Student.this;
    }

    public Student age(int age){
        this.age = age;
        return Student.this;
    }

    public Student like(String like){
        this.like = like;
        return Student.this;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getLike(){
        return this.like;
    }

}
