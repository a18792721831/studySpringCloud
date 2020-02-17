package com.study.hellospringboot.bean.myymltest;

import com.study.hellospringboot.propertySourceFactory.YmlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@Component
@ConfigurationProperties(prefix = "people1")
@PropertySource(value = "classpath:myTest.yml", factory = YmlPropertySourceFactory.class)
public class People1 {

    private Man1 man1;

    private Woman1 woman1;

    private Child1 child1;

    public People1() {
    }

    public Man1 getMan1() {
        return this.man1;
    }

    public Woman1 getWoman1() {
        return this.woman1;
    }

    public Child1 getChild1() {
        return this.child1;
    }

    public void setMan1(Man1 man1) {
        this.man1 = man1;
    }

    public void setWoman1(Woman1 woman1) {
        this.woman1 = woman1;
    }

    public void setChild1(Child1 child1) {
        this.child1 = child1;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof People1)) return false;
        final People1 other = (People1) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$man1 = this.getMan1();
        final Object other$man1 = other.getMan1();
        if (this$man1 == null ? other$man1 != null : !this$man1.equals(other$man1)) return false;
        final Object this$woman1 = this.getWoman1();
        final Object other$woman1 = other.getWoman1();
        if (this$woman1 == null ? other$woman1 != null : !this$woman1.equals(other$woman1)) return false;
        final Object this$child1 = this.getChild1();
        final Object other$child1 = other.getChild1();
        if (this$child1 == null ? other$child1 != null : !this$child1.equals(other$child1)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof People1;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $man1 = this.getMan1();
        result = result * PRIME + ($man1 == null ? 43 : $man1.hashCode());
        final Object $woman1 = this.getWoman1();
        result = result * PRIME + ($woman1 == null ? 43 : $woman1.hashCode());
        final Object $child1 = this.getChild1();
        result = result * PRIME + ($child1 == null ? 43 : $child1.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "People1(man1=" + this.getMan1() + ", woman1=" + this.getWoman1() + ", child1=" + this.getChild1() + ")";
    }
}
