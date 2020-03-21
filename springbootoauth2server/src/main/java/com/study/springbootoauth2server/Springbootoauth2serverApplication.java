package com.study.springbootoauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@SpringBootApplication
@EnableEurekaClient
@EnableGlobalAuthentication
public class Springbootoauth2serverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springbootoauth2serverApplication.class, args);
    }

}