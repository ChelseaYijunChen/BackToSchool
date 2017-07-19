package com.example.rjt.backtoschool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rjt.backtoschool.R;;

/**
 * Created by yijunchen on 7/16/2017.
 */

public class HomePageFragment extends Fragment {
    CardView absent_stu, student_info, school_bus_tracking, school_bus_info, driver_info, birthday;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        absent_stu = (CardView) view.findViewById(R.id.cardView1);
        absent_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fragment_container, new AbsentStudentFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        student_info = (CardView) view.findViewById(R.id.cardView2);
        student_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fragment_container, new AllStudentsFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        school_bus_tracking = (CardView) view.findViewById(R.id.cardView3);
        school_bus_tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fragment_container, new MapFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        school_bus_info = (CardView) view.findViewById(R.id.cardView4);
        school_bus_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fragment_container, new SchoolBusInfoFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        driver_info = (CardView) view.findViewById(R.id.cardView5);
        driver_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fragment_container, new DriversInfoFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        birthday = (CardView) view.findViewById(R.id.cardView6);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fragment_container, new BirthdayNotificationFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
