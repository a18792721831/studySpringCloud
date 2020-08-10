package com.study.redishello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020/8/5
 */
@SpringBootTest
public class MultiRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testMulti() {
        redisTemplate.opsForValue().set("mu", "3");
        List list = (List) redisTemplate.execute((RedisOperations ro) -> {
           ro.watch("mu");
           ro.multi();
           ro.opsForValue().set("mu1", "mu1");
            System.out.println("mu = " + ro.opsForValue().get("mu"));
            System.out.println("mu1 = " + ro.opsForValue().get("mu1"));
            ro.opsForValue().increment("mu");
            System.out.println("mu ++ = " + ro.opsForValue().get("mu"));
//            ro.opsForValue().increment("mu1");
            return ro.exec();
        });
        System.out.println(list);
    }

}
