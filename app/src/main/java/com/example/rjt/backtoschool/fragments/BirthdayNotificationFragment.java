package com.example.rjt.backtoschool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.adapters.BirthdayNotificationAdapter;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.models.StudentBirthday;
import com.example.rjt.backtoschool.models.StudentBirthdayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class BirthdayNotificationFragment extends Fragment {
    String URL = "http://rjtmobile.com/aamir/school-mgt/school_admin/students_birthday.php?";
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_birthday_notification, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.birthdayNotificationRecyclerView);
        fetchData();
        return view;
    }
    void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray birthdays = new JSONObject(response).getJSONArray("Birthday Date");

                    for (int i = 0; i < birthdays.length(); i++) {
                        JSONObject item = birthdays.getJSONObject(i);
                        StudentBirthday studentBirthday = new StudentBirthday();
                        Toast.makeText(getContext(),  item.toString(), Toast.LENGTH_SHORT).show();
                        if (item.has("StudentName")) {
                            String name = item.getString("StudentName");
                            studentBirthday.setName(name);

                        }
                        if (item.has("StudentDOB")) {
                            String dob = item.getString("StudentDOB");
                            studentBirthday.setBirthDay(dob);
                        }
                        if (item.has("StudentMobile")) {
                            String mobile = item.getString("StudentMobile");
                            studentBirthday.setPhoneNumber(mobile);
                        }
                        StudentBirthdayList.getmInstance().add(studentBirthday);
                    }
                    mRecyclerView.setAdapter(new BirthdayNotificationAdapter());
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest);
    }
}
