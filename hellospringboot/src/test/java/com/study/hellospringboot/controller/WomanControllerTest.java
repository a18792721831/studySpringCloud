package com.study.hellospringboot.controller;

import com.study.hellospringboot.AbstractTest;
import com.study.hellospringboot.bean.mytest.Woman;
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
public class WomanControllerTest extends AbstractTest {

    @Autowired
    private Woman woman;

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(WomanControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/woman";
    }

    @Test
    public void testReadWoman() {
        ResponseEntity<Woman> responseEntity = testRestTemplate.getForEntity(
                url, Woman.class);
        assertThat(responseEntity.getBody(), equalTo(woman));
        logger.warning(url + " testReadWoman test success");
    }

    @Test
    public void testReadWomanName() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/name", String.class);
        assertThat(responseEntity.getBody(), equalTo("woman"));
        logger.warning(url + "/name testReadWomanName test success");
    }

    @Test
    public void testReadWomanAge() {
        ResponseEntity<Integer> responseEntity = testRestTemplate.getForEntity(
                url + "/age", Integer.class);
        assertThat(responseEntity.getBody(), equalTo(32));
        logger.warning(url + "/age testReadWomanAge test success");
    }

    @Test
    public void testReadWomanValue() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/value", String.class);
        assertThat(responseEntity.getBody(), equalTo("woman and age is 32"));
        logger.warning(url + "/value testReadWomanValue test success");
    }

    @Test
    public void testReadWomanLike() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(
                url + "/like", String.class);
        assertThat(responseEntity.getBody(), equalTo("music"));
        logger.warning(url + "/like testReadWomanLike test success");
    }

}
