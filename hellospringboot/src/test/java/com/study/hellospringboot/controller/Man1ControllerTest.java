package com.study.hellospringboot.controller;

import com.study.hellospringboot.AbstractTest;
import com.study.hellospringboot.bean.myymltest.Man1;
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
public class Man1ControllerTest extends AbstractTest {
    @Autowired
    private Man1 man1;

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(ManControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/man1";
    }

    @Test
    public void testReadMan() {
        ResponseEntity<Man1> responseEntity = testRestTemplate.getForEntity(
                url, Man1.class);
        assertThat(responseEntity.getBody(), equalTo(man1));
        logger.warning(url + " testReadMan test success");
    }

    @Test
    public void testReadManName() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/name", String.class);
        assertThat(responseEntity.getBody(), equalTo("man"));
        logger.warning(url + "/name testReadManName test success");
    }

    @Test
    public void testReadManAge() {
        ResponseEntity<Integer> responseEntity = testRestTemplate.getForEntity(
                url + "/age", Integer.class);
        assertThat(responseEntity.getBody(), equalTo(22));
        logger.warning(url + "/age testReadManAge test success");
    }

    @Test
    public void testReadManValue() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/value", String.class);
        assertThat(responseEntity.getBody(), equalTo("man and age is 22"));
        logger.warning(url + "/value testReadManValue test success");

    }
}
