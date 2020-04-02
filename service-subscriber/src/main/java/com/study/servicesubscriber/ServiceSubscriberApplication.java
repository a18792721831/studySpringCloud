package com.study.servicesubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@EnableHystrixDashboard
@EntityScan("com.study.servicedomain.beans")
public class ServiceSubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSubscriberApplication.class, args);
    }

}
