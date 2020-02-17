package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.myymltest.Child1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@RestController
@RequestMapping("/child1")
public class Child1Controller extends AbController {

    @Autowired
    private Child1 child1;

    public Child1Controller(Child1 child1) {
        super(child1);
    }

    @RequestMapping("")
    public Child1 readChild1() {
        return child1;
    }

    @RequestMapping("/school")
    public String readSchool() {
        return child1.getSchool();
    }

    @RequestMapping("/name")
    public String readChildName() {
        return super.readName();
    }

    @RequestMapping("/age")
    public int readChildAge() {
        return super.readAge();
    }

    @RequestMapping("/value")
    public String readChildValue() {
        return super.readValue();
    }
}
