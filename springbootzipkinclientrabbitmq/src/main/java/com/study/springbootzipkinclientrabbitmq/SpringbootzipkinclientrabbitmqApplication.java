package com.study.springbootzipkinclientrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootzipkinclientrabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootzipkinclientrabbitmqApplication.class, args);
    }

}
