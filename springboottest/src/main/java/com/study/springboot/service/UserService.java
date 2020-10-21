package com.study.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.alibaba.fastjson.JSON;
import com.study.springboot.domain.User;
import com.study.springboot.enums.ParamValid;
import com.study.springboot.validate.BaseParamValidator;


@Service
public class UserService {

    @Autowired
    LocalValidatorFactoryBean validatorFactoryBean;

    //进行校验
    public void addUser(User user) {
        BaseParamValidator.validate(user);
        System.out.println("UserService.addUser1:" + JSON.toJSONString(user));
    }

    //进行校验
    @ParamValid
    public void addUser2(@NotNull Long userId, @NotNull String userName) {
        System.out.println("UserService.addUser2:" + userId + userName);
    }

    //进行校验
    @ParamValid
    public void addUser3(@Valid User user) {
        System.out.println("UserService.addUser3:" + JSON.toJSONString(user));
    }

    //没有进行校验，因为方法发参数上没有加@Valid注解
    @ParamValid
    public void addUser4(User user) {
        System.out.println("UserService.addUser3:" + JSON.toJSONString(user));
    }


    /*public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        //指定国际化的Resource Bundle地址
        resourceBundleMessageSource.setBasename("i18n/messages");
        //指定国际化的默认编码
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }*/
}
