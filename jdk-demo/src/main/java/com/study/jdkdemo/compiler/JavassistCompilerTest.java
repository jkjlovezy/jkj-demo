/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.study.jdkdemo.compiler;

import java.lang.reflect.Method;

import com.study.jdkdemo.compiler.support.JavassistCompiler;

public class JavassistCompilerTest extends JavaCodeTest {
    public static void main(String[] args) throws Exception {
        testCompileJavaClass();
    }

    public static void testCompileJavaClass() throws Exception {
        JavassistCompiler compiler = new JavassistCompiler();
        Class<?> clazz = compiler.compile(getSimpleCode(), JavassistCompiler.class.getClassLoader());

        // Because javassist compiles using the caller class loader, we should't use HelloService directly
        Object instance = clazz.newInstance();
        Method sayHello = instance.getClass().getMethod("sayHello");
        //Assertions.assertEquals("Hello world!", sayHello.invoke(instance));
        System.out.println(sayHello.invoke(instance));
        ;
    }

    /**
     * javassist compile will find HelloService in classpath
     */

    public static void testCompileJavaClass0() throws Exception {
        JavassistCompiler compiler = new JavassistCompiler();
        Class<?> clazz = compiler.compile(getSimpleCodeWithoutPackage(), JavassistCompiler.class.getClassLoader());
        Object instance = clazz.newInstance();
        Method sayHello = instance.getClass().getMethod("sayHello");
        //Assertions.assertEquals("Hello world!", sayHello.invoke(instance));
        System.out.println(sayHello.invoke(instance));
        ;
    }

    public static void testCompileJavaClass1() throws Exception {
        JavassistCompiler compiler = new JavassistCompiler();
        Class<?> clazz = compiler.compile(getSimpleCodeWithSyntax0(), JavassistCompiler.class.getClassLoader());
        Object instance = clazz.newInstance();
        Method sayHello = instance.getClass().getMethod("sayHello");
        System.out.println(sayHello.invoke(instance));
        ;

    }

    public static void testCompileJavaClassWithImport() throws Exception {
        JavassistCompiler compiler = new JavassistCompiler();
        Class<?> clazz = compiler.compile(getSimpleCodeWithImports(), JavassistCompiler.class.getClassLoader());
        Object instance = clazz.newInstance();
        Method sayHello = instance.getClass().getMethod("sayHello");
        System.out.println(sayHello.invoke(instance));
        ;
    }

    public static void testCompileJavaClassWithExtends() throws Exception {
        JavassistCompiler compiler = new JavassistCompiler();
        Class<?> clazz = compiler.compile(getSimpleCodeWithWithExtends(), JavassistCompiler.class.getClassLoader());
        Object instance = clazz.newInstance();
        Method sayHello = instance.getClass().getMethod("sayHello");
        System.out.println(sayHello.invoke(instance));

    }
}
