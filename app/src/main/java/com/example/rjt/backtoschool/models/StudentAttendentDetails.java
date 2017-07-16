package com.example.rjt.backtoschool.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by zhangwenpurdue on 7/14/2017.
 */

public class StudentAttendentDetails extends Student {
    String mDate;
    String mAttendaceStatus;
    String mPickUpTime;
    String mPickUpLocation;
    String mPickUpOut;
    String mPickUpOutLocation;
    String mDropTime;
    String mDropLocation;

    public StudentAttendentDetails() {
        this.mDate = getDate();
        this.mAttendaceStatus = "P";
        this.mPickUpTime = "";
        this.mPickUpLocation = "";
        this.mPickUpOut = "";
        this.mPickUpOutLocation = "";
        this.mDropTime = "";
        this.mDropLocation = "";
    }
    public StudentAttendentDetails(int studentId, String studentName, String studentDOB, String studentMobile, String mDate, String mAttendaceStatus, String mPickUpTime, String mPickUpLocation, String mPickUpOut, String mPickUpOutLocation, String mDropTime, String mDropLocation) {
        super(studentId, studentName, studentDOB, studentMobile);
        this.mDate = mDate;
        this.mAttendaceStatus = mAttendaceStatus;
        this.mPickUpTime = mPickUpTime;
        this.mPickUpLocation = mPickUpLocation;
        this.mPickUpOut = mPickUpOut;
        this.mPickUpOutLocation = mPickUpOutLocation;
        this.mDropTime = mDropTime;
        this.mDropLocation = mDropLocation;
    }



    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmAttendaceStatus() {
        return mAttendaceStatus;
    }

    public void setmAttendaceStatus(String mAttendaceStatus) {
        this.mAttendaceStatus = mAttendaceStatus;
    }

    public String getmPickUpTime() {
        return mPickUpTime;
    }

    public void setmPickUpTime(String mPickUpTime) {
        this.mPickUpTime = mPickUpTime;
    }

    public String getmPickUpLocation() {
        return mPickUpLocation;
    }

    public void setmPickUpLocation(String mPickUpLocation) {
        this.mPickUpLocation = mPickUpLocation;
    }

    public String getmPickUpOut() {
        return mPickUpOut;
    }

    public void setmPickUpOut(String mPickUpOut) {
        this.mPickUpOut = mPickUpOut;
    }

    public String getmPickUpOutLocation() {
        return mPickUpOutLocation;
    }

    public void setmPickUpOutLocation(String mPickUpOutLocation) {
        this.mPickUpOutLocation = mPickUpOutLocation;
    }

    public String getmDropTime() {
        return mDropTime;
    }

    public void setmDropTime(String mDropTime) {
        this.mDropTime = mDropTime;
    }

    public String getmDropLocation() {
        return mDropLocation;
    }

    public void setmDropLocation(String mDropLocation) {
        this.mDropLocation = mDropLocation;
    }

    @Override
    public String getStudentName() {
        return super.getStudentName();
    }

    @Override
    public int getStudentId() {
        return super.getStudentId();
    }

    @Override
    public void setStudentId(int studentId) {
        super.setStudentId(studentId);
    }

    @Override
    public void setStudentName(String studentName) {
        super.setStudentName(studentName);
    }

    private String getDate(){
        DateFormat dfDate = new SimpleDateFormat("yyyy/MM/dd");
        String date=dfDate.format(Calendar.getInstance().getTime());
        return date;
    }
}

