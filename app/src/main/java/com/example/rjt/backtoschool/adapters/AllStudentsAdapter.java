package com.example.rjt.backtoschool.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.controllers.VolleyController;
import com.example.rjt.backtoschool.fragments.StudentAttendentDetailsFragment;
import com.example.rjt.backtoschool.models.AllStudentList;
import com.example.rjt.backtoschool.models.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by zhangwenpurdue on 7/14/2017.
 */

public class AllStudentsAdapter extends RecyclerView.Adapter<StudentHolder> {
    private Context mContext;
    ArrayList<Student> allStudentList ;
    ArrayList<Integer> profile = new ArrayList<>();
    public AllStudentsAdapter(Context context) {
        this.mContext = context;
        this.allStudentList = AllStudentList.getmInstance();
    }
    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_student, parent, false);
        final StudentHolder holder = new StudentHolder(view);
        addProfile();
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {

        final Student student = AllStudentList.getmInstance().get(position);
        Picasso.with(mContext).load(profile.get(position)).into(holder.mStudentProfile);
        holder.mStudentID.setText(student.getStudentId() + "");
        holder.mStudentName.setText(student.getStudentName());
        holder.mStudentDob.setText(student.getStudentDOB());
        holder.absentBtn.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if (isChecked) {
                    setAbsent(student.getStudentId());
                }

               // Toast.makeText(mContext, "absent", Toast.LENGTH_SHORT).show();
            }
        });
        holder.presentBtn.setOnCheckedChangedListener(new BootstrapButton.OnCheckedChangedListener() {
            @Override
            public void OnCheckedChanged(BootstrapButton bootstrapButton, boolean isChecked) {
                if (isChecked) {
                    setPresent(student.getStudentId());
                }


            }
        });

        holder.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, "more info", Toast.LENGTH_SHORT).show();
                ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new StudentAttendentDetailsFragment()).commit();
            }
        });


    }
    //Init attendance for all the student as present.
    void init() {

    }
    void addProfile() {
        profile.add(R.drawable.pic1);
        profile.add(R.drawable.pic2);
        profile.add(R.drawable.pic3);
        profile.add(R.drawable.pic4);
        profile.add(R.drawable.pic5);
        profile.add(R.drawable.pic6);

    }
    void setAbsent(int studentID) {
        StringBuilder BASE_URL = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_admin/mark_attendance.php?");
        String id = "&studentID=" + new String(studentID + "");
        String attendance = "&attendanceMark=A";
        BASE_URL.append(id);
        BASE_URL.append(attendance);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Attendance Marked")) {
                    Toast.makeText(mContext, "Student marked as absent", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest);
    }
    void setPresent(int studentID) {
        StringBuilder BASE_URL = new StringBuilder("http://rjtmobile.com/aamir/school-mgt/school_admin/mark_attendance.php?");
        String id = "&studentID=" + new String(studentID + "");
        String attendance = "&attendanceMark=P";
        BASE_URL.append(id);
        BASE_URL.append(attendance);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Attendance Marked")) {
                    Toast.makeText(mContext, "Student marked as present", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleyController.getInstance().addToRequestQueue(stringRequest);

    }

    @Override
    public int getItemCount() {
        return allStudentList.size();
    }
}
class StudentHolder extends RecyclerView.ViewHolder {
    TextView mStudentID, mStudentName, mStudentDob;
    BootstrapButton absentBtn, presentBtn;
    ImageView mStudentProfile;
    Button moreInfo;


    public StudentHolder(View itemView) {
        super(itemView);
        moreInfo = (Button) itemView.findViewById(R.id.allStudentMoreInfo);
        mStudentProfile = (ImageView) itemView.findViewById(R.id.profile);
        mStudentID = (TextView) itemView.findViewById(R.id.allStudentID);
        mStudentName = (TextView) itemView.findViewById(R.id.allStudentName);
        absentBtn = (BootstrapButton) itemView.findViewById(R.id.allStudentAbsent);
        presentBtn = (BootstrapButton) itemView.findViewById(R.id.allStudentPresent);
        mStudentDob = (TextView) itemView.findViewById(R.id.allStudentDOB);
    }
}