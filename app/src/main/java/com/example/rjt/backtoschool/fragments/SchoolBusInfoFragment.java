package com.example.rjt.backtoschool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.rjt.backtoschool.adapters.AllStudentsAdapter;
import com.example.rjt.backtoschool.adapters.SchoolBusInfoAdapter;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.models.AllStudentList;
import com.example.rjt.backtoschool.models.Student;
import com.example.rjt.backtoschool.models.Vehicle;
import com.example.rjt.backtoschool.models.VehiclesList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class SchoolBusInfoFragment extends Fragment {
    String URL = "http://rjtmobile.com/aamir/school-mgt/school_admin/vehicles.php?";
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_school_bus_info, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.schoolBusInfoRecyclerView);
        fetchData();
        return view;
    }


    void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray categories = new JSONObject(response).getJSONArray("Vehicle List");

                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        Vehicle vehicle = new Vehicle();
                        if (item.has("VehicleID")) {
                            String id = item.getString("VehicleID");
                            vehicle.setVehicleID(id);

                        }
                        if (item.has("VehicleCode")) {
                            String code = item.getString("VehicleCode");
                            vehicle.setVehicleCode(code);

                        }
                        if (item.has("VehicleNo")) {
                            String no = item.getString("VehicleNo");
                            vehicle.setVehicleNo(no);

                        }
                        if (item.has("VehicleRoute")) {
                            String route = item.getString("VehicleRoute");
                            vehicle.setVehicleRoute(route);

                        }
                        VehiclesList.getmInstance().add(vehicle);

                    }





                    mRecyclerView.setAdapter(new SchoolBusInfoAdapter());
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
