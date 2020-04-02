package com.study.servicecustomer.service.feign;

import com.study.servicecustomer.config.feign.FeignConfig;
import com.study.servicecustomer.fallback.hystrix.PeopleFeignHystrixFallback;
import com.study.servicedomain.beans.dto.PeopleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-04-01
 */
@Service
@FeignClient(value = "service-subscriber", configuration = FeignConfig.class, fallback = PeopleFeignHystrixFallback.class)
public interface PeopleFeignService {

    @PostMapping("/people/{code}/{name}/{age}/{sex}/{hobby}")
    String addPeople(@PathVariable("code") String code, @PathVariable("name") String name, @PathVariable("age") int age,
                     @PathVariable("sex") int sex, @PathVariable("hobby") String hobby);

    @PutMapping("/people/{code}/{name}")
    String modifyPeople(@PathVariable("code") String code, @PathVariable("name") String name);

    @GetMapping("/people/code/{codee}")
    List<PeopleDto> queryPeopleByCode(@PathVariable("code") String code);

    @GetMapping("/people/name/{name}")
    List<PeopleDto> queryPeopleByName(@PathVariable("name") String name);

    @GetMapping("/people/people")
    List<PeopleDto> getAllPeoples();

    @DeleteMapping("/people/code/{code}")
    String deletePeopleByCode(@PathVariable("code") String code);

    @DeleteMapping("/people/name/{name}")
    String deletePeopleByName(@PathVariable("name") String name);
}
