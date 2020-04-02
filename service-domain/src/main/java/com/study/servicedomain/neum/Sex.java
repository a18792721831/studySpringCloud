package com.study.servicedomain.neum;

import java.util.Arrays;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
public enum Sex {

    MAN("man", "男", 0),
    WOMAN("woman", "女", 1);

    private int value;

    private String code;

    private String name;

    private Sex(String code, String name, int value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public static Sex getSexByValue(int value) {
        return Arrays.stream(Sex.values()).filter(s -> s.value == value).findAny().get();
    }

    public int getValue() {
        return this.value;
    }
}
