package com.study.hellospringboot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractTest {

    @Value("${test.host}")
    private String baseUrl;

    @LocalServerPort
    private int port;

    protected String url;

    protected static Logger logger;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @BeforeAll
    protected static void init(){

    }

    @BeforeEach
    public void beforeTest(){
        url = baseUrl + ":" + port;
    }
}
