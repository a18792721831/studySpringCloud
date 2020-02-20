package com.study.springbootswagger.service;

import com.study.springbootswagger.beans.Student;
import com.study.springbootswagger.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student addStudent(Student student){
        studentDao.save(student);
        return student;
    }

    public Optional<Student> findStudentById(Long id){
        return studentDao.findById(id);
    }
}
