package com.study.springboot.base;

public class ApiResult<T> {
    private boolean status = true;
    private String code = ApiBusiCodeEnum.SUCCESS.getCode();
    private String msg = ApiBusiCodeEnum.SUCCESS.getDesc();
    private T data;

    private static final String SUCCESS_CODE = ApiBusiCodeEnum.SUCCESS.getCode();
    private static final String FAIL_CODE = ApiBusiCodeEnum.FAIL.getCode();

    public ApiResult() {
    }

    public ApiResult(boolean status, String code, String msg, T data) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, SUCCESS_CODE, "", data);
    }

    public static <T> ApiResult<T> fail(String msg) {
        return new ApiResult<>(false, FAIL_CODE, msg, null);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
