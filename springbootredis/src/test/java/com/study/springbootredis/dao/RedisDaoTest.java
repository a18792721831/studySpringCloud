package com.study.springbootredis.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@SpringBootTest
public class RedisDaoTest {

    private static final Logger logger = Logger.getLogger(RedisDaoTest.class.getName());

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testAdd(){
        redisDao.setKey("hi", "hello");
        logger.warning(" test add success");
    }

    @Test
    public void testGet(){
        String value = redisDao.getValue("hi");
        assertThat(value, equalTo("hello"));
        logger.warning(" test add success value = " + value);
    }

}
