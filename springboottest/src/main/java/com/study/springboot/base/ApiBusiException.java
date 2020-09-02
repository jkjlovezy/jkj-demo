package com.study.springboot.base;

public class ApiBusiException extends RuntimeException {

    private String errorCode;

    private String errorMsg;

    private Object data;

    public ApiBusiException(ApiBusiCodeEnum apiBusiCodeEnum){
        this.errorCode = apiBusiCodeEnum.getCode();
        this.errorMsg = apiBusiCodeEnum.getDesc();
    }

    public ApiBusiException(String errorCode,String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
