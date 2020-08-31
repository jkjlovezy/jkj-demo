package com.study.springboot.domain;

import javax.validation.constraints.NotNull;

import com.study.springboot.enums.SexEnum;
import com.study.springboot.validate.EnumValidate;
import com.study.springboot.validate.OnlyEn;

public class User {

    @NotNull
    private Long userId;

    @OnlyEn(key = "user.username.onlyen",message = "只能输入英文字符")
    private String userName;

    @EnumValidate(value = SexEnum.class)
    private Integer sex;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
