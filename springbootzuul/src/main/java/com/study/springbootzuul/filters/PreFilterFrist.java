package com.study.springbootzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author jiayq
 * @Date 2020-03-04
 */
@Component
public class PreFilterFrist extends ZuulFilter {

    private static final Logger logger = Logger.getLogger(PreFilterFrist.class.getName());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext.getCurrentContext().getResponse().getOutputStream().write("ok : PreFilterFrist is ok! ".getBytes());
        } catch (Exception e) {
            logger.warning("exception : " + e.getMessage());
            return null;
        }
        logger.warning("ok : PreFilterFrist is ok! ");
        return null;
    }
}
