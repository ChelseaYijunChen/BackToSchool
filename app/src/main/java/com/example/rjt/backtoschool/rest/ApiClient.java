package com.example.rjt.backtoschool.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yijunchen on 7/14/17.
 */

public class ApiClient {
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://rjtmobile.com/aamir/school-mgt/";

    public static Retrofit getClient() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
