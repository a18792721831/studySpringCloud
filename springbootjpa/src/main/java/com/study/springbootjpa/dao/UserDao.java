package com.study.springbootjpa.dao;

import com.study.springbootjpa.beans.Users;
import com.study.springbootjpa.neum.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
public interface UserDao extends JpaRepository<Users, Long> {

    List<Users> findUsersByUsernameAndStatus(String username, Status status);

}
