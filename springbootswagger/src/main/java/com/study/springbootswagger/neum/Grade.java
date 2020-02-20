package com.study.springbootswagger.neum;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author jiayq
 * @Date 2020-02-19
 */
public enum Grade {
    ZORE("学前班", 0),
    ONE("一年级", 1),
    TWO("二年级", 2),
    THREE("三年级", 3),
    FOUR("四年级", 4),
    FIVE("五年级", 5),
    SIX("六年级", 6),
    NO("毕业生", -1);

    @Getter
    private int value;

    @Getter
    private String name;

    private Grade(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private Grade(int value, String name) {
        this.name = name;
        this.value = value;
    }

    public static Grade fromValue(int v) {
        return Optional.of(Arrays.stream(Grade.values()).filter(m -> m.getValue() == v).collect(Collectors.toList()).get(0)).orElse(NO);
    }
}
