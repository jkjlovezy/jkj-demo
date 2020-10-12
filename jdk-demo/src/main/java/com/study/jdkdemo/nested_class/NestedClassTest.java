package com.study.jdkdemo.nested_class;

/**
 * outer class 访问 nested class：
 * static nested class ，外类的非static实例方法+ static类方法，都能够访问。
 * 非static nested class  只能外类的非static实例方法访问。
 *
 * nested class 访问 outer class：
 * static nested class ， 只能访问外类的static属性（field+method），  不能访问非static属性。
 * 非static nested class，可以访问外类的 static属性 + 非static属性。
 *
 * nested class 定义属性：
 * static nested class，可定义非static属性 + static属性.
 * 非static nested class， 只能定义非static属性，  不能定义static属性。
 */
public class NestedClassTest {
    private static String static_name = "static";
    private String nonstatic_name = "nonstatic";

    public static void main(String[] args) {
        NestedClassTest o = new NestedClassTest();
        /*System.out.println(new StaticNestedClass().getParentName());
        System.out.println(StaticNestedClass.getParentNameByStatic());*/

        o.m1();
        /*o.m2();*/
    }

    //1. 外类的非static实例方法，可以访问 Nested Class，static 或 非static类型的都可以。
    public void m1() {
        NonStaticNestedClass c = new NonStaticNestedClass();
        System.out.println(c.getParentName());

        StaticNestedClass c2 = new StaticNestedClass();
        System.out.println(c2.getParentName());
    }

    //2.外类的static类方法，只能访问 static类型的 nested class。
    public static void m2() {
        //NonStaticNestedClass c = new NonStaticNestedClass(); 编译报错
        StaticNestedClass c2 = new StaticNestedClass();
        System.out.println(c2.getParentName());
    }

    private void instance_method(){}
    private static void class_method(){}


    public static class StaticNestedClass {
        private String s1;
        private static String s2;
        public String getParentName() {
            //instance_method(); 编译报错，只能访问外类的static方法。
            class_method();
            return static_name;
        }

        public static String getParentNameByStatic() {
            //instance_method(); 编译报错，只能访问外类的static方法。
            class_method();
            return static_name;
        }
    }

    public class NonStaticNestedClass {
        private String s1;
        //private static String s2; 编译报错，non static nested class不能定义static field。
        //3.非static nested class中定义的方法，可以访问外类的static + 非static 属性。
        public String getParentName() {
            //return static_name; // 成功。
            instance_method();
            class_method();
            return nonstatic_name;
        }

        //4.编译报错，non static nested class不能定义static method。
        /*public static String getParentNameByStatic() {
            return static_name;
        }*/
    }
}
