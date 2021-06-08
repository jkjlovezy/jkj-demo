package com.study.util.mic;

import java.util.ArrayList;
import java.util.List;

import com.study.util.mic.EncryptUtil;

public class EncryptUtilTest {
    public static void main(String[] args) {
        System.out.println(EncryptUtil.encode(88961L));
        System.out.println(EncryptUtil.decode("WZAfKUpEtwMV"));
        System.out.println(EncryptUtil.encode(12L));

        List<String> list = new ArrayList<>();
        list.add(EncryptUtil.encode(11L));
        list.add(EncryptUtil.encode(12L));
        list.add(EncryptUtil.encode(13L));
        EncryptUtil.decodeMulti2LongList(list).forEach(System.out::println);

    }
}
