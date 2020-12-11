package com.study.protobuf;

import com.carson.proto.Demo;
import com.carson.proto.Demo.Person;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * 官网地址：https://github.com/protocolbuffers/protobuf ，https://developers.google.com/protocol-buffers/docs/javatutorial
 * https://github.com/protocolbuffers/protobuf/releases/tag/v3.14.0中下载protoc-3.14.0-win64.zip，安装Protoc Compiler。
 * 也可以通过安maven plugin，根据.proto文件，生成java源文件。
 * <p>
 * cd serialize-demo
 * mv package
 * Mark Directory as Sources Root. /target/generated-sources/protobuf/java，然后在运行此main。
 * </p>
 *
 * 通过byte 字节流可以看出，几乎全是value，而没有field，至于value如何与field映射应该是借助生成的Person中的逻辑。
 */
public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Person person = Person.newBuilder().setName("Tom").setId(1).setEmail("tom@qq.com").addPhone(Demo.Person.PhoneNumber.newBuilder().setNumber("17756342322").setType(Demo.Person.PhoneType.MOBILE)).build();

        byte[] bytes = person.toByteArray();
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println("\n----------------------");

        for (byte b : bytes) {
            System.out.print((char) b + " ");
        }
        System.out.println("\n----------------------");

        for (byte b : bytes) {
            System.out.print(String.format("%8s", Integer.toBinaryString(b & 0xFF + 0x100)).replaceAll(" ", "0") + "(" + (b > (byte) 32 ? (char) b : String.valueOf(b)) + ")" + " ");
        }
        System.out.println("\n----------------------");

        Person p = Person.parseFrom(bytes);
        System.out.println(p);
    }

}
