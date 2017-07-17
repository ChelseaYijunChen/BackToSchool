package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class StudentBirthday {
    String name;
    String birthDay;
    String phoneNumber;

    public StudentBirthday() {
        this.name = "";
        this.birthDay = "";
        this.phoneNumber = "";
    }

    public StudentBirthday(String name, String birthDay, String phoneNumber) {
        this.name = name;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
