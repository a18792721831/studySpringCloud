package com.study.springboothystrixdashboardfeign.service;

import com.study.springboothystrixdashboardfeign.dao.feign.FeignHelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiayq
 * @Date 2020-02-26
 */
@Service
public class FeignHelloService {

    @Autowired
    private FeignHelloDao feignHelloDao;

    public String hello(String name){
        return feignHelloDao.hello(name);
    }

}
