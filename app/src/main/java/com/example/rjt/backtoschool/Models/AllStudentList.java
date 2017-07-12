package com.example.rjt.backtoschool.Models;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class AllStudentList extends ArrayList<Student> {
    private static AllStudentList mInstance = null;
    public synchronized static AllStudentList getmInstance() {
        if (mInstance == null) {
            synchronized (AllStudentList.class) {
                if (mInstance == null) {
                    mInstance = new AllStudentList();
                }
            }
        }
        return mInstance;
    }
    private AllStudentList() {

    }
    private void test() {

    }
}
