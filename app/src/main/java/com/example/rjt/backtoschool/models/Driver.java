package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/16/2017.
 */

public class Driver {
    String driverID;
    String driverName;
    String driverLicenceNo;
    String driverMobile;

    public Driver() {
        this.driverID = "";
        this.driverName = "";
        this.driverLicenceNo = "";
        this.driverMobile = "";
    }

    public Driver(String driverID, String driverName, String driverLicenceNo, String driverMobile) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.driverLicenceNo = driverLicenceNo;
        this.driverMobile = driverMobile;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLicenceNo() {
        return driverLicenceNo;
    }

    public void setDriverLicenceNo(String driverLicenceNo) {
        this.driverLicenceNo = driverLicenceNo;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }
}
