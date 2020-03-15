package com.study.springbootadminclientservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-03-15
 */
@RestController
@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name){
        return "hi " + name + " , i am from spring boot admin client service, port is " + port;
    }
}
