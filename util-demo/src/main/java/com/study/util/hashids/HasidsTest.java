package com.study.util.hashids;

import java.math.BigInteger;

import org.jasypt.encryption.BigIntegerEncryptor;
import org.jasypt.util.numeric.BasicIntegerNumberEncryptor;
import org.springframework.util.Assert;

public class HasidsTest {
    public static void main(String[] args) {
        test_issue45();
    }

    public static void test_issue45() {
        BasicIntegerNumberEncryptor encryptor = new BasicIntegerNumberEncryptor();
        encryptor.setPassword("123");
        BigInteger encryptInt = encryptor.encrypt(new BigInteger("111111111111111111111222222222222222222888888"));
        BigInteger oriInt = encryptor.decrypt(encryptInt);
        System.out.println(encryptInt);
        System.out.println(oriInt);
    }
}
