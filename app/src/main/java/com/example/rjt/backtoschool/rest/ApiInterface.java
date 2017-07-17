package com.example.rjt.backtoschool.rest;

import com.example.rjt.backtoschool.models.pojo.BusResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yijunchen on 7/17/17.
 */

public interface ApiInterface {
    @GET("school_parents_app/school_bus_track.php?")
    Call<BusResponse> getBusLocation(@Query("route_id") String routeID);

    @GET("school_admin/emp_login.php?")
    Call<ResponseBody> loginCheck(@Query("empEmail") String email, @Query("empPassword") String password);

    @GET("school_admin/emp_reg.php?")
    Call<ResponseBody> register(@Query("empEmail") String email, @Query("empName") String name,
                                @Query("empFatherName")String fatherName, @Query("empDesignation")String designation,
                                @Query("empDepartment") String department, @Query("empDob") String dob,
                                @Query("empGender") String gender, @Query("empAddress") String address,
                                @Query("empMobile") String mobile, @Query("empPassword") String password,
                                @Query("empPhoto") String photoUrl);
}
