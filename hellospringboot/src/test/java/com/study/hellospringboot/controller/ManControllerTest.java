package com.study.hellospringboot.controller;

import com.study.hellospringboot.AbstractTest;
import com.study.hellospringboot.bean.mytest.Man;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
public class ManControllerTest extends AbstractTest {

    @Autowired
    private Man man;

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(ManControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/man";
    }

    @Test
    public void testReadMan() {
        ResponseEntity<Man> responseEntity = testRestTemplate.getForEntity(
                url, Man.class);
        assertThat(responseEntity.getBody(), equalTo(man));
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
