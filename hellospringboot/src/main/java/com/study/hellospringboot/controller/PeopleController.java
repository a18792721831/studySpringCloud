package com.study.hellospringboot.controller;

import com.study.hellospringboot.bean.mytest.Child;
import com.study.hellospringboot.bean.mytest.Man;
import com.study.hellospringboot.bean.mytest.People;
import com.study.hellospringboot.bean.mytest.Woman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-02-13
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private People people;

    @RequestMapping("")
    public People readPeople() {
        return people;
    }

    @RequestMapping("/man")
    public Man readMan() {
        return people.getMan();
    }

    @RequestMapping("/woman")
    public Woman readWoman() {
        return people.getWoman();
    }

    @RequestMapping("/child")
    public Child readChild() {
        return people.getChild();
    }
}
