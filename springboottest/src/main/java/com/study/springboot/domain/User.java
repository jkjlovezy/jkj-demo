package com.study.springboot.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.study.springboot.enums.SexEnum;
import com.study.springboot.enums.StatusEnum;
import com.study.springboot.validate.OnlyEnum;
import com.study.springboot.validate.OnlyEn;

public class User{

    @NotNull
    private Long userId;

    @OnlyEn(key = "user.username.onlyen",message = "只能输入英文字符")
    @Pattern(regexp = "(USD|MYR)")
    private String userName;

    @OnlyEnum(value = SexEnum.class,property = "value")
    //@NumberPattern(regexp = "(1|2|3|4|5)")
    private Integer sex;

    //@Pattern(regexp = "(1|2|3|4|5)")
    @OnlyEnum(value = StatusEnum.class, property = "status")
    private String status;

    @Valid
    private Person person;

    private Date birthday;

    @NotEmpty
    @OnlyEn
    private String emptyStr;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH")
    private Date birthday2;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(Date birthday2) {
        this.birthday2 = birthday2;
    }

    public String getEmptyStr() {
        return emptyStr;
    }

    public void setEmptyStr(String emptyStr) {
        this.emptyStr = emptyStr;
    }
}
