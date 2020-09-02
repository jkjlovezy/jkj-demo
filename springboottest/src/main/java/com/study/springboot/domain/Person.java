package com.study.springboot.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Person {
    @NotNull
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
