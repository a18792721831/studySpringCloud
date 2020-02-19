package com.study.springbootjpa.neum;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-02-18
 */
public enum Status {

    VALID("valid", 1),
    INVALID("invalid", 0);

    private int value;

    private String name;

    private Status(int value, String name) {
        this.value = value;
        this.name = name;
    }

    private Status(String name, int value) {
        this.value = value;
        this.name = name;
    }

    public static Status fromValue(int value) {
        return
                Optional.of(Arrays.stream(Status.values()).
                        filter(v -> v.getValue() == value).
                        collect(Collectors.toList()).get(0)).orElse(INVALID);
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
