package com.study.springbootsecurity.service;

import com.study.springbootsecurity.beans.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-20
 */
@Service
public class StudentService {

    private List<Student> studentList = new ArrayList<>();

    {
        studentList.add(Student.getBuild().name("小花").age(22).like("pingpang"));
        studentList.add(Student.getBuild().name("小美").age(23).like("run"));
        studentList.add(Student.getBuild().name("lili").age(12).like("music"));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<Student> getStudentList(){
        return studentList;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteStudent(Student student){
        Iterator<Student> iterator = studentList.iterator();
        while(iterator.hasNext()){
            Student stu = iterator.next();
            if (stu.getName().equals(student.getName())){
                iterator.remove();
            }
        }
    }
}
