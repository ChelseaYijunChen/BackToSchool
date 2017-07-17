package com.example.rjt.backtoschool.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.fragments.AbsentStudentFragment;
import com.example.rjt.backtoschool.fragments.AllStudentsFragment;
import com.example.rjt.backtoschool.fragments.BirthdayNotificationFragment;
import com.example.rjt.backtoschool.fragments.DriversInfoFragment;
import com.example.rjt.backtoschool.fragments.MainPageFragment;
import com.example.rjt.backtoschool.fragments.MapFragment;
import com.example.rjt.backtoschool.fragments.SchoolBusInfoFragment;
import com.example.rjt.backtoschool.fragments.StudentAttendentDetailsFragment;
import com.example.rjt.backtoschool.models.MainPageItem;

public class MainActivity extends AppCompatActivity {
    AbsentStudentFragment absentStudentFragment;
    AllStudentsFragment allStudentsFragment;
    SchoolBusInfoFragment schoolBusInfoFragment;
    DriversInfoFragment driversInfoFragment;
    BirthdayNotificationFragment birthdayNotificationFragment;
    MapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        absentStudentFragment = new AbsentStudentFragment();
        allStudentsFragment = new AllStudentsFragment();
        schoolBusInfoFragment = new SchoolBusInfoFragment();
        driversInfoFragment = new DriversInfoFragment();
        birthdayNotificationFragment = new BirthdayNotificationFragment();
        mapFragment = MapFragment.newInstance();

       // getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, absentStudentFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, allStudentsFragment).commit();
       // getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, birthdayNotificationFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, absentStudentFragment).commit();
       // getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, mapFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, schoolBusInfoFragment).commit();


    }





}
