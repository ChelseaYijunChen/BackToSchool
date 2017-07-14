package com.example.rjt.backtoschool.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.models.AllStudentList;
import com.example.rjt.backtoschool.models.Student;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/14/2017.
 */

public class AllStudentsAdapter extends RecyclerView.Adapter<StudentHolder> {
    private Context mContext;
    ArrayList<Student> allStudentList ;
    public AllStudentsAdapter(Context context) {
        this.mContext = context;
        this.allStudentList = AllStudentList.getmInstance();
    }
    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_student, parent, false);
        final StudentHolder holder = new StudentHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {
        final Student student = AllStudentList.getmInstance().get(position);
        holder.mStudentID.setText(student.getStudentId() + "");
        holder.mStudentName.setText(student.getStudentName());


    }

    @Override
    public int getItemCount() {
        return allStudentList.size();
    }
}
class StudentHolder extends RecyclerView.ViewHolder {
    TextView mStudentID, mStudentName;

    public StudentHolder(View itemView) {
        super(itemView);
        mStudentID = (TextView) itemView.findViewById(R.id.allStudentID);
        mStudentName = (TextView) itemView.findViewById(R.id.allStudentName);
    }
}