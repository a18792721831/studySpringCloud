package com.study.servicecustomer.fallback.hystrix;

import brave.Tracer;
import com.study.servicecustomer.service.feign.PeopleFeignService;
import com.study.servicedomain.beans.dto.PeopleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-04-01
 */
@Component("peopleFeignHystrixFallback")
public class PeopleFeignHystrixFallback implements PeopleFeignService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private int port;

    @Autowired
    private Tracer tracer;

    @Override
    public String addPeople(String code, String name, int age, int sex, String hobby) {
        tracer.currentSpan().tag(" fallback message",
                " add people fallback , from " + applicationName + ":" + port + " !");
        return " add people fallback , from " + applicationName + ":" + port + " !";
    }

    @Override
    public String modifyPeople(String code, String name) {
        tracer.currentSpan().tag(" fallback message",
                " add people fallback , from " + applicationName + ":" + port + " !");
        return " add people fallback , from " + applicationName + ":" + port + " !";
    }

    @Override
    public List<PeopleDto> queryPeopleByCode(String code) {
        tracer.currentSpan().tag(" fallback message",
                " query people by code fallback , from " + applicationName + ":" + port + " !");
        return null;
    }

    @Override
    public List<PeopleDto> queryPeopleByName(String name) {
        tracer.currentSpan().tag(" fallback message",
                " query people by name fallback , from " + applicationName + ":" + port + " !");
        return null;
    }

    @Override
    public List<PeopleDto> getAllPeoples() {
        tracer.currentSpan().tag(" fallback message",
                " get all people fallback , from " + applicationName + ":" + port + " !");
        return null;
    }

    @Override
    public String deletePeopleByCode(String code) {
        tracer.currentSpan().tag(" fallback message",
                " delete people by code fallback , from " + applicationName + ":" + port + " !");
        return " delete people by code fallback , from " + applicationName + ":" + port + " !";
    }

    @Override
    public String deletePeopleByName(String name) {
        tracer.currentSpan().tag(" fallback message",
                " delete people by name fallback , from " + applicationName + ":" + port + " !");
        return " delete people by name fallback , from " + applicationName + ":" + port + " !";
    }
}
