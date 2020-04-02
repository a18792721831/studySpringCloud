package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.mytest.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/child")
public class ChildController extends AbController {

    @Autowired
    private Child child;

    public ChildController(Child child) {
        super(child);
    }

    @RequestMapping("")
    public Child readChild() {
        return child;
    }

    @RequestMapping("/school")
    public String readSchool() {
        return child.getSchool();
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
