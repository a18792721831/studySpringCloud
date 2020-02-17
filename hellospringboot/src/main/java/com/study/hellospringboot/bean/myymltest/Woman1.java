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
@ConfigurationProperties(prefix = "people1.woman1")
@PropertySource(value = "classpath:myTest.yml", factory = YmlPropertySourceFactory.class)
public class Woman1 extends AbPeople {
    private String like;

    public Woman1() {
    }

    public String getLike() {
        return this.like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Woman1)) return false;
        final Woman1 other = (Woman1) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$like = this.getLike();
        final Object other$like = other.getLike();
        if (this$like == null ? other$like != null : !this$like.equals(other$like)) return false;
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof Woman1;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $like = this.getLike();
        result = result * PRIME + ($like == null ? 43 : $like.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Woman1(like=" + this.getLike() + ")";
    }
}
