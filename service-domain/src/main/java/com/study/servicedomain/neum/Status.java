package com.study.servicedomain.neum;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author jiayq
 * @Date 2020-03-29
 */
public enum Status {

    VALID("valid", "有效", 1),
    INVALID("invalid","无效",0);

    private String code;

    private String name;

    @Getter
    private int value;

    private Status(String code, String name, int value){
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public static Status getFromValue(int value){
        return Arrays.stream(Status.values()).filter(s -> s.value == value).findAny().get();
    }

}
