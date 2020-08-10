package com.study.redishello.service;

import com.study.redishello.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020/8/7
 */
public interface UserService {

    User getUser(Long id);

    User insertUser(User user);

    User updateUserName(Long id,String userName);

    List<User> findUsers(String userName, String note);

    int deleteUser(Long id);

}
