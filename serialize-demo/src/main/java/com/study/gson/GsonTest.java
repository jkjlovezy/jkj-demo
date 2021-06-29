package com.study.gson;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();
        final String jsonStr = getJsonStr();
        System.out.println(String.format("jsonStr:%s", jsonStr));
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    User user = gson.fromJson(jsonStr, User.class);
                    System.out.println(String.format("str1=%s\t threadId=%s",user.getStr1(),Thread.currentThread().getId()));
                }
            }));
        }
        threadList.forEach(t -> t.start());
    }

    private static String getJsonStr() {
        User user = new User();
        user.setStr1("11111111111111111111111");
        user.setStr2("22222222222222222222222");
        user.setStr3("33333333333333333333333333");
        user.setStr4("44444444444444444444444444444444");
        user.setStr5("5555555555555555555555555555555555555");
        user.setStr6("6666666666666666666666666666666666666666666666666666");
        user.setStr7("77777777777777777777777777777777777777777777777");
        user.setStr8("88888888888888888888888888888888888888888888888888888888888888");
        user.setStr9("99999999999999999999999999999999999999999999999999999999999");
        user.setStr10("101010101010101010101010101010101010");
        user.setStr11("11111111111111111111111111111111111111111111111111");
        user.setStr12("1212121212121212121212121212121212121212121212121212121212121212");
        user.setStr13("1313131313131313131313131313131313131313131313131313131313131313131313");
        user.setStr14("1414141414141414141414141414141414141414141414141414141414141414141414");
        user.setStr15("15151515151515151515151515151515151515151515151515151515151515151515151515151515");
        user.setStr16("16161616161616161616161616161616161616161616161616161616161616161616161616161616");
        user.setStr17("1717171717171717171717171717171717171717171717171717171717171717171717");
        user.setStr18("181818181818181818181818181818181818181818181818181818181818181818181818181818181818181818");
        user.setStr19("1919191919191919191919191919");
        user.setDate1(new Date());
        user.setDate2(new Date());
        return new Gson().toJson(user);
    }

    @Data
    public static class User {
        private String str1;
        private String str2;
        private String str3;
        private String str4;
        private String str5;
        private String str6;
        private String str7;
        private String str8;
        private String str9;
        private String str10;
        private String str11;
        private String str12;
        private String str13;
        private String str14;
        private String str15;
        private String str16;
        private String str17;
        private String str18;
        private String str19;
        private Date date1;
        private Date date2;
    }
}
