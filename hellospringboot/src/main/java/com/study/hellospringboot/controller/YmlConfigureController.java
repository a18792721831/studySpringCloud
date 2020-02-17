package com.study.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/configure")
public class YmlConfigureController {

    @Value("${my.test}")
    private String test;

    @Value("${my.value}")
    private String value;

    @RequestMapping("/my.test")
    public String MyTest() {
        return test;
    }

    @RequestMapping("/my.value")
    public String MyValue() {
        return value;
    }

}
