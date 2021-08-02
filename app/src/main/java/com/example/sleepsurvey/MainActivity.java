package com.example.sleepsurvey;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDashboard(View v) {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void createAccount(View v) {
        System.out.println("Not implemented yet");
    }
}