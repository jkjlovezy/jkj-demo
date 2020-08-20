package com.study.util.mapstruct;

public class User2 {
    private String user_name;
    private int user_age;

    public User2(){}

    public User2(String user_name, int user_age) {
        this.user_name = user_name;
        this.user_age = user_age;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_age=" + user_age +
                '}';
    }
}
