package com.study.springbooteurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbooteurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbooteurekaclientApplication.class, args);
    }

}
