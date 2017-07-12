package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class AbsentStudent extends Student {
    String absentDate;

    public AbsentStudent() {
    }

    public AbsentStudent(int studentId, String studentName, String absentDate) {
        super(studentId, studentName);
        this.absentDate = absentDate;
    }

    public String getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(String absentDate) {
        this.absentDate = absentDate;
    }
}
