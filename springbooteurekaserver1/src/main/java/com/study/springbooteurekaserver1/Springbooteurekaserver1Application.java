package com.study.springbooteurekaserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Springbooteurekaserver1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbooteurekaserver1Application.class, args);
    }

}
