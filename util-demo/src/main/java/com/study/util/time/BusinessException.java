package com.study.util.time;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    public final int errorCode;
    public final String errorMsg;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        this.errorCode = errorCodeEnum.getCode();
        this.errorMsg = errorCodeEnum.getMsg();
    }

    public BusinessException(String errorMsg) {
        this.errorCode = ErrorCodeEnum.COMMON_ERROR.getCode();
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }
}
