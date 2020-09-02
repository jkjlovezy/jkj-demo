package com.study.springboot.configure.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.study.springboot.validate.BaseParamValidator;

/**
 * 日志切面
 *
 * @author xiapengpeng
 */
@Component
@Aspect
@Slf4j
public class ValidateParamAspect {

    @Pointcut("@annotation(com.study.springboot.enums.ValidPt)")
    public void validAnnotationPointcut() {
    }

    @Before(value = "validAnnotationPointcut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("signature.getMethod().getDeclaringClass() = "+signature.getMethod().getDeclaringClass());
        System.out.println("joinPoint.getThis() = "+joinPoint.getThis());
        System.out.println("joinPoint.getTarget() = "+joinPoint.getTarget());
        BaseParamValidator.validateParameters(joinPoint.getTarget(), signature.getMethod(), joinPoint.getArgs(), new Class[0]);
    }


}

