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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.adapters.AbsentStudentsAdapter;
import com.example.rjt.backtoschool.adapters.AllStudentsAdapter;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.models.AbsentStudent;
import com.example.rjt.backtoschool.models.AbsentStudentsList;
import com.example.rjt.backtoschool.models.AllStudentList;
import com.example.rjt.backtoschool.models.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangwenpurdue on 7/12/2017.
 */

public class AbsentStudentFragment extends Fragment {
    RecyclerView mRecyclerView;
    String BASE_URL = "http://rjtmobile.com/aamir/school-mgt/school_admin/student_attendance.php?";
    TextView back;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_absent_student,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.absentRecycleView);
        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.mainContent, new AllStudentsFragment()).commit();
            }
        });
        fetchData();
        return view;
    }

    void fetchData() {
        AbsentStudentsList.getmInstance().clear();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray absentStudents = new JSONObject(response).getJSONArray("Absent Student List");

                    for (int i = 0; i < absentStudents.length(); i++) {
                        JSONObject item = absentStudents.getJSONObject(i);
                        AbsentStudent absentStudent = new AbsentStudent();
                        if (item.has("StudentID")) {
                            String id = item.getString("StudentID");
                            absentStudent.setStudentId(Integer.parseInt(id));
                        }
                        if (item.has("StudentName")) {
                            String name = item.getString("StudentName");
                            absentStudent.setStudentName(name);

                        }
                        if (item.has("Date")) {
                            String date = item.getString("Date");
                            absentStudent.setAbsentDate(date);

                        }
                        AbsentStudentsList.getmInstance().add(absentStudent);

                    }





                    mRecyclerView.setAdapter(new AbsentStudentsAdapter(getActivity()));
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
