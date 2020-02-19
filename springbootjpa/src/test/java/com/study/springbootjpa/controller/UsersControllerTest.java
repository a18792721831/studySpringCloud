package com.study.springbootjpa.controller;

import com.study.springbootjpa.AbstractTest;
import com.study.springbootjpa.beans.Users;
import com.study.springbootjpa.neum.Status;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
public class UsersControllerTest extends AbstractTest{

    @BeforeAll
    public static void init(){
        AbstractTest.init();
        logger = Logger.getLogger(UsersControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest(){
        super.beforeTest();
        url += "/user";
    }

    @Test
    public void testGetUsersByUserName(){
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity(
                url + "/4533422708069791629", List.class);
        logger.warning(url + "/4533422708069791629 testgetUsersByUserName " + responseEntity);
    }

    @Test
    public void testAddUser() {
        Users users = new Users();
        users.setUsername("xiaohua");
        users.setStatus(Status.VALID);
        users.setPassword("123456");
        testRestTemplate.put(url + "/", users);
        logger.warning(url+"/ testAddUser " + users);
    }
}
