package com.example.rjt.backtoschool.models;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class AbsentStudentsList extends ArrayList<AbsentStudent>{
    private static AbsentStudentsList mInstance = null;
    public synchronized static AbsentStudentsList getmInstance() {
        if (mInstance == null) {
            synchronized ((AbsentStudentsList.class)) {
                if (mInstance == null) {
                    mInstance = new AbsentStudentsList();
                }
            }
        }
        return mInstance;
    }
    private AbsentStudentsList() {

    }
}
