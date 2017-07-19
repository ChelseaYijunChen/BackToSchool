package com.example.rjt.backtoschool.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.activities.MainActivity;
import com.example.rjt.backtoschool.rest.ApiClient;
import com.example.rjt.backtoschool.rest.ApiInterface;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpFragment extends Fragment {
    TextView name, fatherName, department, designation, dob, gender,
            address, email, mobile, password, confirmPassword;
    BootstrapButton register;

    public SignUpFragment() {

    }

    public static SignUpFragment newSignUpInstance() {
        SignUpFragment fragment = new SignUpFragment();
        return fragment;
    }

    public void init(View v){
        name = (TextView) v.findViewById(R.id.sign_up_name);
        fatherName = (TextView) v.findViewById(R.id.sign_up_father_name);
        department = (TextView) v.findViewById(R.id.sign_up_department);
        designation = (TextView) v.findViewById(R.id.sign_up_designation);
        dob = (TextView) v.findViewById(R.id.sign_up_dob);
        gender = (TextView) v.findViewById(R.id.sign_up_gender);
        address = (TextView) v.findViewById(R.id.sign_up_address);
        email = (TextView) v.findViewById(R.id.sign_up_email);
        mobile = (TextView) v.findViewById(R.id.sign_up_mobile);
        password = (TextView) v.findViewById(R.id.sign_up_password);
        confirmPassword = (TextView) v.findViewById(R.id.sign_up_confirm_password);
        register = (BootstrapButton) v.findViewById(R.id.register_button);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        init(v);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<ResponseBody> call = apiInterface.register(email.getText().toString(), name.getText().toString(),
                        fatherName.getText().toString(),designation.getText().toString(), department.getText().toString(),
                        dob.getText().toString(), gender.getText().toString(), address.getText().toString(),
                        mobile.getText().toString(), password.getText().toString(),"");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("TAG",response.code()+"");
                        String s = null;
                        try {
                            s = response.body().string();
                            if (s.substring(0,12).equals("successfully")){
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                            } else {
                               Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        call.cancel();
                    }
                });
            }
        });
        return v;
    }

}
