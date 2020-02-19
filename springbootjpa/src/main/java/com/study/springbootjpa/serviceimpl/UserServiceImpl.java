package com.study.springbootjpa.serviceimpl;

import com.study.springbootjpa.beans.Users;
import com.study.springbootjpa.dao.UserDao;
import com.study.springbootjpa.neum.Status;
import com.study.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Users addUser(Users users) {
        userDao.save(users);
        return users;
    }

    @Override
    public List<Users> batchAddUser(List<Users> users) {
        userDao.saveAll(users);
        return users;
    }

    @Override
    public Users deltetUser(Users users) {
        users.setStatus(Status.INVALID);
        userDao.save(users);
        return users;
    }

    @Override
    public List<Users> batchDeleteUser(List<Users> users) {
        users.stream().forEach(u -> u.setStatus(Status.INVALID));
        userDao.saveAll(users);
        return users;
    }

    @Override
    public Users modifyUser(Users users) {
        userDao.save(users);
        return users;
    }

    @Override
    public List<Users> batchModifyUser(List<Users> users) {
        userDao.saveAll(users);
        return users;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<Users> findByName(String name) {
        return userDao.findUsersByUsernameAndStatus(name, Status.VALID);
    }
}
