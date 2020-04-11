package com.study.springbootrabbitmq.util;

import org.junit.jupiter.api.Test;

/**
 * @author jiayq
 * @Date 2020-04-04
 */
public class QueueNameUtilTest {

    @Test
    public void testQueueNameUtil(){
        System.out.println(QueueNameUtil.queueNameBuilder()
                .vHost("jyq")
                .rountKey("jyqRountKey")
                .exchange("jyqExchange")
                .queue("jyqQueue")
                .split("-")
                .build()
        );
    }

}
