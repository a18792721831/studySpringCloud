package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.mytest.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/man")
public class ManController extends AbController {

    @Autowired
    private Man man;

    public ManController(Man man) {
        super(man);
    }

    @RequestMapping("")
    public Man readMan() {
        return man;
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
