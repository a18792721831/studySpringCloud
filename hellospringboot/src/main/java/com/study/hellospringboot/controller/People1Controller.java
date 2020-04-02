package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.myymltest.Child1;
import com.study.hellospringboot.bean.myymltest.Man1;
import com.study.hellospringboot.bean.myymltest.People1;
import com.study.hellospringboot.bean.myymltest.Woman1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@RestController
@RequestMapping("/people1")
public class People1Controller {

    @Autowired
    private People1 people1;

    @RequestMapping("")
    public People1 readPeople() {
        return people1;
    }

    @RequestMapping("/man1")
    public Man1 readMan() {
        return people1.getMan1();
    }

    @RequestMapping("/woman1")
    public Woman1 readWoman() {
        return people1.getWoman1();
    }

    @RequestMapping("/child1")
    public Child1 readChild() {
        return people1.getChild1();
    }

}