package com.study.springbootswagger.beans;

import com.study.springbootswagger.convert.StudentConvert;
import com.study.springbootswagger.neum.Grade;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@Entity
@ApiModel(description = "学生实体")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(required = false, value = "学生id", notes = "由oracle序列生成", dataType = "Long")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(dataType = "String", value = "学生姓名", notes = "不能为空", required = true)
    private String name;

    @Column
    @ApiModelProperty(value = "学生爱好",dataType = "String",required = false,notes = "学生爱好255")
    private String hobby;

    @Convert(converter = StudentConvert.class)
    @Column(nullable = false, name = "GRADE")
    @ApiModelProperty(value = "学生年级",dataType = "Grade",required = true,notes = "学生年纪从-1到6",allowableValues = "0,1,2,3,4,5,6,-1")
    private Grade grade;

    public Student() {

    }

    public Student(String name, String hobby, Grade grade) {
        this.name = name;
        this.hobby = hobby;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student(id=" + this.id + ", name=" + this.name + ", hobby=" + this.hobby + ", grade=" + this.grade + ")";
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getHobby() {
        return this.hobby;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
