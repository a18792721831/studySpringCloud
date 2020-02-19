package com.study.springbootjpa.service;

import com.study.springbootjpa.beans.Users;

import java.util.List;
import java.util.Optional;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
public interface UserService {

    Users addUser(Users users);

    List<Users> batchAddUser(List<Users> users);

    Users deltetUser(Users users);

    List<Users> batchDeleteUser(List<Users> users);

    Users modifyUser(Users users);

    List<Users> batchModifyUser(List<Users> users);

    Optional<Users> findById(Long id);

    List<Users> findByName(String name);

}
