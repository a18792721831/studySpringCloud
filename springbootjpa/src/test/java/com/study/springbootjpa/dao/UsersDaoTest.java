package com.study.springbootjpa.dao;

import com.study.springbootjpa.beans.Users;
import com.study.springbootjpa.neum.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
@SpringBootTest
public class UsersDaoTest {

    private static final Logger logger = Logger.getLogger(UsersDaoTest.class.getName());

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindUsersByUsernameAndStatus() {
        Users users = new Users();
        String name = String.valueOf(new Random().nextLong());
        users.setUsername(name);
        users.setPassword(String.valueOf(new Random().nextLong()));
        users.setStatus(Status.VALID);
        userDao.save(users);
        Assert.isTrue(users.getId() == userDao.findUsersByUsernameAndStatus(name, Status.VALID).get(0).getId());
        logger.warning("test testFindUsersByUserNameAndStatus success");
    }

}
