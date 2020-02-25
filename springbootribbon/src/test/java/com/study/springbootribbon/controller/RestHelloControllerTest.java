package com.study.springbootribbon.controller;

import com.study.springbootribbon.AbstractTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-24
 */
public class RestHelloControllerTest extends AbstractTest {

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(RestHelloControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/restHello";
    }

    @Test
    public void testHello() {
        logger.warning(url + "/xiaohua testHello success : " + testRestTemplate.getForObject(url + "/xiaohua", String.class));
    }

    @Test
    public void testRestHi() {
        logger.warning(url + "/hi/小花 testRestHi success : " + testRestTemplate.getForObject(
                url + "/hi/小花", String.class));
    }

    @Test
    public void testRestHello() {
        logger.warning(url + "/hello/小李 testRestHello success : " + testRestTemplate.getForObject(
                url + "/hello/小李", String.class));
    }
}
