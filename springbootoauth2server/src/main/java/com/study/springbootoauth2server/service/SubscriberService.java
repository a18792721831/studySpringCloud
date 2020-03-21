package com.study.springbootoauth2server.service;

import com.study.springbootoauth2server.dao.SubscriberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jiayq
 * @Date 2020-03-20
 */
@Service
public class SubscriberService implements UserDetailsService {

    @Autowired
    private SubscriberDao subscriberDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return subscriberDao.findByUsername(username);
    }
}
