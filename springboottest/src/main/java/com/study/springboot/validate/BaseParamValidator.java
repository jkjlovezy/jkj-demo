package com.study.springboot.validate;
import com.study.springboot.domain.Person;
import java.util.Date;

import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;

import com.study.springboot.base.ApiBusiCodeEnum;
import com.study.springboot.base.ApiBusiException;
import com.study.springboot.domain.User;
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
        Set<ConstraintViolation<T>> validateSet = validator.forExecutables().validateParameters(var1, var2, var3, new Class[0]);
        if (validateSet != null && validateSet.size() > 0) {
            String messages = validateSet.stream().map(v -> v.getPropertyPath() + ":" + v.getMessage()).reduce((m1, m2) -> m1 + "；" + m2).orElse("invalid parameter！");
            throw new ApiBusiException(ApiBusiCodeEnum.FAIL.getCode(), messages);
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserId(0L);
        user.setUserName("USD");
        user.setSex(0);
        user.setStatus("1");
        user.setBirthday(new Date());
        user.setBirthday2(new Date());
        user.setEmptyStr("aa");
        validate(user);
    }
}
