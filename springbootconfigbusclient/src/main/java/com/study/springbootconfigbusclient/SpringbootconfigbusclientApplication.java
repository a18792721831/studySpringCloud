package com.study.springbootconfigbusclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootconfigbusclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootconfigbusclientApplication.class, args);
    }

}
