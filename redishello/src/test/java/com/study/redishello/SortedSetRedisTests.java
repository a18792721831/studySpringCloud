package com.study.redishello;

/**
 * @author jiayq
 * @Date 2020/8/4
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;

@SpringBootTest
public class SortedSetRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSortedSet() {
        int sum = 1000;
        var dataSet = new HashSet<ZSetOperations.TypedTuple<String>>(sum);
        for(int i = 0;i < sum; i++) {
            dataSet.add(new DefaultTypedTuple<>("value"+i, i/1000.0));
        }
        redisTemplate.opsForZSet().add("zsetx", dataSet);
        System.out.println("size = " + redisTemplate.opsForZSet().size("zsetx"));
        redisTemplate.opsForZSet().add("zsetx", "test", 1.0);
        System.out.println(redisTemplate.opsForZSet().range("zsetx", -1, -10));
        System.out.println(redisTemplate.opsForZSet().rangeByScore("zsetx", 0.966, 1.000));
        System.out.println(redisTemplate.opsForZSet().score("zsetx", "test"));
        redisTemplate.opsForZSet().remove("zsetx", "test");
        System.out.println(redisTemplate.opsForZSet().rangeWithScores("zsetx", 0, 10));
        System.out.println(redisTemplate.opsForZSet().reverseRange("zsetx", 0, 10));
        System.out.println(redisTemplate.opsForZSet().reverseRangeWithScores("zsetx", 0, 10));

    }

}
