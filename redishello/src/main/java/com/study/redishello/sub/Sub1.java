package com.study.redishello.sub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020/8/5
 */
@Component
public class Sub1 implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 消息体
        String body = new String(message.getBody());
        // 渠道 -- key/pattern
        String topicName = new String(pattern);

        System.out.println(body);
        System.out.println(topicName);
    }
}
