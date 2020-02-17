package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/student-configure")
public class YmlStudentConfigureController {

    @Autowired
    private Student student;

    @RequestMapping("read")
    public Student readStudent(){
        return student;
    }

}
