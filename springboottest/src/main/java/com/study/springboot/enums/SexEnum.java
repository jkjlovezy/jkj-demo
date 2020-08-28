package com.study.springboot.enums;

public enum SexEnum {
    MAN(0, "男"),
    WOMAN(1, "女");

    public final int value;
    public final String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
