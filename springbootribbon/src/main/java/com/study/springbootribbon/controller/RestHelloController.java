package com.study.springbootribbon.controller;

import com.study.springbootribbon.service.RestRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiayq
 * @Date 2020-02-24
 */
@RestController
@RequestMapping("/restHello")
public class RestHelloController {

    @Autowired
    private RestRibbonService restRibbonService;

    @GetMapping("/{value}")
    public String hello(@PathVariable("value") String value) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com", String.class);
    }

    @GetMapping("/hi/{name}")
    public String restHi(@PathVariable("name") String name) {
        return restRibbonService.restHi(name);
    }

    @GetMapping("/hello/{name}")
    public String restHello(@PathVariable("name") String name) {
        return restRibbonService.restHello(name);
    }

}
