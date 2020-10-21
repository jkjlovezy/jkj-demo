package com.study.springboot.enums;

public enum StatusEnum {
    MAN("1", "开启"),
    WOMAN("2", "关闭");

    public final String status;
    public final String text;

    StatusEnum(String status, String text) {
        this.status = status;
        this.text = text;
    }

}
