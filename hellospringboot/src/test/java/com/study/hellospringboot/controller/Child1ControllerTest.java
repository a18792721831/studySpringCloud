package com.study.hellospringboot.controller;

import com.study.hellospringboot.AbstractTest;
import com.study.hellospringboot.bean.myymltest.Child1;
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
public class Child1ControllerTest extends AbstractTest {

    @Autowired
    private Child1 child1;

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(Child1ControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/child1";
    }

    @Test
    public void testReadChild() {
        ResponseEntity<Child1> responseEntity = testRestTemplate.getForEntity(
                url, Child1.class);
        assertThat(responseEntity.getBody(), equalTo(child1));
        logger.warning(url + " testReadChild test success");
    }

    @Test
    public void testReadChildName() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/name", String.class);
        assertThat(responseEntity.getBody(), equalTo("child"));
        logger.warning(url + "/name testReadChildName test success");
    }

    @Test
    public void testReadChildAge() {
        ResponseEntity<Integer> responseEntity = testRestTemplate.getForEntity(
                url + "/age", Integer.class);
        assertThat(responseEntity.getBody(), equalTo(8));
        logger.warning(url + "/age testReadChildAge test success");
    }

    @Test
    public void testReadChildValue() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/value", String.class);
        assertThat(responseEntity.getBody(), equalTo("child and age is 8"));
        logger.warning(url + "/value testReadChildValue test success");
    }

    @Test
    public void testReadChildSchool() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/school", String.class);
        assertThat(responseEntity.getBody(), equalTo("high school"));
        logger.warning(url + "/school testReadChildSchool test success");
    }

}
