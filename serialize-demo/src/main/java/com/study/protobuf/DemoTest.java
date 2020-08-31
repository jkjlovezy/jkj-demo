package com.study.protobuf;

import com.alibaba.fastjson.JSON;
import com.carson.proto.Demo;
import com.carson.proto.Demo.Person;
import com.google.protobuf.InvalidProtocolBufferException;

public class DemoTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Person person = Person.newBuilder().setName("Tom").setId(1).setEmail("tom@qq.com").addPhone(Demo.Person.PhoneNumber.newBuilder().setNumber("17756342322").setType(Demo.Person.PhoneType.MOBILE)).build();
//        System.out.println(person);
        byte[] bytes = person.toByteArray();
        for (byte b : bytes) {
            System.out.print((char)b+ " ");
        }
        System.out.println();
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();
        for (byte b : bytes) {
//            System.out.print(b + " ");
            System.out.print(String.format("%8s",Integer.toBinaryString(b & 0xFF+0x100)).replaceAll(" ","0")+"("+(char)b+")" +" ");
        }
        System.out.println();
        Person p = Person.parseFrom(bytes);
//        System.out.println(p);
    }
}
