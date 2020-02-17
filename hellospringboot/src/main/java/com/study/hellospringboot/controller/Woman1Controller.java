package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.mytest.AbPeople;
import com.study.hellospringboot.bean.myymltest.Woman1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@RestController
@RequestMapping("/woman1")
public class Woman1Controller extends AbController {

    @Autowired
    private Woman1 woman1;

    public Woman1Controller(Woman1 woman1) {
        super(woman1);
    }

    @RequestMapping("")
    public Woman1 readWoman() {
        return woman1;
    }

    @RequestMapping("/like")
    public String readLike() {
        return woman1.getLike();
    }

    @RequestMapping("/name")
    public String readWomanName() {
        return super.readName();
    }

    @RequestMapping("/age")
    public int readWomanAge() {
        return super.readAge();
    }

    @RequestMapping("/value")
    public String readWomanValue() {
        return super.readValue();
    }
}
