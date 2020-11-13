package com.study.sw.api.domain;

public class CustomException extends RuntimeException {
    public CustomException(String msg){
        super(msg);
    }
}
