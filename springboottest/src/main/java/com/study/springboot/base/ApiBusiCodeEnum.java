package com.study.springboot.base;

public enum ApiBusiCodeEnum {
    SUCCESS("000000", "success", "操作成功"),
    FAIL("999999", "fail", "操作失败"),
    ;

    ApiBusiCodeEnum(String code, String key, String desc) {
        this.code = code;
        this.key = key;
        this.desc = desc;
    }

    private String code;
    private String key;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
