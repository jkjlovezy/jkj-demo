package com.study.util.extendsdemo;

public class Main {
    public static void main(String[] args) {
        BusiService service = new BusiService();
        Child c = new Child();
        c.setId(1);
        c.setName("test");
        c.setAge(20);
        service.print(c);
    }
}
