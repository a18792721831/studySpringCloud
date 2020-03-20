package com.study.springbootsecurity.controller;

import com.study.springbootsecurity.beans.Student;
import com.study.springbootsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-20
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> list(){
        return studentService.getStudentList();
    }

    @RequestMapping("/delete/{name}")
    public void deleteStudent(@PathVariable("name") String name){
        List<Student> studentList = studentService.getStudentList();
        studentList.stream().filter(s -> name.equals(s.getName())).forEach(stu -> studentService.deleteStudent(stu));
    }

}
