package com.example.rjt.backtoschool.rest;

import com.example.rjt.backtoschool.models.BusTracking;
import com.example.rjt.backtoschool.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yijunchen on 7/17/17.
 */

public interface ApiInterface {
    @GET("school_parents_app/school_bus_track.php?")
    Call<BusTracking> getBusLocation(@Query("route_id") String routeID);

    @GET("school_admin/emp_login.php?")
    Call<ResponseBody> loginCheck(@Query("empEmail") String email, @Query("empPassword") String password);
}
