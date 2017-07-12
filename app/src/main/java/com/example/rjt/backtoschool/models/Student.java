package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class Student {
    int studentId;
    String studentName;

    public Student() {
    }



    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
