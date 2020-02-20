package com.study.springbootjpa.controller;

import com.study.springbootjpa.beans.Users;
import com.study.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/{username}")
    public List<Users> getUsersByUserName(@PathVariable("username") String userName) {
        return userService.findByName(userName);
    }

    @PostMapping("/")
    public Users addUser(@RequestBody Users users) {
        return userService.addUser(users);
    }
}
