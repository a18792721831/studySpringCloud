package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.myymltest.Man1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-17
 */
@RestController
@RequestMapping("/man1")
public class Man1Controller extends AbController {

    @Autowired
    private Man1 man1;

    public Man1Controller(Man1 man1) {
        super(man1);
    }

    @RequestMapping("/name")
    public String readManName() {
        return super.readName();
    }

    @RequestMapping("/age")
    public int readManAge() {
        return super.readAge();
    }

    @RequestMapping("/value")
    public String readManValue() {
        return super.readValue();
    }
}
