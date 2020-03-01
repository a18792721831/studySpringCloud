package com.study.springbootfeignhystrix.hystrix.feign;

import com.study.springbootfeignhystrix.dao.feign.FeignHelloDao;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-03-01
 */
@Component
public class HystrixFeignHelloDaoError implements FeignHelloDao {
    @Override
    public String hello(String name) {
        return "this is feign error method return infomation, method is hello ,name is " + name;
    }
}
