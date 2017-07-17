package com.example.rjt.backtoschool.models;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class StudentBirthdayList extends ArrayList<StudentBirthday> {
    private static StudentBirthdayList mInstance = null;
    public synchronized static StudentBirthdayList getmInstance() {
        if (mInstance == null) {
            synchronized ((StudentBirthdayList.class)) {
                if (mInstance == null) {
                    mInstance = new StudentBirthdayList();
                }
            }
        }
        return mInstance;
    }
    private StudentBirthdayList() {

    }
}
