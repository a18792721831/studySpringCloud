package com.study.springbootzipkinclientuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootzipkinclientuserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootzipkinclientuserserviceApplication.class, args);
    }

}
