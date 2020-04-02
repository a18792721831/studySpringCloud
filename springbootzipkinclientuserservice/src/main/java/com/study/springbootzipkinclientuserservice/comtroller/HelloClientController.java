package com.study.springbootzipkinclientuserservice.comtroller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private int port;

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name) {
        return "hi " + name + " , i am the HelloClientController hi, from port=" + port;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello " + name + " , i am the HelloClientController hello, from port=" + port;
    }

}
