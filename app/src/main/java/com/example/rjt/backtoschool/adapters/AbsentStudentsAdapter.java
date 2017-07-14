package com.example.rjt.backtoschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.models.AbsentStudent;
import com.example.rjt.backtoschool.models.AbsentStudentsList;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/14/2017.
 */

public class AbsentStudentsAdapter extends RecyclerView.Adapter<AbsentStudentHolder> {
    private Context mContext;
    ArrayList<AbsentStudent> absentStudentArrayList;
    public AbsentStudentsAdapter(Context context) {
        this.mContext = context;
        this.absentStudentArrayList = AbsentStudentsList.getmInstance();
    }
    @Override
    public AbsentStudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_absent_student, parent, false);
        final AbsentStudentHolder holder = new AbsentStudentHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AbsentStudentHolder holder, int position) {
        final AbsentStudent absentStudent = absentStudentArrayList.get(position);
        holder.mAbsentStudentID.setText(absentStudent.getStudentId() + "");
        holder.mAbsentStudentName.setText(absentStudent.getStudentName());
        holder.mAbsentDate.setText(absentStudent.getAbsentDate());

    }

    @Override
    public int getItemCount() {
        return absentStudentArrayList.size();
    }
}
class AbsentStudentHolder extends RecyclerView.ViewHolder {
    TextView mAbsentStudentID, mAbsentStudentName, mAbsentDate;


    public AbsentStudentHolder(View itemView) {
        super(itemView);
        mAbsentStudentID = (TextView) itemView.findViewById(R.id.absentStudentID);
        mAbsentStudentName = (TextView) itemView.findViewById(R.id.absentStudentName);
        mAbsentDate = (TextView) itemView.findViewById(R.id.absentDate);
    }
}

