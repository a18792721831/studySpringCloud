package com.study.hellospringboot.bean.myymltest;

import com.study.hellospringboot.bean.mytest.AbPeople;
import com.study.hellospringboot.propertySourceFactory.YmlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@Component
@ConfigurationProperties(prefix = "people1.man1")
@PropertySource(factory = YmlPropertySourceFactory.class,value = "classpath:myTest.yml")
public class Man1 extends AbPeople {
    public Man1() {
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Man1)) return false;
        final Man1 other = (Man1) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof Man1;
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
