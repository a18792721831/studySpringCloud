package com.study.springbootrabbitmq.util;

/**
 * @author jiayq
 * @Date 2020-04-04
 */
public class QueueNameBuilder {

    private String vHost;

    private String rountKey;

    private String exchange;

    private String queue;

    private String split;

    public QueueNameBuilder vHost(String vHost) {
        this.vHost = vHost;
        return this;
    }

    public QueueNameBuilder rountKey(String rountKey) {
        this.rountKey = rountKey;
        return this;
    }

    public QueueNameBuilder exchange(String exchange) {
        this.exchange = exchange;
        return this;
    }

    public QueueNameBuilder queue(String queue) {
        this.queue = queue;
        return this;
    }

    public QueueNameBuilder split(String split) {
        this.split = split;
        return this;
    }

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.vHost);
        stringBuilder.append(split);
        stringBuilder.append(this.rountKey);
        stringBuilder.append(split);
        stringBuilder.append(this.exchange);
        stringBuilder.append(split);
        stringBuilder.append(this.queue);
        return stringBuilder.toString();
    }

}
