package com.study.hellospringboot.bean.mytest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@Component
@PropertySource("classpath:myTest.properties")
@ConfigurationProperties(prefix = "people")
public class People {

    private Man man;

    private Woman woman;

    private Child child;

    public People() {
    }

    public Man getMan() {
        return this.man;
    }

    public Woman getWoman() {
        return this.woman;
    }

    public Child getChild() {
        return this.child;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof People)) return false;
        final People other = (People) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$man = this.getMan();
        final Object other$man = other.getMan();
        if (this$man == null ? other$man != null : !this$man.equals(other$man)) return false;
        final Object this$woman = this.getWoman();
        final Object other$woman = other.getWoman();
        if (this$woman == null ? other$woman != null : !this$woman.equals(other$woman)) return false;
        final Object this$child = this.getChild();
        final Object other$child = other.getChild();
        if (this$child == null ? other$child != null : !this$child.equals(other$child)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof People;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $man = this.getMan();
        result = result * PRIME + ($man == null ? 43 : $man.hashCode());
        final Object $woman = this.getWoman();
        result = result * PRIME + ($woman == null ? 43 : $woman.hashCode());
        final Object $child = this.getChild();
        result = result * PRIME + ($child == null ? 43 : $child.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "People(man=" + this.getMan() + ", woman=" + this.getWoman() + ", child=" + this.getChild() + ")";
    }
}
