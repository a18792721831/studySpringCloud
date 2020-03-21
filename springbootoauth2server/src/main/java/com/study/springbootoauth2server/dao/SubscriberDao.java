package com.study.springbootoauth2server.dao;

import com.study.springbootoauth2server.beans.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jiayq
 * @Date 2020-03-20
 */
public interface SubscriberDao extends JpaRepository<Subscriber, Long> {

    Subscriber findByUsername(String username);

}
