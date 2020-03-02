package com.study.springboothystrixdashboardresttemplate.config.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiayq
 * @Date 2020-03-01
 */
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
