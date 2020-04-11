package com.study.servicecustomer.dao.redis;

/**
 * @author jiayq
 * @Date 2020-04-02
 */
public interface IRedisDao {

    void setKey(String key, String value);

    String getValue(String key);

}
