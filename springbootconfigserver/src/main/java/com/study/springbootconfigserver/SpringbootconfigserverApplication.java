package com.study.springbootconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringbootconfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootconfigserverApplication.class, args);
    }

}
