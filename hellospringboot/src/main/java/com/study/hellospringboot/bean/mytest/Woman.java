package com.study.hellospringboot.bean.mytest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@Component
@ConfigurationProperties(prefix = "people.woman")
@PropertySource("classpath:myTest.properties")
public class Woman extends AbPeople {

    private String like;

    public Woman() {
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
        if (!(o instanceof Woman)) return false;
        final Woman other = (Woman) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$like = this.getLike();
        final Object other$like = other.getLike();
        if (this$like == null ? other$like != null : !this$like.equals(other$like)) return false;
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof Woman;
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
        return "Woman(like=" + this.getLike() + ")";
    }
}
