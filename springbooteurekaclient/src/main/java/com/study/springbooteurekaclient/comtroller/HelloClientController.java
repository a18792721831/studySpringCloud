package com.study.springbooteurekaclient.comtroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-22
 */
@RestController
@RequestMapping("/hello")
public class HelloClientController {

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name){
        return "hi " + name + " , i am the HelloClientController hi";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "hello " + name + " , i am the HelloClientController hello";
    }

}
