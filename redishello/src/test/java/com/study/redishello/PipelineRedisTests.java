package com.study.redishello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author jiayq
 * @Date 2020/8/5
 */
@SpringBootTest
public class PipelineRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPipeline() {
        long start = System.currentTimeMillis();
//        redisTemplate.executePipelined((RedisOperations ro) -> {
//            for (int i = 0; i < 100000; i++) {
//                ro.opsForValue().set("key_" + i, i + "");
//                if (i % 10000 == 0) {
//                    System.out.println("第 " + i + " 个");
//                }
//            }
//            return null;
//        });
        for (int i = 0; i < 100000; i++) {
            redisTemplate.opsForValue().set("key_" + i, i + "");
            if (i % 10000 == 0) {
                System.out.println("第 " + i + " 个");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
