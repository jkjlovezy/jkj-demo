package com.study.jdkdemo.enum_demo.chapter1;


import static com.study.jdkdemo.enum_demo.chapter1.ServiceTypeProperty.RECORD_STATISTICS;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(ServiceType.ASYNC);
        System.out.println(ServiceType.ASYNC.getCategory());
        ServiceType HTTP_CLIENT_3 = ServiceTypeFactory.of(9050, "HTTP_CLIENT_3", RECORD_STATISTICS);
        System.out.println(HTTP_CLIENT_3.isRpcClient());
    }
}
