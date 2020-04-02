package com.study.springboothystrixdashboardfeign.dao.feign;

import com.study.springboothystrixdashboardfeign.config.feign.FeignConfig;
import com.study.springboothystrixdashboardfeign.hystrix.feign.HystrixFeignHelloDaoError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jiayq
 * @Date 2020-02-26
 */
@Repository
@FeignClient(value = "EUREKA-CLIENT", configuration = FeignConfig.class, fallback = HystrixFeignHelloDaoError.class)
public interface FeignHelloDao {

    @GetMapping("/hello/hello/{name}")
    String hello(@PathVariable("name") String name);

}
