package com.classloader.chapter1;

import java.io.File;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        System.out.println(Main1.class.getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(new File("1.txt").getCanonicalPath());

        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
