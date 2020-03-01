package com.study.springboothystrixresttemplate.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiayq
 * @Date 2020-02-24
 */
@Service
public class RestRibbonService {

    @Value("${myeureka.client.host}")
    private String eurekaClient;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "restHiError")
    public String restHi(String name){
        return restTemplate.getForObject("http://" + eurekaClient + "/hello/hi/" + name, String.class);
    }

    public String restHiError(String name){
        return "this is restHiError, you have error response," + name;
    }

    @HystrixCommand(fallbackMethod = "restHelloError")
    public String restHello(String name){
        return restTemplate.getForObject("http://" + eurekaClient + "/hello/hello/" + name, String.class);
    }

    public String restHelloError(String name){
        return "this is restHelloError, you have error response," + name;
    }
}
