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
import com.example.rjt.backtoschool.adapters.AllStudentsAdapter;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.models.AllStudentList;
import com.example.rjt.backtoschool.models.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangwenpurdue on 7/14/2017.
 */

public class AllStudentsFragment extends Fragment {
    static String BASE_URL = "http://rjtmobile.com/aamir/school-mgt/school_admin/all_student.php?";
    RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_all_students, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.allStudentRecyclerView);
        Toast.makeText(getContext(), AllStudentList.getmInstance().size() + "", Toast.LENGTH_SHORT).show();
        fetchData();
        return view;
    }

    void fetchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray categories = new JSONObject(response).getJSONArray("All Students");

                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        Student student = new Student();
                        if (item.has("StudentID")) {
                            String id = item.getString("StudentID");
                            student.setStudentId(Integer.parseInt(id));

                        }
                        if (item.has("StudentName")) {
                            String name = item.getString("StudentName");
                            student.setStudentName(name);

                        }
                        AllStudentList.getmInstance().add(student);

                    }





                    mRecyclerView.setAdapter(new AllStudentsAdapter(getActivity()));
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

