package com.study.springbootribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootribbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootribbonApplication.class, args);
    }

}
