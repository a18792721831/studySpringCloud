package com.study.redishello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author jiayq
 * @Date 2020/8/5
 */
@SpringBootTest
public class PubSubRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPubSubRedis() {
        redisTemplate.convertAndSend("topic11", "spring_boot");
    }

}
