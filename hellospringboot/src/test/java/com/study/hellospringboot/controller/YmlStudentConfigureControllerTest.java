package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class YmlStudentConfigureControllerTest {

    private static Logger logger;

    private static String baseUrl;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private Student student;

    @BeforeAll
    public static void init() {
        baseUrl = "http://127.0.0.1";
        logger = Logger.getLogger(YmlStudentConfigureControllerTest.class.getName());
    }

    @Test
    public void testReadStudent() {
        ResponseEntity<Student> responseEntity = testRestTemplate.getForEntity(
                baseUrl + ":" + port + "/student-configure/read", Student.class);
        assertThat(responseEntity.getBody().toString(), equalTo(student.toString()));
        logger.warning("hello test success");
    }


}
