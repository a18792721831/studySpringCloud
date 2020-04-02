package com.study.springbootswagger.service;

import com.study.springbootswagger.beans.Student;
import com.study.springbootswagger.neum.Grade;
import org.hibernate.annotations.common.AssertionFailure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-20
 */
@SpringBootTest
public class StudentServiceTest {

    private static final Logger logger = Logger.getLogger(StudentServiceTest.class.getName());

    @Autowired
    private StudentService studentService;

    @Test
    public void testAddStudent() {
        Student student = new Student("xiaohua", "pingpang", Grade.FIVE);
        studentService.addStudent(student);
        logger.warning("test add student success id = " + student.getId());
    }

    @Test
    public void testFindStudentById() {
        Optional<Student> student = studentService.findStudentById(4L);
        if (student.isPresent()) {
            logger.warning("test find student by id success " + student.get().toString());
        } else {
            throw new AssertionFailure("not find ");
        }
    }

}
