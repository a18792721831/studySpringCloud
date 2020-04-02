package com.study.springbootswagger.dao;

import com.study.springbootswagger.beans.Student;
import com.study.springbootswagger.neum.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@SpringBootTest
public class StudentDaoTest {

    private static final Logger logger = Logger.getLogger(StudentDaoTest.class.getName());

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testAddStudent() {
        Student student = new Student("小花", "足球", Grade.ONE);
        studentDao.save(student);
        logger.warning("test add dao success " + student.toString());
    }

    @Test
    public void testFindByStudentId() {
        Optional<Student> student = studentDao.findById(8L);
        if (student.isPresent()) {
            logger.warning("test find by student id success " + student.toString());
        } else {
            throw new AssertionError("null data");
        }
    }

}
