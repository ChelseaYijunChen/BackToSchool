package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class MainPageItem {
    int itempPicPosition;
    String itemName;

    public MainPageItem() {
        this.itemName = "";
        this.itempPicPosition = 0;
    }

    public MainPageItem(int itempPicPosition, String itemName) {
        this.itempPicPosition = itempPicPosition;
        this.itemName = itemName;
    }

    public int getItempPicPosition() {
        return itempPicPosition;
    }

    public void setItempPicPosition(int itempPicPosition) {
        this.itempPicPosition = itempPicPosition;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
