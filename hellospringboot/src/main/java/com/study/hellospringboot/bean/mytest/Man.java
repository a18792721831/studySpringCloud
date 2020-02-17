package com.study.hellospringboot.bean.mytest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@Component
@ConfigurationProperties(prefix = "people.man")
@PropertySource("classpath:myTest.properties")
public class Man extends AbPeople {
    public Man() {
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Man)) return false;
        final Man other = (Man) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof Man;
    }

    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

    @Override
    public String toString() {
        return "Man()";
    }
}
