package com.study.springbootfeign.dao.feign;

import com.study.springbootfeign.config.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jiayq
 * @Date 2020-02-26
 */
@FeignClient(value = "EUREKA-CLIENT", configuration = FeignConfig.class)
public interface FeignHelloDao {

    @GetMapping("/hello/hello/{name}")
    String hello(@PathVariable("name") String name);

}
