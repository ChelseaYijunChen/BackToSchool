package com.example.rjt.backtoschool.models;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/16/2017.
 */

public class DriversList extends ArrayList<Driver> {
    private static DriversList mInstance = null;
    public synchronized static DriversList getmInstance() {
        if (mInstance == null) {
            synchronized ((DriversList.class)) {
                if (mInstance == null) {
                    mInstance = new DriversList();
                }
            }
        }
        return mInstance;
    }
    private DriversList() {

    }
}
