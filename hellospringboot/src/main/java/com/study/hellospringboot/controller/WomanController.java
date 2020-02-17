package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.mytest.Woman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/woman")
public class WomanController extends AbController {

    @Autowired
    private Woman woman;

    public WomanController(Woman woman) {
        super(woman);
    }

    @RequestMapping("")
    public Woman readWoman() {
        return woman;
    }

    @RequestMapping("/like")
    public String readLike() {
        return woman.getLike();
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
