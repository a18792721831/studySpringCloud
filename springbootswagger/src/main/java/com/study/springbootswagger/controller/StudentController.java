package com.study.springbootswagger.controller;

import com.study.springbootswagger.beans.Student;
import com.study.springbootswagger.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@RestController
@RequestMapping("/stu")
@Api
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    @ApiOperation(value = "增加学生", notes = "post 提交增加记录")
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = "success add")})
    public String putStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "success add " + student.toString();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询学生", notes = "根据id查询学生")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回学生对象"),
            @ApiResponse(code = 404, message = "error")})
    public Optional<Student> findStudent(@PathVariable("id") @ApiParam(value = "学生id") Long id) {
        return studentService.findStudentById(id);
    }

}
