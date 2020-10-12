package com.study.jdkdemo.annotation_demo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
public @interface ParentAnnotation2 {
    String value() default "empty";
}
