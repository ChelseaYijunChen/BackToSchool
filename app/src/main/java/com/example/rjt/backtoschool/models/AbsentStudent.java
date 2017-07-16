package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class AbsentStudent extends Student {
    String absentDate;

    public AbsentStudent() {
        this.absentDate = "";
    }



    public AbsentStudent(int studentId, String studentName, String studentDOB, String studentMobile, String absentDate) {
        super(studentId, studentName, studentDOB, studentMobile);
        this.absentDate = absentDate;
    }

    public String getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(String absentDate) {
        this.absentDate = absentDate;
    }
}
