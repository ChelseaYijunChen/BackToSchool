package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class CurrentUser extends User{
    private static CurrentUser mInstant = null;
    public synchronized static CurrentUser getmInstant() {
        if (mInstant == null) {
            synchronized (CurrentUser.class) {
                if (mInstant == null) {
                    mInstant = new CurrentUser();
                }
            }
        }
        return mInstant;
    }
    private CurrentUser() {
    }
}
