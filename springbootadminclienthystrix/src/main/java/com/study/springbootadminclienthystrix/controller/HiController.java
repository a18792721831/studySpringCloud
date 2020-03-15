package com.study.springbootadminclienthystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiayq
 * @Date 2020-03-15
 */
@RestController
@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.boot.admin.client.service}")
    private String AdminClientServerId;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayError")
    @GetMapping("/say/{name}")
    public String say(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://" + AdminClientServerId +
                "/hi/hi/" + name, String.class) + " , from spring boot admin client hystrix !";
    }

    public String sayError(String name) {
        return "hi " + name + ", i am error for say , from port " + port;
    }

}
