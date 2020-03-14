package com.study.springbootzipkinclientelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootzipkinclientelasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootzipkinclientelasticsearchApplication.class, args);
    }

}
