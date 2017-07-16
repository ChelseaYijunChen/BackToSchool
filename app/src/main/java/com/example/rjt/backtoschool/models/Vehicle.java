package com.example.rjt.backtoschool.models;

/**
 * Created by zhangwenpurdue on 7/16/2017.
 */

public class Vehicle {
    String vehicleID;
    String vehicleCode;
    String vehicleNo;
    String vehicleRoute;

    public Vehicle() {
        this.vehicleID = "";
        this.vehicleCode = "";
        this.vehicleNo = "";
        this.vehicleRoute = "";
    }

    public Vehicle(String vehicleID, String vehicleCode, String vehicleNo, String vehicleRoute) {
        this.vehicleID = vehicleID;
        this.vehicleCode = vehicleCode;
        this.vehicleNo = vehicleNo;
        this.vehicleRoute = vehicleRoute;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(String vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }
}
