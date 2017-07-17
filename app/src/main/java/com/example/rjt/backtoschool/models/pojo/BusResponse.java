package com.example.rjt.backtoschool.models.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BusResponse {

    @SerializedName("UpdatedBusLocation")
    private List<UpdatedBusLocationItem> updatedBusLocation;

    public void setUpdatedBusLocation(List<UpdatedBusLocationItem> updatedBusLocation) {
        this.updatedBusLocation = updatedBusLocation;
    }

    public List<UpdatedBusLocationItem> getUpdatedBusLocation() {
        return updatedBusLocation;
    }

    @Override
    public String toString() {
        return
                "BusResponse{" +
                        "updatedBusLocation = '" + updatedBusLocation + '\'' +
                        "}";
    }
}