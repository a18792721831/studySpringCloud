package com.study.springbootgateway.filter.post;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jiayq
 * @Date 2020-03-12
 */
@Component
public class RequestInfoPostFilter extends ZuulFilter {

    @Autowired
    private Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("post filter");
        try {
            tracer.currentSpan().tag("request people", InetAddress.getLocalHost().getHostName().toString());
        } catch (UnknownHostException e) {
            tracer.currentSpan().tag("request error", "get host name error");
        } finally {
            return null;
        }
    }
}
