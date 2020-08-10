package com.study.springbootrabbitmq.produce;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-04-04
 */
@Component
public class HelloProducer {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;


//    public void test(){
//        rabbitAmqpTemplate.send();
//    }
}
