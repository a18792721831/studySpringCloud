package com.study.springboothystrixdashboardfeign.controller;

import com.study.springboothystrixdashboardfeign.service.FeignHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-26
 */
@RestController
public class FeignHelloController {

    @Autowired
    private FeignHelloService feignHelloService;

    @GetMapping("/feign/hello/{name}")
    public String helloFeign(@PathVariable("name") String name){
        return feignHelloService.hello(name);
    }

}
