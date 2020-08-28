package com.study.springboot.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValidate {
    Class<?> value();

    String property() default "value";

    String message() default "传参有误，非法的枚举值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
