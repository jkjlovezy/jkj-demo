package com.study.jdkdemo.compiler.support;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;

public class ClassUtils {
    public static final String CLASS_EXTENSION = ".class";

    public static final String JAVA_EXTENSION = ".java";
    public static Object newInstance(String name) {
        try {
            return forName(name).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public static Class<?> forName(String[] packages, String className) {
        try {
            return classForName(className);
        } catch (ClassNotFoundException e) {
            if (packages != null && packages.length > 0) {
                for (String pkg : packages) {
                    try {
                        return classForName(pkg + "." + className);
                    } catch (ClassNotFoundException ignore) {
                    }
                }
            }
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public static Class<?> forName(String className) {
        try {
            return classForName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public static Class<?> classForName(String className) throws ClassNotFoundException {
        switch (className) {
            case "boolean":
                return boolean.class;
            case "byte":
                return byte.class;
            case "char":
                return char.class;
            case "short":
                return short.class;
            case "int":
                return int.class;
            case "long":
                return long.class;
            case "float":
                return float.class;
            case "double":
                return double.class;
            case "boolean[]":
                return boolean[].class;
            case "byte[]":
                return byte[].class;
            case "char[]":
                return char[].class;
            case "short[]":
                return short[].class;
            case "int[]":
                return int[].class;
            case "long[]":
                return long[].class;
            case "float[]":
                return float[].class;
            case "double[]":
                return double[].class;
            default:
        }
        try {
            return arrayForName(className);
        } catch (ClassNotFoundException e) {
            // try to load from java.lang package
            if (className.indexOf('.') == -1) {
                try {
                    return arrayForName("java.lang." + className);
                } catch (ClassNotFoundException ignore) {
                    // ignore, let the original exception be thrown
                }
            }
            throw e;
        }
    }

    private static Class<?> arrayForName(String className) throws ClassNotFoundException {
        return Class.forName(className.endsWith("[]")
                ? "[L" + className.substring(0, className.length() - 2) + ";"
                : className, true, Thread.currentThread().getContextClassLoader());
    }
    public static String toString(Throwable e) {
        StringWriter w = new StringWriter();
        PrintWriter p = new PrintWriter(w);
        p.print(e.getClass().getName() + ": ");
        if (e.getMessage() != null) {
            p.print(e.getMessage() + "\n");
        }
        p.println();
        try {
            e.printStackTrace(p);
            return w.toString();
        }
        finally {
            p.close();
        }
    }

    /**
     * get simple class name from qualified class name
     */
    public static String getSimpleClassName(String qualifiedName) {
        if (null == qualifiedName) {
            return null;
        }
        int i = qualifiedName.lastIndexOf('.');
        return i < 0 ? qualifiedName : qualifiedName.substring(i + 1);
    }

    public static URI toURI(String name) {
        try {
            return new URI(name);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
