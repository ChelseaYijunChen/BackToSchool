package com.example.rjt.backtoschool.rest;

import com.example.rjt.backtoschool.models.BusTracking;
import com.example.rjt.backtoschool.models.User;

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

    @GET("movie/{id}")
    Call<User> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
