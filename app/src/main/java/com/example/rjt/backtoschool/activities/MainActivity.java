package com.example.rjt.backtoschool.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
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
import com.example.rjt.backtoschool.fragments.BirthdayNotificationFragment;
import com.example.rjt.backtoschool.fragments.DriversInfoFragment;
import com.example.rjt.backtoschool.fragments.MainPageFragment;
import com.example.rjt.backtoschool.fragments.MapFragment;
import com.example.rjt.backtoschool.fragments.SchoolBusInfoFragment;
import com.example.rjt.backtoschool.fragments.StudentAttendentDetailsFragment;

public class MainActivity extends AppCompatActivity {
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

        /* default fragment */
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container, new MainPageFragment()).commit();

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
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.absent_student:
                        fragment = new AbsentStudentFragment();
                        break;
                    case R.id.student_info:
                        fragment = new AllStudentsFragment();
                        break;
                    case R.id.bus_tracking:
                        fragment = new MapFragment();
                        break;
                    case R.id.school_info:
                        fragment = new SchoolBusInfoFragment();
                        break;
                    case R.id.driver_info:
                        fragment = new DriversInfoFragment();
                        break;
                    case R.id.birthday:
                        fragment = new BirthdayNotificationFragment();
                        break;
                }
                if (fragment == null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_fragment_container, new MainPageFragment()).commit();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_fragment_container, fragment).commit();
                }
                drawerlayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}
