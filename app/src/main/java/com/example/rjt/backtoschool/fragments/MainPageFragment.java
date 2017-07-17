package com.example.rjt.backtoschool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.adapters.MainPageCardApater;
import com.example.rjt.backtoschool.models.MainPageItem;
import com.example.rjt.backtoschool.models.MainPageItemsList;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/16/2017.
 */

public class MainPageFragment extends Fragment {
    RecyclerView mRecyclerView;
    ArrayList<MainPageItem> mainPageItems = MainPageItemsList.getmInstance();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        Toast.makeText(getContext(), "Main", Toast.LENGTH_SHORT).show();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mainPageRecyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);

        mRecyclerView.setAdapter(new MainPageCardApater(getContext()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
