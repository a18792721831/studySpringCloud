package com.study.redishello;

import io.lettuce.core.AbstractRedisAsyncCommands;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * @author jiayq
 * @Date 2020/8/4
 */
@SpringBootTest
public class StringRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("int_key", "1");
        System.out.println(redisTemplate.opsForValue().get("int_key"));
        redisTemplate.opsForValue().increment("int_key", 1);
        System.out.println(redisTemplate.opsForValue().get("int_key"));
        redisTemplate.opsForValue().increment("int_key", -1);
        System.out.println(redisTemplate.opsForValue().get("int_key"));
    }

}
