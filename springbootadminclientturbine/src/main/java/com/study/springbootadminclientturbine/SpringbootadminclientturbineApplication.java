package com.study.springbootadminclientturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
@EnableEurekaClient
public class SpringbootadminclientturbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadminclientturbineApplication.class, args);
    }

}
