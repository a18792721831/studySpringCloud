package com.study.springbootribbonloadbalancerclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-24
 */
@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${myeureka.client.host}")
    private String eurekaClient;

    @GetMapping("/test")
    public String testMy() {
        ServiceInstance instance = loadBalancerClient.choose("stores");
        return instance.getHost() + ":" + instance.getPort();
    }

}
