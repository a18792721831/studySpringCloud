package com.study.redishello;

/**
 * @author jiayq
 * @Date 2020/8/4
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jiayq
 * @Date 2020/8/4
 */
@SpringBootTest
public class HashRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testHashRedis(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("keys1", "keys1");
        map.put("keys2", "keys2");
        redisTemplate.opsForHash().putAll("hashredis", map);
        System.out.println(redisTemplate.opsForHash().get("hashredis", "keys1"));
        System.out.println(redisTemplate.opsForHash().get("hashredis", "keys2"));

    }

}
