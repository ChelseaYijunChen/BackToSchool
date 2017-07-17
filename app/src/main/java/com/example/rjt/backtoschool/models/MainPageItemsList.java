package com.example.rjt.backtoschool.models;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class MainPageItemsList extends ArrayList<MainPageItem> {
    private static MainPageItemsList mInstance = null;
    public synchronized static MainPageItemsList getmInstance() {
        if (mInstance == null) {
            synchronized ((MainPageItemsList.class)) {
                if (mInstance == null) {
                    mInstance = new MainPageItemsList();
                }
            }
        }
        return mInstance;
    }
    private MainPageItemsList() {

    }
}
