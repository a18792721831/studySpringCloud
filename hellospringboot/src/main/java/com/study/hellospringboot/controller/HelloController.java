package com.study.hellospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/hellocontroller")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello, this is HelloController";
    }

}
