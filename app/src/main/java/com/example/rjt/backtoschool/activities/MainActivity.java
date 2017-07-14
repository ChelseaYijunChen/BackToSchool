package com.example.rjt.backtoschool.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.fragments.AbsentStudentFragment;
import com.example.rjt.backtoschool.fragments.AllStudentsFragment;

public class MainActivity extends AppCompatActivity {
    AbsentStudentFragment absentStudentFragment;
    AllStudentsFragment allStudentsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        absentStudentFragment = new AbsentStudentFragment();
        allStudentsFragment = new AllStudentsFragment();
        //studentAttendentDetailsFragment = new StudentAttendentDetailsFragment();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, absentStudentFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, allStudentsFragment).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, studentAttendentDetailsFragment).commit();

    }




}
