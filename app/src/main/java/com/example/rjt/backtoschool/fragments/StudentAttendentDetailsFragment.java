package com.example.rjt.backtoschool.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by zhangwenpurdue on 7/14/2017.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.models.StudentAttendentDetails;
import com.example.rjt.backtoschool.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by zhangwenpurdue on 7/13/2017.
 */

public class StudentAttendentDetailsFragment extends Fragment{
    JSONArray main;
    JSONObject mainobj;
    static StringBuilder BASE_URL = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_admin/student_attendance_detail.php?&studentID=101");
    String KEY = "101";
    String studentID = "&studentID=101";
    StudentAttendentDetails studentAttendentDetails;
    TextView studentDetailName, studentDetailID, studentDetailDate, studentDetailAttendence,
            studentDetailPickupTime, studentDetailPickupLocation, studentDetailPickupOut,
            studentDetailPickupOutLocation, studentDetailDropTime, studentDetailDropLocation;
    TextView achievement, complaint;
    Button sendAchievement, sendComplaint;
    Button addAchievement, addComplaint;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_attendent_details, container, false);
        //BASE_URL.append(studentID);
        studentAttendentDetails = new StudentAttendentDetails();
        initViews(view);
        fetchData();
        achievementManager();
        complaintManager();

        return view;
    }
    void initViews(View view) {
        studentDetailName = (TextView) view.findViewById(R.id.studentDetailName);
        studentDetailID = (TextView) view.findViewById(R.id.studentDetailID);
        studentDetailDate = (TextView) view.findViewById(R.id.studentDetailDate);
        studentDetailAttendence = (TextView) view.findViewById(R.id.studentDetailAttendence);
        studentDetailPickupTime = (TextView) view.findViewById(R.id.studentDetailPickupTime);
        studentDetailPickupLocation = (TextView) view.findViewById(R.id.studentDetailPickupLocation);
        studentDetailPickupOut = (TextView) view.findViewById(R.id.studentDetailPickupOut);
        studentDetailPickupOutLocation = (TextView) view.findViewById(R.id.studentDetailPickupOutLocation);
        studentDetailDropTime = (TextView) view.findViewById(R.id.studentDetailDropTime);
        studentDetailDropLocation = (TextView) view.findViewById(R.id.studentDetailDropLocation);

        achievement = (TextView) view.findViewById(R.id.achievement);
        complaint = (TextView) view.findViewById(R.id.complaint);
        addAchievement = (Button) view.findViewById(R.id.addAchievement);
        addComplaint = (Button) view.findViewById(R.id.addComplaint);
        sendAchievement = (Button) view.findViewById(R.id.sendAchievement);
        sendComplaint = (Button) view.findViewById(R.id.sendComplaint);
    }
    void achievementManager() {
        addAchievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAchievementToDatabase();
            }
        });

    }

    void complaintManager() {
        addComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addComplaintToDatabase();
            }
        });


    }
    void addAchievementToDatabase() {
        StringBuilder URL = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_admin/add_achievement.php?");
        String id = "&studentID=" + KEY;
        String achieve = "&achievement=" + achievement.getText();
        URL.append(id);
        URL.append(achieve);
        Toast.makeText(getContext(), URL.toString(), Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Add achievement")) {
                    Toast.makeText(getContext(), "Success!", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest);
    }

    void addComplaintToDatabase() {
        StringBuilder URL = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_admin/add_complaint.php?");
        String id = "&studentID=" + KEY;
        String comp = "&complaint=" + complaint.getText();
        URL.append(id);
        URL.append(comp);
        Toast.makeText(getContext(), URL.toString(), Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Add complaint")) {
                    Toast.makeText(getContext(), "Success!", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest);
    }


    public void sendSMS(String phoneNumber, String message) {
        // 获取短信管理器
        android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
        // 拆分短信内容（手机短信长度限制）
        List<String> divideContents = smsManager.divideMessage(message);
        for (String text : divideContents) {
            smsManager.sendTextMessage(phoneNumber, null, text, null, null);
        }
    }
    void fetchData() {
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    main = new JSONArray(response);
                    mainobj = main.getJSONObject(0);
                    studentAttendentDetails.setStudentId(Integer.parseInt(KEY));
                    if(mainobj.has("StudentName"))
                    {
                        String name =mainobj.getString("StudentName");
                        studentAttendentDetails.setStudentName(name);
                    }
                    if(mainobj.has("Date"))
                    {
                        String date = mainobj.getString("Date");
                        studentAttendentDetails.setmDate(date);


                    }
                     if(mainobj.has("AttendaceStatus"))
                    {
                        String status = mainobj.getString("AttendaceStatus");
                        studentAttendentDetails.setmAttendaceStatus(status);
                    }
                    if(mainobj.has("PickUpTime"))
                    {
                        String pickUpTime = mainobj.getString("PickUpTime");
                        studentAttendentDetails.setmPickUpTime(pickUpTime);
                    }
                    if(mainobj.has("PickUpLocation"))
                    {
                        String pickUpLocation = mainobj.getString("PickUpLocation");
                        studentAttendentDetails.setmPickUpOutLocation(pickUpLocation);

                    }
                    if(mainobj.has("PickUpOut"))
                    {
                        String pickUpOut = mainobj.getString("PickUpOut");
                        studentAttendentDetails.setmPickUpOut(pickUpOut);
                    }
                    if(mainobj.has("PickUpOutLocation"))
                    {
                        String pickUpOutLocation = mainobj.getString("PickUpOutLocation");
                        studentAttendentDetails.setmPickUpOutLocation(pickUpOutLocation);
                    }
                    if(mainobj.has("DropTime"))
                    {
                        String dropTime = mainobj.getString("DropTime");
                        studentAttendentDetails.setmDropTime(dropTime);
                    }
                    if(mainobj.has("DropLocation"))
                    {
                        String dropLocation = mainobj.getString("DropLocation");
                        studentAttendentDetails.setmDropLocation(dropLocation);
                    }
                    bindDataWithView();
                    Toast.makeText(getContext(), studentAttendentDetails.getmPickUpLocation(),Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
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


    void bindDataWithView() {
        studentDetailName.setText(studentAttendentDetails.getStudentName());
        studentDetailID.setText(studentAttendentDetails.getStudentId() + "");
        studentDetailDate.setText(studentAttendentDetails.getmDate());
        studentDetailAttendence.setText(studentAttendentDetails.getmAttendaceStatus());
        studentDetailPickupTime.setText(studentAttendentDetails.getmPickUpTime());
        studentDetailPickupLocation.setText(studentAttendentDetails.getmPickUpLocation());
        studentDetailPickupOut.setText(studentAttendentDetails.getmPickUpOut());
        studentDetailPickupOutLocation.setText(studentAttendentDetails.getmPickUpOutLocation());
        studentDetailDropTime.setText(studentAttendentDetails.getmDropTime());
        studentDetailDropLocation.setText(studentAttendentDetails.getmDropLocation());
    }
}
