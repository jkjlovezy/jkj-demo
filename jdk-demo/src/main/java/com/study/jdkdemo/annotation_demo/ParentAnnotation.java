package com.study.jdkdemo.annotation_demo;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ParentAnnotation {
    String value() default "empty";
}
