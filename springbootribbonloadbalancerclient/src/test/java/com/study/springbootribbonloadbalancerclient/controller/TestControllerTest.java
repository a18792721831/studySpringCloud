package com.study.springbootribbonloadbalancerclient.controller;

import com.study.springbootribbonloadbalancerclient.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-24
 */
public class TestControllerTest extends AbstractTest {

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(TestControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
    }

    @Test
    public void testTestMy() {
        logger.warning("testTestMy success : " + testRestTemplate.getForObject(
                url + "/test", String.class));
    }


}
