package com.study.redishello.myjedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author jiayq
 * @Date 2020/8/1
 */
@Configuration
public class RedisConfig {

//    @Value("${spring.redis.host}")
//    private String hostname;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.database}")
//    private int database;
//
//    private RedisConnectionFactory factory = null;
//
//    @Bean("redisConnectionFactory")
//    public RedisConnectionFactory initConnectionFactory() {
//        if (factory != null) {
//            return factory;
//        }
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        // 最大空闲数
//        poolConfig.setMaxIdle(10);
//        // 最大连接数
//        poolConfig.setMaxTotal(25);
//        // 最大等待毫秒数
//        poolConfig.setMaxWaitMillis(timeout);
//        // 创建连接工厂
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
//        // 获取单机的Redis配置
//        RedisStandaloneConfiguration rsConfig = jedisConnectionFactory.getStandaloneConfiguration();
//        rsConfig.setHostName(hostname);
//        rsConfig.setPort(port);
//        rsConfig.setPassword(password);
//        rsConfig.setDatabase(database);
//        factory = jedisConnectionFactory;
//        return factory;
//    }

//    @Bean("redisTemplate")
//    public RedisTemplate initRedisTemplate() {
//        RedisTemplate template = new RedisTemplate();
//        // RedisTemplate会自动初始化StringRedisSerilaizer，直接可用
//        RedisSerializer redisSerializer = template.getStringSerializer();
//        template.setKeySerializer(redisSerializer);
//        template.setValueSerializer(redisSerializer);
//        template.setHashKeySerializer(redisSerializer);
//        template.setHashValueSerializer(redisSerializer);
//        template.setConnectionFactory(initConnectionFactory());
//        return template;
//    }

}
