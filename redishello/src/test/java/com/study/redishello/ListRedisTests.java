package com.study.redishello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020/8/4
 */
@SpringBootTest
public class ListRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testListRedis() {
        redisTemplate.opsForList().leftPushAll("left", "l1", "l2", "l3", "l4", "l5");
        redisTemplate.opsForList().rightPushAll("right", "r1", "r2", "r3", "r4", "r5");
        System.out.println(redisTemplate.opsForList().leftPop("left"));
        System.out.println(redisTemplate.opsForList().rightPop("right"));
        System.out.println("index" + redisTemplate.opsForList().index("left", 3L));
        System.out.println("size of right" + redisTemplate.opsForList().size("right"));
        List list = redisTemplate.opsForList().range("left", 0, -1);
        System.out.println(list);
    }

}
