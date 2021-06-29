package com.study.util.mic;

/**
 * 相同字符串，每调用一次加密函数，得到的加密传都不一样。
 */
public class SignInEncryptHelperTest {
    public static void main(String[] args) {
        String s1 = "jkj@test.com!@#$%^&*()_+~=-";
        String encodeStr1 = "";
        System.out.println(encodeStr1 = SignInEncryptHelper.textEncryptor(s1));
        System.out.println(SignInEncryptHelper.textDecryptor(encodeStr1));


        System.out.println(encodeStr1 = SignInEncryptHelper.textEncryptor(s1));
        System.out.println(SignInEncryptHelper.textDecryptor(encodeStr1));
    }
}
