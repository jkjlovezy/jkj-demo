package com.study.jdkdemo.compiler;

/**
 * copy from org.apache.dubbo.common.compiler.Compiler
 */
public interface Compiler {
    Class<?> compile(String code, ClassLoader classLoader);
}
