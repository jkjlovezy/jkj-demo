package com.study.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.study.springboot.domain.User;
import com.study.springboot.enums.ValidPt;
import com.study.springboot.validate.BaseParamValidator;


@Service
public class UserService {

    @Autowired
    LocalValidatorFactoryBean validatorFactoryBean;

    public void addUser(User user) {
        BaseParamValidator.validate(user);
     /*   Set<ConstraintViolation<User>> validateSet = Validation.buildDefaultValidatorFactory().getValidator().validate(user,new Class[0]);
        if(!CollectionUtils.isEmpty(validateSet)){
            for(ConstraintViolation<User> violation:validateSet ){
                System.out.println(violation.getMessage());
                System.out.println(violation.getConstraintDescriptor().getAnnotation());
                System.out.println(violation.getInvalidValue());
                System.out.println(violation.getMessageTemplate());;
            }
            String messages = validateSet.stream()
                    .map(v-> v.getPropertyPath()+v.getMessage())
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            System.out.println("校验有误:"+messages);
        }*/
    }


    @ValidPt
    public void addUser2(@NotNull Long userId, @NotNull String userName) {
        System.out.println("service:" + userId + userName);
     /*   Set<ConstraintViolation<User>> validateSet = Validation.buildDefaultValidatorFactory().getValidator().validate(user,new Class[0]);
        if(!CollectionUtils.isEmpty(validateSet)){
            for(ConstraintViolation<User> violation:validateSet ){
                System.out.println(violation.getMessage());
                System.out.println(violation.getConstraintDescriptor().getAnnotation());
                System.out.println(violation.getInvalidValue());
                System.out.println(violation.getMessageTemplate());;
            }
            String messages = validateSet.stream()
                    .map(v-> v.getPropertyPath()+v.getMessage())
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            System.out.println("校验有误:"+messages);
        }*/
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
