package com.study.servicesubscriber.fallback.hystrix;

import brave.Tracer;
import com.study.servicedomain.beans.dto.CustomerDto;
import com.study.servicesubscriber.service.feign.CustomerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-31
 */
@Component("customerFeignHystrixFallback")
public class CustomerFeignHystrixFallback implements CustomerFeignService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private int port;

    @Autowired
    private Tracer tracer;

    @Override
    public List<CustomerDto> getAllCustomer() {
        tracer.currentSpan().tag(" fallback message",
                " get all customer fallback , from " + applicationName + ":" + port + " !");
        return null;
    }

    @Override
    public String addCustomer(String code, String name, String address) {
        tracer.currentSpan().tag(" fallback message",
                " add customer fallback , from " + applicationName + ":" + port + " !");
        return " add customer fallback , from " + applicationName + ":" + port + " !";
    }

    @Override
    public List<CustomerDto> queryCustomerByCode(String code) {
        tracer.currentSpan().tag(" fallback message",
                "query customer by code fallback , from " + applicationName + ":" + port + " !");
        return null;
    }

    @Override
    public List<CustomerDto> queryCustomerByName(String name) {
        tracer.currentSpan().tag(" fallback message",
                "query customer by name fallback , from " + applicationName + ":" + port + " !");
        return null;
    }

    @Override
    public String deleteCustomerByName(String name) {
        tracer.currentSpan().tag(" fallback message",
                "delete customer by name fallback , from " + applicationName + ":" + port + " !");
        return "delete customer by name fallback , from " + applicationName + ":" + port + " !";
    }

    @Override
    public String deleteCustomerByCode(String code) {
        tracer.currentSpan().tag(" fallback",
                "delete customer by code fallback , from " + applicationName + ":" + port + " !");
        return "delete customer by code fallback , from " + applicationName + ":" + port + " !";
    }

    @Override
    public String modidfyCustomer(String code, String name) {
        tracer.currentSpan().tag(" fallback message",
                 "modify customer fallback , from " + applicationName + ":" + port + " !");
        return "modify customer fallback , from " + applicationName + ":" + port + " !";
    }
}
