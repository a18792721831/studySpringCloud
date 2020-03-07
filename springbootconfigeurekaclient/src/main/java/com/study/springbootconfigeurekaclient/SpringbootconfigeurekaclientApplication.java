package com.study.springbootconfigeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootconfigeurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootconfigeurekaclientApplication.class, args);
    }

}
