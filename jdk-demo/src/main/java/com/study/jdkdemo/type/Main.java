package com.study.jdkdemo.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;

public class Main {
    public static void main(String[] args) {
        test2();
    }

    static void test() {
        Type type = ChildClass.class.getGenericSuperclass(); //class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        System.out.println(type.getClass());
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(t -> System.out.println(t.getClass()));//class java.lang.Class
        System.out.println(parameterizedType.getActualTypeArguments()[0]); //class com.study.jdkdemo.type.OrderRequest
    }

    static void test2() {
        ChildClass childClass = new ChildClass();
        OrderResponse response = childClass.execute(new OrderRequest());
        System.out.println(JSON.toJSONString(response));
    }
}
