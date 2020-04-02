package com.study.servicesubscriber.service.feign;

import com.study.servicedomain.beans.dto.CustomerDto;
import com.study.servicesubscriber.config.feign.FeignConfig;
import com.study.servicesubscriber.fallback.hystrix.CustomerFeignHystrixFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-31
 */
@Service
@FeignClient(value = "service-customer", configuration = FeignConfig.class, fallback = CustomerFeignHystrixFallback.class)
public interface CustomerFeignService {

    @GetMapping("/customer/")
    List<CustomerDto> getAllCustomer();

    @PostMapping("/customer/{code}/{name}/{address}")
    String addCustomer(@PathVariable("code") String code, @PathVariable("name") String name,
                     @PathVariable("address") String address);

    @GetMapping("/customer/code/{code}")
    List<CustomerDto> queryCustomerByCode(@PathVariable("code") String code);

    @GetMapping("/customer/name/{name}")
    List<CustomerDto> queryCustomerByName(@PathVariable("name") String name);

    @DeleteMapping("/customer/name/{name}")
    String deleteCustomerByName(@PathVariable("name") String name);

    @DeleteMapping("/customer/code/{code}")
    String deleteCustomerByCode(@PathVariable("code") String code);

    @PutMapping("/customer/{code}/{name}")
    String modidfyCustomer(@PathVariable("code") String code,@PathVariable("name") String name);
}
