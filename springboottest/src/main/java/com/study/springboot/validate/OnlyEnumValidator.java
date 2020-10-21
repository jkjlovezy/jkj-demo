package com.study.springboot.validate;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class OnlyEnumValidator implements ConstraintValidator<OnlyEnum, Object>, Annotation {

    private List<Object> values = new ArrayList<>();

    @Override
    public void initialize(OnlyEnum enumValidate) {
        Class<?> clz = enumValidate.value();
        String property = enumValidate.property();
        try {
            Field field = clz.getDeclaredField(property);
            field.setAccessible(true);
            Object value = null;
            for (Object obj : clz.getEnumConstants()) {
                value = field.get(obj);
                values.add(value);
            }
        } catch (NoSuchFieldException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return Objects.isNull(value) || values.contains(value);
    }
}
