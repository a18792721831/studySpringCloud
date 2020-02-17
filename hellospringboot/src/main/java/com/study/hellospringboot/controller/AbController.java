package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.mytest.AbPeople;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
public class AbController {

    private AbPeople abPeople;

    public AbController(AbPeople abPeople) {
        this.abPeople = abPeople;
    }

    protected String readName() {
        return abPeople.getName();
    }

    protected int readAge() {
        return abPeople.getAge();
    }

    protected String readValue() {
        return abPeople.getValue();
    }
}
