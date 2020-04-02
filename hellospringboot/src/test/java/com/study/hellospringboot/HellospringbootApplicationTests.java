package com.study.hellospringboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class HellospringbootApplicationTests {

    private static Logger logger;

    @BeforeAll
    public static void init() {
        logger = Logger.getLogger(HellospringbootApplicationTests.class.getName());
    }

    @Test
    void contextLoads() {

        logger.warning("contextLoads test success");

    }


}
