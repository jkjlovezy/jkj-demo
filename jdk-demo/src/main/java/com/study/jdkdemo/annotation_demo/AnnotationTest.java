package com.study.jdkdemo.annotation_demo;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class AnnotationTest {
    public static void main(String[] args) {
        System.out.println("isAnnotation(): " + User.class.isAnnotation());
        System.out.println("isAnnotationPresent(Class<Annotation> annotationClass): " + User.class.isAnnotationPresent(UserAnnotaion.class));
        System.out.println("getAnnotation(Class<Annotation> annotationClass): " + User.class.getAnnotation(UserAnnotaion.class));

        //1.若父类上的Annotation 是@Inherited，  子类也能继承父类的Annotation。 打印2个：UserAnnotation +　ParentAnnotation.
        System.out.println("getAnnotation(Class<Annotation> annotationClass): " + User.class.getAnnotation(ParentAnnotation.class));

        //2.若父类上的Annotation 不是@Inherited，  子类不能继承父类的Annotation。 只打印1个：UserAnnotation， 不会打印父类的ParentAnnotation2。
        System.out.println("getAnnotation(Class<Annotation> annotationClass): " + User2.class.getAnnotation(ParentAnnotation2.class));

        //3.getAnnotations() 也会获取supperClass上被标记为@Inherited的Annotation。
        System.out.println("\nUser.class.getAnnotations():");
        Arrays.stream(User.class.getAnnotations()).forEach(annotation -> System.out.println(annotation));
        System.out.println("\nUser2.class.getAnnotations():");
        Arrays.stream(User2.class.getAnnotations()).forEach(annotation -> System.out.println(annotation));

        //4.getDeclaredAnnotations() 也会获取当前Class上的Annotation。
        System.out.println("\nUser.class.getDeclaredAnnotations():");
        Arrays.stream(User.class.getDeclaredAnnotations()).forEach(annotation -> System.out.println(annotation));

        System.out.println();
        //5.获取所有Annotation，并打印各Annotation实例的properties.
        for(Annotation annotation: User.class.getAnnotations()){
            Class annotationType = annotation.annotationType();
            System.out.println(annotationType);

            if(annotationType == UserAnnotaion.class){
                Annotation[] u = User.class.getDeclaredAnnotationsByType(annotationType);
                System.out.println(UserAnnotaion.class.cast(u[0]).value());
            }
        }


    }

    @UserAnnotaion
    public static class User extends Person{
    }

    @UserAnnotaion
    public static class User2 extends Person2{
    }

    @ParentAnnotation
    public static class Person{

    }

    @ParentAnnotation2
    public static class Person2{

    }
}
