package com.study.redishello;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedishelloApplicationTests {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFactory() {
        RedisConnection connection = redisConnectionFactory.getConnection();
        try {
            connection.set("facatory".getBytes(), "hello factory".getBytes());
        } finally {
            connection.close();
        }
    }

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("test", "tt");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

    @Test
    public void testRedisSessionCallback() {
        redisTemplate.execute((RedisOperations ro) -> {
            ro.opsForValue().set("session1", "session1");
            ro.opsForValue().set("session2", "session2");
            return null;
        });
    }

    @Test
    public void testRedisCallback() {
        redisTemplate.execute((RedisConnection rc) -> {
            rc.set("redis1".getBytes(), "redis1".getBytes());
            rc.set("redis2".getBytes(), "redis2".getBytes());
            return null;
        });
    }

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("string-redis-template", "string-redis-template");
    }

    @Test
    public void testReds() {
        redisTemplate.opsForValue().set("ttss", "haha");
    }
}
