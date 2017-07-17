package com.example.rjt.backtoschool.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class User {

    @SerializedName("EmployeeName")
    private String empName;
    @SerializedName("EmployeeEmail")
    private String empEmail;
    @SerializedName("empFatherName")
    private String empFatherName;
    @SerializedName("empDesignation")
    private String empDesignation;
    @SerializedName("empDepartment")
    private String empDepartment;
    @SerializedName("empDob")
    private String empDob;
    @SerializedName("empGender")
    private String empGender;
    @SerializedName("empAddress")
    private String empAddress;
    @SerializedName("empMobile")
    private String empMobile;
    @SerializedName("empPassword")
    private String empPassword;
    @SerializedName("empPhoto")
    private String empPhoto;

    public User() {
        empEmail = "";
        empName = "";
        empFatherName = "";
        empDesignation = "";
        empDepartment = "";
        empDob = "";
        empGender = "";
        empAddress = "";
        empMobile = "";
        empPassword = "";
        empPhoto = "";
    }

    public User(String empEmail, String empName, String empFatherName, String empDesignation, String empDepartment, String empDob, String empGender, String empAddress, String empMobile, String empPassword, String empPhoto) {
        this.empEmail = empEmail;
        this.empName = empName;
        this.empFatherName = empFatherName;
        this.empDesignation = empDesignation;
        this.empDepartment = empDepartment;
        this.empDob = empDob;
        this.empGender = empGender;
        this.empAddress = empAddress;
        this.empMobile = empMobile;
        this.empPassword = empPassword;
        this.empPhoto = empPhoto;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpFatherName() {
        return empFatherName;
    }

    public void setEmpFatherName(String empFatherName) {
        this.empFatherName = empFatherName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpDob() {
        return empDob;
    }

    public void setEmpDob(String empDob) {
        this.empDob = empDob;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }


}
