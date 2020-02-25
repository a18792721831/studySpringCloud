package com.study.springbootribbonloadbalancerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootribbonloadbalancerclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootribbonloadbalancerclientApplication.class, args);
    }

}
