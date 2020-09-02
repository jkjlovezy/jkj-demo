package com.study.springboot.validate;

import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;

import com.study.springboot.base.ApiBusiCodeEnum;
import com.study.springboot.base.ApiBusiException;
import com.study.springboot.service.UserService;

public class BaseParamValidator {

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> validateSet = validator.validate(obj, new Class[0]);
        if (validateSet != null && validateSet.size() > 0) {
            String messages = validateSet.stream().map(v -> v.getPropertyPath() + ":" + v.getMessage()).reduce((m1, m2) -> m1 + "；" + m2).orElse("invalid parameter！");
            throw new ApiBusiException(ApiBusiCodeEnum.FAIL.getCode(), messages);
        }
    }


    public static <T> void validateParameters(T var1, Method var2, Object[] var3, Class<?>... var4) {
        Set<ConstraintViolation<T>> validateSet = validator.forExecutables().validateParameters(var1, var2, var3, var4);
        if (validateSet != null && validateSet.size() > 0) {
            String messages = validateSet.stream().map(v -> v.getPropertyPath() + ":" + v.getMessage()).reduce((m1, m2) -> m1 + "；" + m2).orElse("invalid parameter！");
            throw new ApiBusiException(ApiBusiCodeEnum.FAIL.getCode(), messages);
        }
    }

}
