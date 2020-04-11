package com.study.servicecustomer.dao.redis.impl;

import com.study.servicecustomer.dao.redis.IRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author jiayq
 * @Date 2020-04-02
 */
@Repository("redisDao")
public class RedisDaoImpl implements IRedisDao {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void setKey(String key, String value) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key, value, 1, TimeUnit.MINUTES);
    }

    @Override
    public String getValue(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }
}
