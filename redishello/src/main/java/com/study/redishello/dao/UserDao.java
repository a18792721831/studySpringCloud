package com.study.redishello.dao;

import com.study.redishello.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020/8/6
 */
@Repository
public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName") String userName, @Param("note") String note);

    int deleteUser(Long id);

}
