package com.study.util.mapstruct;

public class User {
    private String user_name;
    private int user_age;
    private String address;

    public User(String user_name, int user_age, String address) {
        this.user_name = user_name;
        this.user_age = user_age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", user_age=" + user_age +
                ", address='" + address + '\'' +
                '}';
    }
}
