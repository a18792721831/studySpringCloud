package com.study.redishello;

import com.study.redishello.sub.Sub1;
import io.lettuce.core.RedisFuture;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import javax.annotation.PostConstruct;
import java.time.Duration;

@SpringBootApplication(scanBasePackages = "com.study.redishello")
@MapperScan(basePackages = "com.study.redishello.dao", annotationClass = Repository.class)
@EnableCaching
public class RedishelloApplication {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Sub1 sub1;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    public static void main(String[] args) {
        SpringApplication.run(RedishelloApplication.class, args);
    }

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    public void initRedisTemplate() {
        // RedisTemplate会自动初始化StringRedisSerilaizer，直接可用
        RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
    }

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler() {
        if (taskScheduler ==null ) {
            taskScheduler = new ThreadPoolTaskScheduler();
            taskScheduler.setPoolSize(5);
        }
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        container.setTaskExecutor(taskScheduler);
        Topic topic = new ChannelTopic("topic11");
        container.addMessageListener(sub1, topic);
        return container;
    }

    @Bean
    public RedisCacheManager initRedisCacheManager(){
        // Redis加锁写入器
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        // 启动Redis缓存的默认设置
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
        // 设置jdk序列化器
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()))
        // 禁用前缀
        .disableKeyPrefix()
        // 设置超时时间 1分钟
        .entryTtl(Duration.ofMinutes(1));
        // 创建Redis缓存管理器
        RedisCacheManager redisCacheManager = new RedisCacheManager(writer, cacheConfiguration);
        return redisCacheManager;
    }
}
