package com.study.jdkdemo.trycatch;

public class TrayCatchTest {
    public static void main(String[] args) {
        a();
    }

    public static String a(){
        try{
            int i = 1/0;
            return "";
        }catch (Exception e){
            System.out.println("occur exception");
            return "error";
        }finally {
            System.out.println("finnaly");
        }
    }
}
