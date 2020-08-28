package com.study.springboot.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.alibaba.fastjson.JSON;
import com.study.springboot.domain.User;

@Service
public class UserService {

    @Autowired
    LocalValidatorFactoryBean validatorFactoryBean;

    public void addUser(User user){
        validatorFactoryBean.setValidationMessageSource(resourceBundleMessageSource());
        Set<ConstraintViolation<User>> validateSet = validatorFactoryBean.validate(user,new Class[0]);
//        Validation.buildDefaultValidatorFactory().getMessageInterpolator().
//        Set<ConstraintViolation<User>> validateSet = Validation.buildDefaultValidatorFactory().getValidator().validate(user,new Class[0]);
        if(!CollectionUtils.isEmpty(validateSet)){
            for(ConstraintViolation<User> violation:validateSet ){
                violation.getMessage();
                violation.getConstraintDescriptor().getAnnotation();
                violation.getInvalidValue();
                violation.getMessageTemplate();
            }
            String messages = validateSet.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
//            throw new IllegalArgumentException(messages);
        }
    }

    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        //指定国际化的Resource Bundle地址
        resourceBundleMessageSource.setBasename("i18n/messages");
        //指定国际化的默认编码
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }
}
