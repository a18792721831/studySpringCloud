package com.study.springbootjpa.service;

import com.study.springbootjpa.beans.Users;
import com.study.springbootjpa.neum.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
@SpringBootTest
public class UsersServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        Users users = new Users();
        users.setUsername(String.valueOf(new Random().nextLong()));
        users.setPassword(String.valueOf(new Random().nextLong()));
        users.setStatus(Status.VALID);
        userService.addUser(users);
    }

    @Test
    public void testBatchAddUser() {
        Users users = new Users();
        users.setUsername(String.valueOf(new Random().nextLong()));
        users.setPassword(String.valueOf(new Random().nextLong()));
        users.setStatus(Status.VALID);
        userService.batchAddUser(Arrays.asList(users));
    }

}
