package com.example.rjt.backtoschool.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.fragments.AbsentStudentFragment;
import com.example.rjt.backtoschool.fragments.AllStudentsFragment;
import com.example.rjt.backtoschool.fragments.MainPageFragment;
import com.example.rjt.backtoschool.fragments.MapFragment;
import com.example.rjt.backtoschool.fragments.StudentAttendentDetailsFragment;
import com.example.rjt.backtoschool.models.MainPageItem;

public class MainActivity extends AppCompatActivity {
    AbsentStudentFragment absentStudentFragment;
    AllStudentsFragment allStudentsFragment;
    StudentAttendentDetailsFragment studentAttendentDetailsFragment;
    MainPageFragment mainPageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        absentStudentFragment = new AbsentStudentFragment();
        allStudentsFragment = new AllStudentsFragment();
        studentAttendentDetailsFragment = new StudentAttendentDetailsFragment();
        MapFragment mapFragment = MapFragment.newInstance();
        mainPageFragment = new MainPageFragment();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, absentStudentFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, mapFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, allStudentsFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, studentAttendentDetailsFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, mainPageFragment).commit();

    }





}
