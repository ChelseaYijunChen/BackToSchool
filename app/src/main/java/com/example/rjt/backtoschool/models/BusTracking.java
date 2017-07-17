package com.example.rjt.backtoschool.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yijunchen on 7/17/17.
 */

public class BusTracking {
    @SerializedName("UpdatedBusLocation")
    public List updatedBusLocation = new ArrayList();

    public class BusInfo{
        @SerializedName("TrackID")
        public Integer trackID;
        @SerializedName("RouteID")
        public Integer routeID;
        @SerializedName("DriverID")
        public Integer driverID;
        @SerializedName("BusID")
        public Integer busID;
        @SerializedName("UpdatedLattitude")
        public float updatedLatitude;
        @SerializedName("UpdatedLongtitude")
        public float updatedLongitude;
    }
}
