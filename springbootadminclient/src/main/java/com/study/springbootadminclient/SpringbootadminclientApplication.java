package com.study.springbootadminclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootadminclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadminclientApplication.class, args);
    }

}
