/*
 * Copyright 2017 Focus Technology, Co., Ltd. All rights reserved.
 */
package com.study.springboot.validate;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 校验是否是纯英文
 * 
 * @author guonan
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OnlyEnValidator.class)
public @interface OnlyEn {

    // 国际化依靠配置文件做
    String DEFAULT_MSG = "请输入英文字符。";

    /**
     * 消息
     * 
     * @return
     */
    String message() default DEFAULT_MSG;

    String key() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
