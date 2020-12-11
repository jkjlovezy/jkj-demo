package com.study.hessian;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Arrays;

/**
 * 增加属性、减少属性都可以
 * 修改属性类型，看清款。int -> String 可以； int -> CustomObject 不可以。
 * Bean中可以没有getter/setter。
 * 默认配置序列化时，需要User implements java.io.Serializable， 若不想强制实现Serializable，设置SerializerFactory.setAllowNonSerializable(true)，
 * @see Hessian2Serializer
 * <p>
 * Hessian2Output ho = new Hessian2Output(bos);
 * SerializerFactory serializerFactory = new SerializerFactory();
 * serializerFactory.setAllowNonSerializable(true);
 * ho.setSerializerFactory(serializerFactory);
 * </p>
 */
public class HessianTest {
    public static void main(String[] args) throws IOException {
        User user = new User(120, "test1");
        byte[] bytes = Hessian2Serializer.INSTANCE.serialize(user);
        System.out.println(Arrays.toString(bytes));
        for (byte b : bytes) {
            System.out.print((char) b + " ");
        }
        System.out.println("\n----------------------");
        for (byte b : bytes) {
            System.out.print(String.format("%8s", Integer.toBinaryString(b & 0xFF + 0x100)).replaceAll(" ", "0") + "(" + (b > (byte) 32 ? (char) b :String.valueOf(b)) + ")" + " ");
        }
        System.out.println(new BASE64Encoder().encodeBuffer(bytes));//Qx5jb20uc3R1ZHkubmV0d29yay5oZXNzaWFuLlVzZXKSAmlkBG5hbWVgkQV0ZXN0MQ==

        byte[] oriBytes = new BASE64Decoder().decodeBuffer("Qx5jb20uc3R1ZHkubmV0d29yay5oZXNzaWFuLlVzZXKSAmlkBG5hbWVgkQV0ZXN0MQ==");
        Customer customer = Hessian2Deseiralizer.INSTANCE.deserialize(oriBytes, Customer.class);
        System.out.println(customer);
    }
}
