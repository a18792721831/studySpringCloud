package com.study.springbootribbon.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-02-24
 */
@SpringBootTest
public class RestRibbonServiceTest {

    private static final Logger logger = Logger.getLogger(RestRibbonServiceTest.class.getName());

    @Autowired
    private RestRibbonService restRibbonService;

    @Test
    public void testRestHi() {

        logger.warning("test RestRibbonService restHi + xiaohua" + restRibbonService.restHi("xiaohua"));
        logger.warning("test RestRibbonService restHi + xiaoli" + restRibbonService.restHi("xiaoli"));

    }

    @Test
    public void testRestHello() {
        logger.warning("test RestRibbonService restHello + xiaomei " + restRibbonService.restHello("小美"));
        logger.warning("test RestRibbonService restHello + 小梅 " + restRibbonService.restHello("小梅"));
    }

}
