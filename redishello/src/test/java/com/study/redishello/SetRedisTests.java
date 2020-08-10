package com.study.redishello;

/**
 * @author jiayq
 * @Date 2020/8/4
 */

import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@SpringBootTest
public class SetRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetRedis() {

        redisTemplate.opsForSet().add("set1", "s1", "s2", "s3", "s4", "s5");
        redisTemplate.opsForSet().add("set2", "s4", "s5", "s6", "s7", "s8", "s9");
        redisTemplate.opsForSet().add("set1", "tt");
        redisTemplate.opsForSet().remove("set1", "tt");
        System.out.println(redisTemplate.opsForSet().members("set1"));
        System.out.println(redisTemplate.opsForSet().members("set2"));
        System.out.println(redisTemplate.opsForSet().size("set1"));
        System.out.println(redisTemplate.opsForSet().size("set2"));
        // 交集
        System.out.println("交集");
        Set inte = redisTemplate.opsForSet().intersect("set1", "set2");
        System.out.println(inte);
        redisTemplate.opsForSet().intersectAndStore("set1", "set2", "setand");
        System.out.println(redisTemplate.opsForSet().members("setand"));
        // 差集
        // set1 - set2
        System.out.println("set1 - set2");
        Set diff = redisTemplate.opsForSet().difference("set1", "set2");
        System.out.println(diff);
        System.out.println("set2 - set1");
        System.out.println(redisTemplate.opsForSet().difference("set2", "set1"));
        redisTemplate.opsForSet().differenceAndStore("set1", "set2", "setxx1");
        System.out.println(redisTemplate.opsForSet().members("setxx1"));
        redisTemplate.opsForSet().differenceAndStore("set2", "set1", "setxx2");
        System.out.println(redisTemplate.opsForSet().members("setxx2"));
        // 并集
        System.out.println("并集");
        Set union = redisTemplate.opsForSet().union("set1",  "set2");
        redisTemplate.opsForSet().unionAndStore("set1", "set2", "setmm");
        System.out.println(redisTemplate.opsForSet().members("setmm"));
    }

}
