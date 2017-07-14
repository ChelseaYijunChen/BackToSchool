package com.example.rjt.backtoschool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rjt.backtoschool.R;

public class SplashActivity extends AppCompatActivity implements Runnable{

    Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mThread = new Thread(this);
        mThread.start();

    }

    @Override
    public void run() {
        try
        {
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //Intent intent = new Intent(this, StartPageActivity.class);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
