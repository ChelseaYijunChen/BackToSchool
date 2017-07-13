package com.example.rjt.backtoschool.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rjt.backtoschool.R;
import com.example.rjt.backtoschool.fragments.SignInFragment;

public class StartPageActivity extends AppCompatActivity implements SignInFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.startPage_fragment_container, new SignInFragment()).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
