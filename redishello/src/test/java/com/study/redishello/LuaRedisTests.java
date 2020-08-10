package com.study.redishello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * @author jiayq
 * @Date 2020/8/6
 */
@SpringBootTest
public class LuaRedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testLuaRedis() {
        DefaultRedisScript redisScript = new DefaultRedisScript("return 'hello_lua'");
        redisScript.setResultType(String.class);
        System.out.println(redisTemplate.execute(redisScript, redisTemplate.getStringSerializer(), redisTemplate.getStringSerializer(), null));
    }

}
