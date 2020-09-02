package com.study.springboot.validate;

import java.util.regex.Matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.internal.engine.messageinterpolation.util.InterpolationHelper;

public class NumberPatternValidator implements ConstraintValidator<NumberPattern, Number> {
    private java.util.regex.Pattern pattern;
    private String escapedRegexp;

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

//        if (constraintValidatorContext instanceof HibernateConstraintValidatorContext) {
//            constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class).addMessageParameter("regexp", escapedRegexp);
//        }

        Matcher m = pattern.matcher(value.toString());
        return m.matches();
    }

    @Override
    public void initialize(NumberPattern constraintAnnotation) {
        pattern = java.util.regex.Pattern.compile(constraintAnnotation.regexp());

//        escapedRegexp = InterpolationHelper.escapeMessageParameter(constraintAnnotation.regexp());
    }
}
