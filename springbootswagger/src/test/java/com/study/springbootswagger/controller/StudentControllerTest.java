package com.study.springbootswagger.controller;

import com.study.springbootswagger.AbstractTest;
import com.study.springbootswagger.beans.Student;
import com.study.springbootswagger.neum.Grade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-20
 */
public class StudentControllerTest extends AbstractTest {

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(StudentControllerTest.class.getName());
    }

    @BeforeEach
    @Override
    public void beforeTest() {
        super.beforeTest();
        url += "/stu";
    }

    @Test
    public void testPutStudent() {
        Student student = new Student("小李", "麻将", Grade.NO);
        logger.warning("test put student success" +
                testRestTemplate.postForObject(url + "/", student, String.class));
    }

    @Test
    public void testFindStudentById() {
        ResponseEntity<Student> responseEntity = testRestTemplate.getForEntity(
                url + "/9", Student.class);
        logger.warning("test find student by id success student:" + responseEntity.toString());
    }

}
