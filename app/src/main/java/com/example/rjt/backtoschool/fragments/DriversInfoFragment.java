package com.example.rjt.backtoschool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.adapters.DriversInfoAdapter;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.models.Driver;
import com.example.rjt.backtoschool.models.DriversList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class DriversInfoFragment extends Fragment {
    RecyclerView mRecyclerView;
    StringBuilder URL = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_admin/driver_information.php?0");
    String ROUTE_ID_KEY = "&route_id=101";
    String BUS_ID_KEY = "&bus_id=103";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driver_info, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.driverInfoRecyclerView);
        URL.append(ROUTE_ID_KEY);
        URL.append(BUS_ID_KEY);
        fetchData();
        return view;
    }

    void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray categories = new JSONObject(response).getJSONArray("Drivers");

                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        Driver driver = new Driver();
                        if (item.has("DriverID")) {
                            String id = item.getString("DriverID");
                            driver.setDriverID(id);

                        }
                        if (item.has("DriverName")) {
                            String name = item.getString("DriverName");
                            driver.setDriverName(name);

                        }
                        if (item.has("DriverLicenceNo")) {
                            String no = item.getString("DriverLicenceNo");
                            driver.setDriverLicenceNo(no);

                        }
                        if (item.has("DriverMobile")) {
                            String mobile = item.getString("DriverMobile");
                            driver.setDriverMobile(mobile);

                        }
                        DriversList.getmInstance().add(driver);

                    }

                    mRecyclerView.setAdapter(new DriversInfoAdapter());
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("test", "exception");
                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest);
    }
}
