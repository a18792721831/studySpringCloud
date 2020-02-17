package com.study.hellospringboot.controller;

import com.study.hellospringboot.AbstractTest;
import com.study.hellospringboot.bean.mytest.Child;
import com.study.hellospringboot.bean.mytest.Man;
import com.study.hellospringboot.bean.mytest.People;
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
 * @Date 2020-02-17
 */
public class PeopleControllerTest extends AbstractTest {

    @Autowired
    private People people;

    @Autowired
    private Man man;

    @Autowired
    private Woman woman;

    @Autowired
    private Child child;

    @BeforeAll
    public static void init() {
        AbstractTest.init();
        logger = Logger.getLogger(PeopleControllerTest.class.getName());
    }

    @BeforeEach
    public void beforeTest() {
        super.beforeTest();
        url += "/people";
    }

    @Test
    public void testReadPeople() {
        ResponseEntity<People> responseEntity = testRestTemplate.getForEntity(
                url, People.class);
        assertThat(responseEntity.getBody(), equalTo(people));
        logger.warning(url + " testReadPeople test success");
    }

    @Test
    public void testReadPeopleMan() {
        ResponseEntity<Man> manResponseEntity = testRestTemplate.getForEntity(
                url + "/man", Man.class);
        assertThat(manResponseEntity.getBody(), equalTo(man));
        logger.warning(url + "/man testReadPeopleMan test success");
    }

    @Test
    public void testReadPeopleWoman() {
        ResponseEntity<Woman> womanResponseEntity = testRestTemplate.getForEntity(
                url + "/woman", Woman.class);
        assertThat(womanResponseEntity.getBody(), equalTo(woman));
        logger.warning(url + "/woman testReadPeopleWoman test success");
    }

    @Test
    public void testReadPeopleChild() {
        ResponseEntity<Child> childResponseEntity = testRestTemplate.getForEntity(
                url + "/child", Child.class);
        assertThat(childResponseEntity.getBody(), equalTo(child));
        logger.warning(url + "/child testReadPeopleChild test success");
    }

}
