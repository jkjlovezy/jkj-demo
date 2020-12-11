package com.study.hessian;

public class User implements java.io.Serializable{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
