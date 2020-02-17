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
@ConfigurationProperties(prefix = "people1.child1")
@PropertySource(value = "classpath:myTest.yml", factory = YmlPropertySourceFactory.class)
public class Child1 extends AbPeople {
    private String school;

    public Child1() {
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Child1)) return false;
        final Child1 other = (Child1) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$school = this.getSchool();
        final Object other$school = other.getSchool();
        if (this$school == null ? other$school != null : !this$school.equals(other$school)) return false;
        return true;
    }

    @Override
    protected boolean canEqual(final Object other) {
        return other instanceof Child1;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $school = this.getSchool();
        result = result * PRIME + ($school == null ? 43 : $school.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Child1(school=" + this.getSchool() + ")";
    }
}
