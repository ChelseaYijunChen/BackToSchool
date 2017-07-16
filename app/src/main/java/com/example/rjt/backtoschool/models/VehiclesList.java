package com.example.rjt.backtoschool.models;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/16/2017.
 */

public class VehiclesList extends ArrayList<Vehicle> {
    private static VehiclesList mInstance = null;
    public synchronized static VehiclesList getmInstance() {
        if (mInstance == null) {
            synchronized ((VehiclesList.class)) {
                if (mInstance == null) {
                    mInstance = new VehiclesList();
                }
            }
        }
        return mInstance;
    }
    private VehiclesList() {

    }
}
