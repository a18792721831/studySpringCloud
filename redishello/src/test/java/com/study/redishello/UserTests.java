package com.study.redishello;

/**
 * @author jiayq
 * @Date 2020/8/7
 */

import com.study.redishello.pojo.User;
import com.study.redishello.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserTests {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUserName(UUID.randomUUID().toString());
        user.setNote(UUID.randomUUID().toString());
        userService.insertUser(user);
    }

    @Test
    public void testGetUser(){
        userService.getUser(2L).toString();
    }

    @Test
    public void testUpdateUser() {
        userService.updateUserName(2L, "xxxxxxxxx");
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser(2L);
    }
}
