package com.example.rjt.backtoschool.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.models.Student;
import com.example.rjt.backtoschool.models.StudentBirthday;
import com.example.rjt.backtoschool.models.StudentBirthdayList;

import org.w3c.dom.Text;

/**
 * Created by zhangwenpurdue on 7/17/2017.
 */

public class BirthdayNotificationAdapter extends RecyclerView.Adapter<BirthdayNotificationViewHolder> {
    @Override
    public BirthdayNotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_birthday_notification, parent, false);
        BirthdayNotificationViewHolder holder = new BirthdayNotificationViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BirthdayNotificationViewHolder holder, int position) {
        StudentBirthday studentBirthday = StudentBirthdayList.getmInstance().get(position);
        holder.mName.setText(studentBirthday.getName() + "name");
        holder.mDOB.setText(studentBirthday.getBirthDay() + "DOB");
        holder.mPhone.setText(studentBirthday.getPhoneNumber() + "phone");

    }

    @Override
    public int getItemCount() {
        return StudentBirthdayList.getmInstance().size();
    }
}
class BirthdayNotificationViewHolder extends RecyclerView.ViewHolder{
    TextView mName, mDOB, mPhone;
    public BirthdayNotificationViewHolder(View itemView) {
        super(itemView);
        mName = (TextView) itemView.findViewById(R.id.birthdayName);
        mDOB = (TextView) itemView.findViewById(R.id.birthday);
        mPhone = (TextView) itemView.findViewById(R.id.birthdayPhone);
    }
}
