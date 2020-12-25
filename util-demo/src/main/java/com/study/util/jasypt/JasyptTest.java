package com.study.util.jasypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.study.util.ip.Constants;

public class JasyptTest {
    public static void main(String[] args) {
        System.out.println("hello world1:\t" + JaspterHelper.textEncryptor("hello world"));
        System.out.println("hello world2:\t" + JaspterHelper.textEncryptor("hello world"));
        System.out.println(JaspterHelper.textDecryptor("OXZmUVpYZnV2ekc4Snc4SzdwZWFaUT09"));
        System.out.println(JaspterHelper.textDecryptor(urlDecode("ZjgxNXVMOGRNaUJPNCtCYm5idjlEZEpGK2UxZmppV0RhaXhnTGxNVnp0ND0%3D")));
        System.out.println("hello world3:\t" + JaspterHelper.textEncryptor2("hello world"));
        System.out.println("hello world4:\t" + JaspterHelper.textEncryptor2("hello world"));

        System.out.println(JaspterHelper.textDecryptor2("jbsrWOAlFFZX3dI1dhxW0pYXdsOLWr44"));
        System.out.println(JaspterHelper.textDecryptor2("bQo85KfwnbTJxgQQKE1B5/DD0TKlAZvT"));
    }

    private static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, Constants.CODING_FORMAT_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("url decode error");
        }
    }
}
