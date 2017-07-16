package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class Student {
    int studentId;
    String studentName;
    String StudentDOB;
    String StudentMobile;

    public Student() {
        this.studentId = 0;
        this.StudentDOB = "";
        this.StudentMobile = "";
        this.studentName = "";
    }

    public Student(int studentId, String studentName, String studentDOB, String studentMobile) {
        this.studentId = studentId;
        this.studentName = studentName;
        StudentDOB = studentDOB;
        StudentMobile = studentMobile;
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

    public String getStudentDOB() {
        return StudentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        StudentDOB = studentDOB;
    }

    public String getStudentMobile() {
        return StudentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        StudentMobile = studentMobile;
    }
}
