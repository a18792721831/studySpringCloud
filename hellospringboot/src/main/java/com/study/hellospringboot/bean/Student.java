package com.study.hellospringboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@ConfigurationProperties(prefix = "student")
@Component
public class Student {

    private String name;

    private int age;

    private String like;

    private String sex;

    public Student() {
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getLike() {
        return this.like;
    }

    public String getSex() {
        return this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAge() != other.getAge()) return false;
        final Object this$like = this.getLike();
        final Object other$like = other.getLike();
        if (this$like == null ? other$like != null : !this$like.equals(other$like)) return false;
        final Object this$sex = this.getSex();
        final Object other$sex = other.getSex();
        if (this$sex == null ? other$sex != null : !this$sex.equals(other$sex)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getAge();
        final Object $like = this.getLike();
        result = result * PRIME + ($like == null ? 43 : $like.hashCode());
        final Object $sex = this.getSex();
        result = result * PRIME + ($sex == null ? 43 : $sex.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Student(name=" + this.getName() + ", age=" + this.getAge() + ", like=" + this.getLike() + ", sex=" + this.getSex() + ")";
    }
}
