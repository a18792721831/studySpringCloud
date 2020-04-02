package com.study.springbootconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiayq
 * @Date 2020-03-07
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Value("${message}")
    private String message;

    @GetMapping("/read")
    public String getMessage() {
        return message;
    }

}
