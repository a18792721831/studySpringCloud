package com.study.springbootadminclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootadminclientserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadminclientserviceApplication.class, args);
    }

}
