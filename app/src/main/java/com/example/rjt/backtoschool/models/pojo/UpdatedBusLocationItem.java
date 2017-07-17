package com.example.rjt.backtoschool.models.pojo;

import com.google.gson.annotations.SerializedName;

public class UpdatedBusLocationItem {

    @SerializedName("UpdatedLongtitude")
    private String updatedLongtitude;

    @SerializedName("DriverID")
    private String driverID;

    @SerializedName("BusID")
    private String busID;

    @SerializedName("RouteID")
    private String routeID;

    @SerializedName("UpdatedLattitude")
    private String updatedLattitude;

    @SerializedName("TrackID")
    private String trackID;

    public void setUpdatedLongtitude(String updatedLongtitude) {
        this.updatedLongtitude = updatedLongtitude;
    }

    public String getUpdatedLongtitude() {
        return updatedLongtitude;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getBusID() {
        return busID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setUpdatedLattitude(String updatedLattitude) {
        this.updatedLattitude = updatedLattitude;
    }

    public String getUpdatedLattitude() {
        return updatedLattitude;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }

    public String getTrackID() {
        return trackID;
    }

    @Override
    public String toString() {
        return
                "UpdatedBusLocationItem{" +
                        "updatedLongtitude = '" + updatedLongtitude + '\'' +
                        ",driverID = '" + driverID + '\'' +
                        ",busID = '" + busID + '\'' +
                        ",routeID = '" + routeID + '\'' +
                        ",updatedLattitude = '" + updatedLattitude + '\'' +
                        ",trackID = '" + trackID + '\'' +
                        "}";
    }
}