package com.example.rjt.backtoschool.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.fragments.AbsentStudentFragment;
import com.example.rjt.backtoschool.fragments.AllStudentsFragment;
import com.example.rjt.backtoschool.fragments.MainPageFragment;
import com.example.rjt.backtoschool.fragments.MapFragment;
import com.example.rjt.backtoschool.fragments.StudentAttendentDetailsFragment;

public class MainActivity extends AppCompatActivity {
    AbsentStudentFragment absentStudentFragment;
    AllStudentsFragment allStudentsFragment;
    StudentAttendentDetailsFragment studentAttendentDetailsFragment;
    MainPageFragment mainPageFragment;

    private ActionBarDrawerToggle toggle;
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        hideScrollBar();
        setActionBar();
        setDrawerToggle();
        setListener();

        absentStudentFragment = new AbsentStudentFragment();
        allStudentsFragment = new AllStudentsFragment();
        studentAttendentDetailsFragment = new StudentAttendentDetailsFragment();
        MapFragment mapFragment = MapFragment.newInstance();
        mainPageFragment = new MainPageFragment();
        //getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, absentStudentFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContent, mapFragment).commit();

    }

    private void initViews() {
        this.drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navigationview = (NavigationView) findViewById(R.id.navigation_view);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void hideScrollBar() {
        navigationview.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    private void setActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setDrawerToggle() {
        toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, 0, 0);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setListener() {
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.absent_student:
                        break;
                    case R.id.student_info:
                        break;
                    case R.id.bus_tracking:
                        break;
                    case R.id.school_info:
                        break;
                    case R.id.driver_info:
                        break;
                    case R.id.birthday:
                        break;
                }
                drawerlayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
