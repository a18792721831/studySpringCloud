package com.study.springbootswagger.dao;

import com.study.springbootswagger.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
}
