package com.study.hellospringboot.controller;

import com.study.hellospringboot.AbstractTest;
import com.study.hellospringboot.bean.myymltest.Child1;
import com.study.hellospringboot.bean.myymltest.Man1;
import com.study.hellospringboot.bean.myymltest.People1;
import com.study.hellospringboot.bean.myymltest.Woman1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
public class People1ControllerTest extends AbstractTest {

    @Autowired
    private People1 people1;

    @Autowired
    private Man1 man1;

    @Autowired
    private Woman1 woman1;

    @Autowired
    private Child1 child1;

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(People1ControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/people1";
    }

    @Test
    public void testReadPeople() {
        ResponseEntity<People1> responseEntity = testRestTemplate.getForEntity(
                url, People1.class);
        assertThat(responseEntity.getBody(), equalTo(people1));
        logger.warning(url + " testReadPeople test success");
    }

    @Test
    public void testReadPeopleMan() {
        ResponseEntity<Man1> manResponseEntity = testRestTemplate.getForEntity(
                url + "/man1", Man1.class);
        assertThat(manResponseEntity.getBody(), equalTo(man1));
        logger.warning(url + "/man1 testReadPeopleMan test success");
    }

    @Test
    public void testReadPeopleWoman() {
        ResponseEntity<Woman1> womanResponseEntity = testRestTemplate.getForEntity(
                url + "/woman1", Woman1.class);
        assertThat(womanResponseEntity.getBody(), equalTo(woman1));
        logger.warning(url + "/woman1 testReadPeopleWoman test success");
    }

    @Test
    public void testReadPeopleChild() {
        ResponseEntity<Child1> childResponseEntity = testRestTemplate.getForEntity(
                url + "/child1", Child1.class);
        assertThat(childResponseEntity.getBody(), equalTo(child1));
        logger.warning(url + "/child1 testReadPeopleChild test success");
    }
}
