package com.study.util.time;

public enum ErrorCodeEnum {
    COMMON_ERROR(-1, "操作失败"),
    PARAM_CHECK_ERROR(400, "请求参数非法");
    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
