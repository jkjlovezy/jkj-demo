package com.study.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FieldAccessor;

import java.lang.reflect.InvocationTargetException;

public class BuildClassTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /*DynamicType.Builder<Object> builder = new ByteBuddy()
                .subclass(Object.class)
                .name(fullyQualifiedClassName)
                .annotateType(annotations);
        for (AlternateTypePropertyBuilder each : properties) {
            builder = each.apply(builder);
        }
        return builder.make()
                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();*/

       /* return builder
                .defineMethod("set" + capitalize(name), Void.TYPE, Visibility.PUBLIC)
                .withParameters(clazz)
                .intercept(FieldAccessor.ofField(name));*/
        DynamicType.Builder<Object> builder = new ByteBuddy().subclass(Object.class).name("com.study.bytebuddy.dynamicbuild.User");
        builder.defineField("name", String.class, Visibility.PRIVATE);
        builder = builder.defineMethod("setName", Void.TYPE, Visibility.PUBLIC).withParameter(String.class,"name").intercept(FieldAccessor.ofField("name"));
        builder.defineMethod("getName", String.class, Visibility.PUBLIC).defaultValue("haha",String.class);
        Class dynamicClass = builder.make().load(BuildClassTest.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded();
        Object o = dynamicClass.newInstance();
        System.out.println(dynamicClass.getField("name").get(o));
    }

    public interface IUser{
        public String getName();
    }
}
